import { readFileSync, writeFileSync, mkdirSync, rmSync } from "fs";
import { resolve, dirname } from "path";

const basePackage = "io.lenra.app.gen";
const basePath = "src/main/java/";

const baseIndentation = "  ";

const packagePath = resolve(basePath, ...basePackage.split("."));

rmSync(packagePath, { recursive: true, force: true });

const schemata = [
  "manifest.schema.json",
  // "requests/app.schema.json",
  // "responses/view.schema.json",
];

abstract class Element {
  static files: Element[] = []
  private static sourceRefs: { [ref: string]: Element } = {}
  private static currentFileSchema: any
  private static currentFileSchemaPath: any

  readonly source: string
  readonly parent: ElementParent
  readonly name: string
  protected imports: Set<string> = new Set()
  protected annotations: Set<string> = new Set()
  protected implements: Set<Interface> = new Set()
  protected children: Set<Element> = new Set()

  constructor(parent: ElementParent, name: string, source: string) {
    this.name = name;
    this.source = source;
    this.parent = parent;
  }

  get parentFullName(): string {
    if (this.parent instanceof Element)
      return this.parent.fullName;
    else
      return this.parent;
  }

  get fullName(): string {
    return `${this.parentFullName}.${this.name}`;
  }

  addImport(def: string) {
    if (this.parent instanceof Class) {
      this.parent.addImport(def)
    }
    else {
      this.imports.add(def)
    }
  }

  addAnnotation(def: string) {
    this.annotations.add(def)
  }

  addImplements(def: Interface) {
    this.implements.add(def)
  }

  addChild(def: Element) {
    this.children.add(def)
  }

  generate(): string {
    return this.generateLines().join("\n") + "\n";
  }

  private generateLines(): string[] {
    let content: string[] = [];

    if (!(this.parent instanceof Element)) {
      content.push(`package ${this.parent};`, "");
      if (this.imports.size > 0) {
        content.push(
          ...[...this.imports]
            // Filter same package imports
            .filter(i => i.split(".").slice(0, -1).join(".") !== this.parent)
            .sort()
            .map(i => `import ${i};`),
          "",
        );
      }
    }
    if (this.annotations.size > 0) {
      content.push(...[...this.annotations].sort());
    }
    content.push(this.generateBlockDeclaration() + " {");

    // Add fields
    if (this instanceof Class) {
      content.push(baseIndentation + "// Fields");
      [...this.fields]
        .sort((a, b) => a.name.localeCompare(b.name))
        .forEach(f =>
          content.push(
            ...f.generateLines()
              .map(l => indent(l, baseIndentation)
              )
          )
        );
    }

    // Add sub elements
    if (this.children.size > 0) {
      content.push(baseIndentation + "// Sub elements", "");
      [...this.children]
        .sort((a, b) => a.name.localeCompare(b.name))
        .forEach(f =>
          content.push(
            ...f.generateLines()
              .map(l => indent(l, baseIndentation)
              )
          )
        );
    }

    content.push("}");
    return content;
  }

  abstract generateBlockDeclaration(): string

  static parse(fileSchema: string, parent?: Element): Element {
    // if (this.sourceRefs[ref]) return this.sourceRefs[ref];
    // TODO: save the schema for the file path
    this.currentFileSchema = JSON.parse(readFileSync(resolve("api", fileSchema), "utf-8"));
    const ref = "#";
    const schema = this.getSchemaForRef(ref);
    const element = this.parseSchema(schema, ref, parent);

    if (element instanceof Element) {
      this.sourceRefs[fileSchema] = element;
      delete this.sourceRefs[ref];
      return element;
    }
    else {
      console.log("Error", ref, element);
      throw new Error(`The ref ${ref} is not an element.`);
    }
  }

  static getSchemaForRef(ref: string): any {
    const refParts = ref.split("/");
    if (refParts.shift() !== "#") throw new Error(`Invalid ref: ${ref}. External schemata are not supported`);
    const schema = refParts.reduce((schema, path) => schema[path], this.currentFileSchema);
    if (schema === undefined) throw new Error(`Invalid ref: ${ref}. Schema not found`);
    return schema;
  }

  private static parseSchema(schema: any, ref: string, parent?: Element): Element | { name: string, imports?: string[], finalValue?: string } {
    console.log("Parsing schema for", ref);
    switch (schema.type) {
      case "string":
        return { name: "String" };
      case "integer":
        return { name: "Integer" };
      case "number":
        return { name: "Double" };
      case "boolean":
        return { name: "Boolean" };

      case "object":
        if (!schema.properties) {
          return { name: "HashMap<String, Object>", imports: ["java.util.HashMap"] };
        }
        // generate a sub class for the object
        return this.parseClass(schema, ref, parent);

      case "array":
        const subType = this.parseSchema(schema.items, ref);
        const ret = { name: `List<${subType.name}>`, imports: ["java.util.List"] };
        if (subType instanceof Element)
          ret.imports.push(subType.fullName);
        else
          ret.imports.push(...(subType.imports ?? []));
        return ret;

      default:

        if (schema.$ref) {
          return this.parseSchema(this.getSchemaForRef(schema.$ref), schema.$ref);
        }

        if (schema.const) {
          switch (typeof schema.const) {
            case "number":
              return { name: "Double", finalValue: schema.const.toString() };
            case "boolean":
              return { name: "Boolean", finalValue: schema.const.toString() };
            case "string":
              return { name: "String", finalValue: `"${schema.const}"` };
          }
        }

        if (schema.oneOf) {
          console.log("Generating interface for", ref);
        }

        throw new Error(`Unknown type: ${schema.type}`);
    }
  }

  private static parseClass(schema: any, ref: string, parent?: Element): Class {
    if (this.sourceRefs[ref] instanceof Class) return this.sourceRefs[ref] as Class;
    if (this.sourceRefs[ref]) throw new Error(`Invalid ref: ${ref}. Element already exists but it's not a class`);
    if (!schema.properties) throw new Error(`Invalid schema: ${ref}. No properties found`);

    const { name, package: packageName } = this.getClassInfoForRef(ref);

    const element = new Class(parent ?? packageName, schema.title ?? name, ref);

    this.sourceRefs[ref] = element;
    if (!parent) this.files.push(element);

    Object.entries(schema.properties)
      .forEach(([propertyName, propertySchema]) => {
        const fieldType = this.parseSchema(propertySchema, `${ref}.${propertyName} `, element);
        const normalizedPropertyName = propertyName.replace(/^(.*)[^a-zA-Z0-9]([a-zA-Z0-9])/g, (_, before, c) => before.length > 0 ? c.toUpperCase() : c);
        const field = new Field();
        field.name = normalizedPropertyName;
        if (fieldType instanceof Element) {
          element.addImport(fieldType.fullName);
          field.type = fieldType.name;
        }
        else {
          const { name, imports, finalValue } = fieldType;
          field.type = name;
          imports?.forEach(i => element.addImport(i));
          field.finalValue = finalValue;
        }
        element.addField(field);
      });

    return element;
  }

  private static getClassInfoForRef(ref: string): { name: string, package: string } {
    const refParts = ref.split("/");
    if (refParts.shift() !== "#") throw new Error(`Invalid ref: ${ref}`);
    const refPath = refParts.pop() ?? "";
    const packageParts = refPath.split(".");
    const name = packageParts.pop()!;

    return {
      name: `${name.substring(0, 1).toUpperCase()}${name.substring(1)}`,
      package: packageParts.length > 0 ? `${basePackage}.${packageParts.join(".")}` : basePackage
    };
  }
}

type ElementParent = Package | Element;

class Class extends Element {
  extends?: Class
  fields: Set<Field> = new Set()

  addField(field: Field) {
    this.fields.add(field);
  }

  generate(): string {
    if (this.extends === undefined) {
      this.addImport("com.fasterxml.jackson.annotation.JsonInclude");
      this.addAnnotation("@JsonInclude(JsonInclude.Include.NON_NULL)");

      this.addImport("lombok.Data");
      this.addAnnotation("@Data");
    }
    return super.generate();
  }

  generateBlockDeclaration(): string {
    let declaration = "public ";
    if (this.parent instanceof Class) {
      declaration += "static ";
    }
    declaration += `class ${this.name}`;
    if (this.extends) {
      declaration += ` extends ${this.extends.name}`;
    }
    if (this.implements.size > 0) {
      declaration += ` implements ${[...this.implements].map(i => i.name).sort().join(", ")}`;
    }
    return declaration;
  }
}

class Interface extends Element {
  private implementations: Set<Class>;

  addImplementation(impl: Class) {
    if (!this.implementations) this.implementations = new Set();
    this.implementations.add(impl);
  }

  generate(): string {
    if (this.implementations?.size ?? 0 > 0) {
      this.addImport("com.fasterxml.jackson.annotation.JsonTypeInfo");
      this.addImport("com.fasterxml.jackson.annotation.JsonTypeInfo.Id");
      this.addAnnotation(`@JsonTypeInfo(use = Id.DEDUCTION, defaultImpl = ManifestRequest.class)`);

      this.addImport("com.fasterxml.jackson.annotation.JsonSubTypes");
      this.addImport("com.fasterxml.jackson.annotation.JsonSubTypes.Type");
      this.implementations.forEach(i => this.addImport(i.name));
      this.addAnnotation(`@JsonSubTypes({ ${[...this.implementations]
        .map(i => {
          this.addImport(i.fullName);
          return `@Type(${i.name}.class)`;
        })
        .join(", ")
        } })`);
    }

    return super.generate();
  }

  generateBlockDeclaration(): string {
    let declaration = "public ";
    if (this.parent instanceof Class) {
      declaration += "static ";
    }
    declaration += `interface ${this.name}`;
    if (this.implements.size > 0) {
      declaration += ` extends ${[...this.implements].map(i => i.name).sort().join(", ")}`;
    }
    return declaration;
  }
}

type Package = string;

class Field {
  name: string
  type: string
  finalValue?: string
  annotations: string[] = []

  generateLines(): string[] {
    let property = `${this.type} ${this.name}`;
    if (this.finalValue) property = `final ${property} = ${this.finalValue}`;
    property = `private ${property};`;
    return [
      ...this.annotations,
      property
    ];
  }
}

rmSync(packagePath, { recursive: true, force: true });

for (let i = 0; i < schemata.length; i++) {
  Element.parse(schemata[i]);
}

Element.files.forEach(f => {
  const filePath = resolve(basePath, ...f.parentFullName.split("."), `${f.name}.java`);
  mkdirSync(dirname(filePath), { recursive: true });
  writeFileSync(filePath, f.generate());
});

function indent(content: string, prefix: string): string {
  if (content.length === 0) return content;
  return content.split("\n").map(l => prefix + l).join("\n");
}