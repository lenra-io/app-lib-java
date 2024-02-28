import { readFileSync, writeFileSync, mkdirSync, rmSync } from "fs";
import { resolve, dirname } from "path";

const basePackage = "io.lenra.app.gen";
const basePath = "src/main/java/";

const packagePath = resolve(basePath, ...basePackage.split("."));

rmSync(packagePath, { recursive: true, force: true });

const schemata = [
  "manifest.schema.json",
  // "requests/app.schema.json",
  // "responses/view.schema.json",
];

var globalSchema: any;

for (let i = 0; i < schemata.length; i++) {
  const schemaPath = schemata[i];

  globalSchema = JSON.parse(readFileSync(resolve("api", schemaPath), "utf-8"));

  // Generate the Java classes
  generateJavaClass(globalSchema);

  for (const ref in globalSchema.definitions) {
    if (Object.prototype.hasOwnProperty.call(globalSchema.definitions, ref)) {
      const schema = globalSchema.definitions[ref];
      generateJavaClass(schema, `#/definitions/${ref}`);
    }
  }
}

function generateJavaClass(schema: any, path: string = "#") {
  const { className, fullName } = getClassForRef(path);
  const packageName = fullName.split(".").slice(0, -1).join(".");
  console.log("Generating class for", fullName);

  // Generate the Java class with lombok and Jackson annotations only if needed

  const { type, imports: typeImports } = generateFieldType(schema, path);

  let extendType = "";

  const { content, imports: fieldsImports } = generateFields(schema, path);
  let classContent = `package ${packageName};\n\n`;

  const annotations:Set<string> = new Set();

  const imports:Set<string> = new Set();

  if (type === "Object") {
    imports.add("com.fasterxml.jackson.annotation.JsonInclude");
    imports.add("lombok.Data");
    fieldsImports.forEach((i) => imports.add(i));

    annotations.add("@JsonInclude(JsonInclude.Include.NON_NULL)");
    annotations.add("@Data");
  }
  else {
    extendType = `extends ${type}`;
    classContent += typeImports.map((i) => `import ${i};`).join("\n");
  }

  classContent += `
${
  [...imports]
  .sort()
  .filter((i) => packageName !== i.split(".").slice(0, -1).join("."))// Remove the current package
  .map((i) => `import ${i};`).join("\n")
}

${[...annotations].sort().join("\n")}
public class ${ className } ${extendType}{
${content}
}
`;

  const classPath = resolve(basePath, ...packageName.split("."), `${className}.java`);

  mkdirSync(dirname(classPath), { recursive: true });

  console.log("Writing to", classPath);
  writeFileSync(classPath, classContent);
}

function generateFields(schema: any, path: string): { content: string, imports: string[] } {
  const fields = [];
  const imports: Set<string> = new Set();
  if (schema.properties) {
    Object.entries(schema.properties).forEach(([propertyName, propertySchema]) => {
      const { type, imports: typeImports, finalValue } = generateFieldType(propertySchema, `${path}.${propertyName} `);
      const normalizedPropertyName = propertyName.replace(/^(.*)[^a-zA-Z0-9]([a-zA-Z0-9])/g, (_, before, c) => before.length > 0 ? c.toUpperCase() : c);
      let property = `${type} ${normalizedPropertyName}`;
      if (finalValue) property = `final ${property} = ${finalValue}`;
      if (propertyName !== normalizedPropertyName) {
        property = `@JsonProperty("${propertyName}") ${property}`;
        imports.add("com.fasterxml.jackson.annotation.JsonProperty");
      }
      fields.push(`${property};`);
      typeImports.forEach((i) => imports.add(i));
    });
  }
  return { content: fields.join("\n  "), imports: [...imports] };
}

function generateFieldType(schema: any, path: string): { type: string, imports: string[], finalValue?: string } {
  console.log("Generating field for", path);
  switch (schema.type) {
    case "string":
      return { type: "String", imports: [] };
    case "integer":
      return { type: "Integer", imports: [] };
    case "number":
      return { type: "Double", imports: [] };
    case "boolean":
      return { type: "Boolean", imports: [] };
    case "object":
      console.log("Generating class for", path);
      if (!schema.properties) {
        return { type: "HashMap<String, Object>", imports: ["java.util.HashMap"] };
      }
      // TODO: generate a sub class for the object
      // const classInfos = getClassForRef(path);
      // return { type: classInfos.className, imports: [classInfos.fullName] };
      return { type: "Object", imports: [] }
    case "array":
      const { type, imports } = generateFieldType(schema.items, path);
      return { type: `List<${type}>`, imports: ["java.util.List", ...imports] };
    default:
      if (schema.$ref) {
        const classInfos = getClassForRef(schema.$ref);
        return { type: classInfos.className, imports: [classInfos.fullName] };
      }
      if (schema.const) {
        switch (typeof schema.const) {
          case "number":
            return { type: "Double", imports: [], finalValue: schema.const.toString() };
          case "boolean":
            return { type: "Boolean", imports: [], finalValue: schema.const.toString() };
          case "string":
            return { type: "String", imports: [], finalValue: `"${schema.const}"` };
        }
      }
      // if (schema.oneOf) {
      throw new Error(`Unknown type: ${schema.type}`);
  }
}

function getClassForRef(ref: string): { className: string, fullName: string } {
  const refParts = ref.split("/");
  if (refParts.shift() !== "#") throw new Error(`Invalid ref: ${ref}`);
  const schema = refParts.reduce((schema, path) => schema[path], globalSchema);
  const refPath = refParts.pop() ?? "";
  const packageParts = refPath.split(".");
  let className = packageParts.pop()!;

  if (schema.title)
    className = schema.title;
  else
    className = `${className.substring(0, 1).toUpperCase()}${className.substring(1)}`;

  const packageName = packageParts.length > 0 ? `${basePackage}.${packageParts.join(".")}` : basePackage;
  return { className, fullName: `${packageName}.${className}` };
}
