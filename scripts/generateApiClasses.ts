import { readFileSync, writeFileSync, mkdirSync, rmSync } from "fs";
import { resolve, dirname } from "path";

const basePackage = "io.lenra.api";
const sourceBasePath = process.argv[2] ?? "src/main/java";
const generatedBasePath = process.argv[3] ?? "build/test/lenraApi";

const baseIndentation = "  ";

const packagePath = resolve(generatedBasePath, ...basePackage.split("."));

rmSync(generatedBasePath, { recursive: true, force: true });

const langPackage = "java.lang";

const viewSchama = "responses/view.schema.json";
const schemata = [
  "manifest.schema.json",
  "requests/app.schema.json",
  viewSchama,
];

type RenamedKeys<T extends { [P in keyof T]: T[P] }, P extends string = string> = {
  [K in keyof T as `${P}${Capitalize<string & K>}`]: T[K]
}

function renameKeys<T extends { [P in keyof T]: T[P] }, P extends string = string>(obj: T, prefix: P): RenamedKeys<T, P> {
  return Object.fromEntries(
    Object.entries(obj)
      .map(([k, v]) => [`${prefix}${k.substring(0, 1).toUpperCase()}${k.substring(1)}`, v])
  ) as RenamedKeys<T, P>;
}

type Package = string;
type AccessModifier = "public" | "protected" | "private" | null;

class ClassInfos {
  static primitives = {
    string: new ClassInfos(langPackage, "String"),
    integer: new ClassInfos(langPackage, "Integer"),
    number: new ClassInfos(langPackage, "Double"),
    boolean: new ClassInfos(langPackage, "Boolean"),
  }
  static base = {
    ...this.primitives,
    object: new ClassInfos(langPackage, "Object"),
    list: new ClassInfos("java.util", "List"),
    map: new ClassInfos("java.util", "Map"),
    arrayList: new ClassInfos("java.util", "ArrayList"),
    hashMap: new ClassInfos("java.util", "HashMap"),
  }
  private static jacksonBase = {
    jsonInclude: new ClassInfos("com.fasterxml.jackson.annotation", "JsonInclude"),
    jsonTypeInfo: new ClassInfos("com.fasterxml.jackson.annotation", "JsonTypeInfo"),
    jsonSubTypes: new ClassInfos("com.fasterxml.jackson.annotation", "JsonSubTypes"),
    jsonProperty: new ClassInfos("com.fasterxml.jackson.annotation", "JsonProperty"),
  }
  private static jacksonSubTypes = {
    jsonTypeInfoId: new ClassInfos(this.jacksonBase.jsonTypeInfo, "Id"),
    jsonSubTypesType: new ClassInfos(this.jacksonBase.jsonSubTypes, "Type"),
  }
  static jackson = {
    ...this.jacksonBase,
    ...this.jacksonSubTypes,
  }
  static lombokBase = {
    data: new ClassInfos("lombok", "Data"),
    getter: new ClassInfos("lombok", "Getter"),
    setter: new ClassInfos("lombok", "Setter"),
    // builder: new ClassInfos("lombok", "Builder"),
    singular: new ClassInfos("lombok", "Singular"),
    noArgsConstructor: new ClassInfos("lombok", "NoArgsConstructor"),
    requiredArgsConstructor: new ClassInfos("lombok", "RequiredArgsConstructor"),
    allArgsConstructor: new ClassInfos("lombok", "AllArgsConstructor"),
    nonNull: new ClassInfos("lombok", "NonNull"),
  }
  static lombokSubTypes = {
    // builderDefault: new ClassInfos(this.lombokBase.builder, "Default"),
  }
  static lombok = {
    ...this.lombokBase,
  }
  static lenra = {
    filler: new ClassInfos("io.lenra.app.view", "Filler"),
  }
  static refs = {
    ...this.base,
    ...renameKeys(this.jackson, "jackson"),
    ...renameKeys(this.lombok, "lombok"),
  }

  readonly name: string
  readonly parent: ElementParent
  readonly subTypes?: ClassInfos[]

  constructor(parent: ElementParent, name: string, subTypes?: ClassInfos[]) {
    this.name = name;
    this.parent = parent;
    this.subTypes = subTypes;
  }

  get parentFullName(): string {
    return this.parent instanceof ClassInfos ? this.parent.fullName : this.parent;
  }

  get fullName(): string {
    return `${this.parentFullName}.${this.name}`;
  }

  get baseElement(): ClassInfos {
    return this;
  }

  clone(subTypes?: ClassInfos[]): ClassInfos {
    return new ClassInfos(this.parent, this.name, subTypes);
  }

  formatName(): string {
    let name = this.name;
    let parent = this.parent;
    while (parent instanceof ClassInfos) {
      name = `${parent.name}.${name}`;
      parent = parent.parent;
    }
    if (this.subTypes) {
      name += `<${this.subTypes.map(t => t.formatName()).join(", ")}>`;
    }
    return name;
  }

  instanceof(def: ClassInfos): boolean {
    return this === def || (this.parent === def.parent && this.name === def.name);
  }
}

class ConstValue {
  readonly type: ClassInfos
  readonly value: string

  constructor(type: ClassInfos, value: string) {
    this.type = type;
    this.value = value;
  }
}

abstract class Element extends ClassInfos {
  static files: Element[] = []
  private static sourceRefs: { [ref: string]: Element } = {}
  private static currentFileSchema: any

  accessModifier: AccessModifier = "public"
  readonly source: string
  protected imports: Set<ClassInfos> = new Set()
  protected annotations: Set<string> = new Set()
  protected implements: Set<Interface> = new Set()
  protected children: Set<Element> = new Set()

  constructor(parent: ElementParent, name: string, source: string) {
    super(parent, name);
    this.source = source;
  }

  get baseElement(): ClassInfos {
    return this.parent instanceof ClassInfos ? this.parent.baseElement : this;
  }

  addImport(def: ClassInfos) {
    if (this.parent instanceof Element) {
      this.parent.addImport(def)
    }
    else {
      this.imports.add(def);
      if (def.subTypes) {
        def.subTypes.forEach(t => this.addImport(t));
      }
    }
  }

  addAnnotation(def: string) {
    this.annotations.add(def)
  }

  addImplements(def: Interface) {
    this.addImport(def);
    this.implements.add(def)
  }

  addChild(def: Element) {
    this.children.add(def)
  }

  generate(): string {
    return this.generateLines().join("\n") + "\n";
  }

  protected generateLines(): string[] {
    let content: string[] = [];

    if (!(this.parent instanceof Element)) {
      content.push(`package ${this.parent};`, "");
      if (this.imports.size > 0) {
        content.push(
          ...new Set([...this.imports]
            // Filter same package imports
            .filter(i => i.baseElement.parent !== this.baseElement.parent && i.parent !== langPackage)
            .sort((a, b) => a.fullName.localeCompare(b.fullName))
            .map(i => `import ${i.fullName};`)),
          "",
        );
      }
    }
    if (this.annotations.size > 0) {
      // content.push(...[...this.annotations].sort());
      content.push(...this.annotations);
    }
    content.push(this.generateBlockDeclaration() + " {");

    content.push(
      ...this.generateContentLines()
        .map(l => indent(l, baseIndentation))
    );

    content.push("}");
    return content;
  }

  protected generateContentLines(): string[] {
    let content: string[] = [];

    // Add sub elements
    if (this.children.size > 0) {
      content.push("", "// Sub elements", "");
      [...this.children]
        .sort((a, b) => a.name.localeCompare(b.name))
        .forEach(f =>
          content.push(
            ...f.generateLines(),
            ""
          )
        );
    }

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

  private static parseSchema(schema: any, ref: string, parent?: Element, forceElement?: boolean): ClassInfos | ConstValue {
    if (schema.enum) {
      return this.parseEnum(schema, ref, parent);
    }

    if (schema.type in ClassInfos.primitives) return ClassInfos.primitives[schema.type];
    switch (schema.type) {
      case "object":
        if (!schema.properties && !forceElement) {
          return ClassInfos.refs.map.clone([ClassInfos.primitives.string, ClassInfos.refs.object]);
        }
        // generate a sub class for the object
        const element = this.parseClass(schema, ref, parent);
        if (element.fields.size === 0) {
          element.extends = ClassInfos.refs.hashMap.clone([ClassInfos.primitives.string, ClassInfos.refs.object]);
          element.addImport(element.extends);
        }
        return element;

      case "array":
        let generatedClass: Class | undefined;
        // if (schema.title) {
        //   generatedClass = this.parseClass(schema, ref, parent);
        //   parent = generatedClass;
        // }
        const subType = this.parseSchema(schema.items, `${ref}.items`, parent);
        if (subType instanceof ConstValue) throw new Error(`Invalid array type: ${ref}. Array items cannot be a const`);
        const array = ClassInfos.refs.list.clone([subType]);
        // if (generatedClass) {
        //   generatedClass.extends = array;
        //   return generatedClass;
        // }
        return array;

      default:

        if (schema.$ref) {
          return this.parseSchema(this.getSchemaForRef(schema.$ref), schema.$ref, undefined, forceElement);
        }

        if (schema.const) {
          const classRef = ClassInfos.primitives[typeof schema.const];
          if (!classRef) throw new Error(`Invalid const type: ${schema.const}[${typeof schema.const}]`);
          return new ConstValue(classRef, JSON.stringify(schema.const));
        }

        if (schema.oneOf) {
          return this.parseOneOf(schema, ref, parent);
        }

        throw new Error(`Unknown type: ${schema.type}`);
    }
  }

  private static parseClass(schema: any, ref: string, parent?: Element): Class {
    if (this.sourceRefs[ref] instanceof Class) return this.sourceRefs[ref] as Class;
    if (this.sourceRefs[ref]) throw new Error(`Invalid ref: ${ref}. Element already exists but it's not a class`);

    // Create the class
    const { name, parent: packageName } = this.getClassFromRef(ref);
    const element = new Class(parent ?? packageName, schema.title ?? name, ref);

    // Add the class to the sourceRefs
    this.sourceRefs[ref] = element;
    if (parent)
      parent.addChild(element);
    else
      this.files.push(element);

    // Add the fields
    if (schema.properties) {
      const required = schema.required ?? [];
      Object.entries(schema.properties)
        .forEach(([propertyName, propertySchema]) => {
          const res = this.parseSchema(propertySchema, `${ref}.${propertyName} `, element);
          const fieldType: ClassInfos = res instanceof ConstValue ? res.type : res;
          const normalizedPropertyName = propertyName.replace(/^(.*)[^a-zA-Z0-9]([a-zA-Z0-9])/g, (_, before, c) => before.length > 0 ? c.toUpperCase() : c);
          const field = new Field();
          field.name = normalizedPropertyName;
          if (normalizedPropertyName !== propertyName) {
            element.addImport(ClassInfos.jackson.jsonProperty);
            field.annotations.push(`@JsonProperty("${propertyName}")`);
          }
          element.addImport(fieldType);
          field.type = fieldType;
          if (res instanceof ConstValue) {
            field.finalValue = res.value;
          }
          else if (required.includes(propertyName)) {
            element.addImport(ClassInfos.lombok.nonNull);
            field.annotations.push("@NonNull");
          }
          if (fieldType.instanceof(ClassInfos.refs.list) || fieldType.instanceof(ClassInfos.refs.map)) {
            element.addImport(ClassInfos.lombok.singular);
            let annotation = "@Singular";
            if (!normalizedPropertyName.endsWith("s")) {
              annotation += `("${normalizedPropertyName}Item")`;
            }
            field.annotations.push(annotation);
          }
          if (field.finalValue === undefined) {
            // Builder methods
            const setterName = `set${normalizedPropertyName.substring(0, 1).toUpperCase()}${normalizedPropertyName.substring(1)}`;
            const method = new Method();
            method.name = normalizedPropertyName;
            method.parameters.push({ name: normalizedPropertyName, type: fieldType });
            method.returnType = element;
            method.content = [
              `this.${setterName}(${normalizedPropertyName});`,
              `return this;`
            ];
            element.addMethod(method);
          }
          // if (fieldType.instanceof(ClassInfos.refs.map) && fieldType.subTypes?.[0].instanceof(ClassInfos.base.string)) {
          //   const setter = new Method();
          //   setter.name = `set${normalizedPropertyName.substring(0, 1).toUpperCase()}${normalizedPropertyName.substring(1)}`;
          //   setter.parameters.push({ name: normalizedPropertyName, type: ClassInfos.base.object });
          //   setter.content.push("var mapper = new com.fasterxml.jackson.databind.ObjectMapper();");
          //   setter.content.push(`this.${normalizedPropertyName} = mapper.convertValue(${normalizedPropertyName}, new com.fasterxml.jackson.core.type.TypeReference<${fieldType.formatName()}>() { });`);
          //   element.addMethod(setter);
          // }
          element.addField(field);
        });
      element.addImport(ClassInfos.refs.jacksonJsonInclude);
      element.addAnnotation("@JsonInclude(JsonInclude.Include.NON_NULL)");

      element.addImport(ClassInfos.refs.lombokGetter);
      element.addAnnotation("@Getter");

      element.addImport(ClassInfos.refs.lombokSetter);
      element.addAnnotation("@Setter");

      // element.addImport(ClassInfos.refs.lombokBuilder);
      // element.addAnnotation("@Builder");

      element.addImport(ClassInfos.refs.lombokNoArgsConstructor);
      element.addAnnotation("@NoArgsConstructor");

      element.addImport(ClassInfos.refs.lombokAllArgsConstructor);
      element.addAnnotation("@AllArgsConstructor");

      // Needed for builder, but if all args are non null, it conflicts with the RequiredArgsConstructor
      const fields = [...element.fields];
      const nonNullOrFinalFields = fields.filter(f => f.annotations.includes("@NonNull") || f.finalValue !== undefined);
      const nonNullFields = fields.filter(f => f.annotations.includes("@NonNull"));
      if (nonNullFields.length > 0 && nonNullOrFinalFields.length < fields.length) {
        element.addImport(ClassInfos.refs.lombokRequiredArgsConstructor);
        element.addAnnotation("@RequiredArgsConstructor");
      }
    }

    return element;
  }

  private static parseOneOf(schema: any, ref: string, parent?: Element): Interface {
    if (this.sourceRefs[ref] instanceof Interface) return this.sourceRefs[ref] as Interface;
    if (this.sourceRefs[ref]) throw new Error(`Invalid ref: ${ref}. Element already exists but it's not an Interface`);

    const { name, parent: packageName } = this.getClassFromRef(ref);

    const element = new Interface(parent ?? packageName, schema.title ?? name, ref);

    this.sourceRefs[ref] = element;
    if (parent)
      parent.addChild(element);
    else
      this.files.push(element);


    const implementations: ClassInfos[] = [];
    schema.oneOf.forEach((subSchema: any, i: number) => {
      const subElement = this.parseSchema(subSchema, `${ref}.oneOf.${i}`, element, true);
      if (subElement instanceof Element) {
        implementations.push(subElement);
        element.addImport(subElement);
        subElement.addImplements(element);
      }
      else {
        throw new Error(`Invalid schema: ${ref}.oneOf.${i}. OneOf element is not an Element`);
      }
    });

    element.addImport(ClassInfos.jackson.jsonTypeInfo);
    element.addImport(ClassInfos.jackson.jsonTypeInfoId);
    element.addAnnotation(`@JsonTypeInfo(use = Id.DEDUCTION, defaultImpl = ${implementations[implementations.length - 1].name}.class)`);

    element.addImport(ClassInfos.jackson.jsonSubTypes);
    element.addImport(ClassInfos.jackson.jsonSubTypesType);

    element.addAnnotation(`@JsonSubTypes({ ${implementations
      .map(i => {
        element.addImport(i);
        return `@Type(${i.name}.class)`;
      })
      .join(", ")
      } })`);

    return element;
  }

  private static parseEnum(schema: any, ref: string, parent?: Element): Enum {
    if (this.sourceRefs[ref] instanceof Enum) return this.sourceRefs[ref] as Enum;
    if (this.sourceRefs[ref]) throw new Error(`Invalid ref: ${ref}. Element already exists but it's not an Enum`);
    if (!schema.enum) throw new Error(`Invalid schema: ${ref}. Enum schema must have an enum property`);

    const { name, parent: packageName } = this.getClassFromRef(ref);

    const element = new Enum(parent ?? packageName, schema.title ?? name, ref);

    this.sourceRefs[ref] = element;
    if (parent)
      parent.addChild(element);
    else
      this.files.push(element);

    element.addImport(ClassInfos.jackson.jsonProperty);

    schema.enum.forEach((value: string) => {
      // Transform name to upper snake case
      const normalizedValue = value.replace(/([a-z])([A-Z])/g, "$1_$2").toUpperCase();
      element.addValue(new EnumValue(normalizedValue, [`@JsonProperty("${value}")`]));
    });

    return element;
  }

  private static getClassFromRef(ref: string): ClassInfos {
    const refParts = ref.split("/");
    if (refParts.shift() !== "#") throw new Error(`Invalid ref: ${ref}`);
    const refPath = refParts.pop() ?? "";
    const packageParts = refPath.split(".");
    const name = packageParts.pop()!;

    return new ClassInfos(
      packageParts.length > 0 ? `${basePackage}.${packageParts.join(".").toLowerCase().replace(/[^a-z0-9.]/g, '_')}` : basePackage,
      `${name.substring(0, 1).toUpperCase()}${name.substring(1)}`
    );
  }
}

type ElementParent = Package | ClassInfos;

class Class extends Element {
  extends?: ClassInfos
  fields: Set<Field> = new Set()
  methods: Set<Method> = new Set()

  addField(field: Field) {
    this.fields.add(field);
  }

  addMethod(method: Method) {
    this.methods.add(method);
  }

  protected generateContentLines(): string[] {
    let content: string[] = [];

    // Add fields
    if (this.fields.size > 0) {
      content.push("// Fields");
      const mapFields: Field[] = [];
      this.fields.forEach(f => {
        content.push(
          ...f.generateLines()
        );
        if (f.finalValue === undefined && f.type.instanceof(ClassInfos.base.map))
          mapFields.push(f);
      });
    }

    // Add methods
    const instanceMethods = [...this.methods].filter(m => !m.static);
    if (instanceMethods.length > 0) {
      content.push("", "// Methods");
      instanceMethods.forEach(m => {
        content.push(
          ...m.generateLines(),
          ""
        );
      });
    }
    const staticMethods = [...this.methods].filter(m => m.static);
    if (staticMethods.length > 0) {
      content.push("", "// Static methods");
      staticMethods.forEach(m => {
        content.push(
          ...m.generateLines(),
          ""
        );
      });
    }

    content.push(...super.generateContentLines());

    return content;
  }

  generateBlockDeclaration(): string {
    let declaration = "";
    if (this.accessModifier !== null)
      declaration += `${this.accessModifier} `;
    if (this.parent instanceof Element) {
      declaration += "static ";
    }
    declaration += `class ${this.name}`;
    if (this.extends) {
      declaration += ` extends ${this.extends.formatName()}`;
    }
    if (this.implements.size > 0) {
      declaration += ` implements ${[...this.implements].map(i => i.formatName()).sort().join(", ")}`;
    }
    return declaration;
  }
}

class Interface extends Element {
  generateBlockDeclaration(): string {
    let declaration = "";
    if (this.accessModifier !== null)
      declaration += `${this.accessModifier} `;
    if (this.parent instanceof Element) {
      declaration += "static ";
    }
    declaration += `interface ${this.name}`;
    if (this.implements.size > 0) {
      declaration += ` extends ${[...this.implements].map(i => i.name).sort().join(", ")}`;
    }
    return declaration;
  }
}

class EnumValue {
  annotations: string[]
  name: string
  arguments: string[] = []

  constructor(name: string, annotations: string[] = []) {
    this.name = name;
    this.annotations = annotations;
  }
}

class Enum extends Element {
  values: EnumValue[] = []

  addValue(value: EnumValue) {
    this.values.push(value);
  }

  generateBlockDeclaration(): string {
    let declaration = "";
    if (this.accessModifier !== null)
      declaration += `${this.accessModifier} `;
    if (this.parent instanceof Element) {
      declaration += "static ";
    }
    declaration += `enum ${this.name}`;

    return declaration;
  }

  protected generateContentLines(): string[] {
    const content: string[] = [];

    if (this.values.length > 0) {
      content.push("// Values");
      this.values
        .forEach((v, i, a) => {
          content.push(...v.annotations);
          content.push(v.name + (i < a.length - 1 ? "," : ";"));
        });
    }

    content.push(...super.generateContentLines());

    return content;
  }
}

class Field {
  name: string
  type: ClassInfos
  finalValue?: string
  annotations: string[] = []

  generateLines(): string[] {
    let property = `${this.type.formatName()} ${this.name}`;
    if (this.finalValue) property = `final ${property} = ${this.finalValue}`;
    property = `private ${property};`;
    return [
      ...this.annotations,
      property
    ];
  }
}

interface Parameter {
  name: string
  type: ClassInfos
}

class Method {
  accessModifier: AccessModifier = "public"
  name: string
  returnType?: ClassInfos
  parameters: Parameter[] = []
  content: string[] = []
  static: boolean = false

  generateLines(): string[] {
    let content: string[] = [];
    let declaration = "";
    if (this.accessModifier !== null)
      declaration += `${this.accessModifier} `;
    if (this.static) declaration += "static ";
    declaration += `${this.returnType ? this.returnType.formatName() : "void"} ${this.name}(`;
    if (this.parameters.length > 0) {
      declaration += this.parameters.map(p => `${p.type.formatName()} ${p.name}`).join(", ");
    }
    declaration += ") {";
    content.push(declaration);
    content.push(...this.content.map(l => indent(l, baseIndentation)));
    content.push("}");
    return content;
  }
}

function indent(content: string, prefix: string): string {
  if (content.length === 0) return content;
  return content.split("\n").map(l => prefix + l).join("\n");
}

function generateComponentsClass() {
  const componentsClass = new Class(`${basePackage}.components`, "Components", "");
  componentsClass.addImport(ClassInfos.lenra.filler);
  // get all components classes
  Element.files
    .filter(f => f instanceof Class && f.parent === `${basePackage}.components`)
    .map(c => c as Class)
    // for each class, generate 2 static methods: one with the same arguments as the constructor and another adding a filler
    .forEach(c => {
      const parameters = [...c.fields]
        // not final
        .filter(f => f.finalValue === undefined)
        // having the @NonNull annotation
        .filter(f => f.annotations.includes("@NonNull"))
        .map(f => ({ name: f.name, type: f.type }));

      componentsClass.addImport(c);
      parameters.forEach(p => componentsClass.addImport(p.type));

      let methodName = c.name.substring(0, 1).toLowerCase() + c.name.substring(1);

      let method = new Method();
      method.static = true;
      method.name = methodName;
      method.returnType = c;
      method.parameters = [...parameters];
      method.content.push(`return new ${c.name}(${parameters.map(f => f.name).join(", ")});`);
      componentsClass.addMethod(method);

      method = new Method();
      method.static = true;
      method.name = methodName;
      method.returnType = c;
      method.parameters = [...parameters, { name: "filler", type: ClassInfos.lenra.filler.clone([c]) }];
      method.content.push(`var ret = new ${c.name}(${parameters.map(f => f.name).join(", ")});`);
      method.content.push("filler.fill(ret);");
      method.content.push("return ret;");
      componentsClass.addMethod(method);
    });
  Element.files.push(componentsClass);
}

rmSync(packagePath, { recursive: true, force: true });

for (let i = 0; i < schemata.length; i++) {
  Element.parse(schemata[i]);
}

// generateComponentsClass();

Element.files.forEach(f => {
  const filePath = resolve(generatedBasePath, ...f.parentFullName.split("."), `${f.name}.java`);
  mkdirSync(dirname(filePath), { recursive: true });
  writeFileSync(filePath, f.generate());
});

// const mainSchema = JSON.parse(readFileSync(resolve("api", viewSchama), "utf-8"));

// const componentList = new Set([
//   ...mainSchema.definitions["components.lenra"].oneOf,
//   ...mainSchema.definitions["components.json"].oneOf,
// ].map(c => c.$ref));
