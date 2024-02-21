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


### Build

```bash
./gradlew build
```