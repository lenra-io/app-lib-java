# app-lib-java




### Generate classes

A part of this lib is generated from the [Lenra API](https://github.com/lenra-io/api).
The class generation is made at build time:

```bash
# Load API
## With wget
wget https://github.com/lenra-io/api/releases/latest/download/load-api.sh -O - -q | bash
## With curl
curl -fsSL https://github.com/lenra-io/api/releases/latest/download/load-api.sh | bash
```

The classes are generated at build time with Gradle and Bun.
You can also generate them manually:

```bash
./gradlew generateApiClasses
```

### Build

```bash
./gradlew build
```

### Public to Maven Local

```bash
./gradlew :app:publishToMavenLocal
```

TODO: create an annotation processor to get dtheviews and listeners: https://www.baeldung.com/java-annotation-processing-builder
