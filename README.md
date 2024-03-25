# app-lib-java

<div id="top"></div>
<!--
*** This README was created with https://github.com/othneildrew/Best-README-Template
-->



<!-- PROJECT SHIELDS -->
[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![MIT License][license-shield]][license-url]



<!-- PROJECT LOGO -->
<br />
<div align="center">

<h3 align="center">App Lib for Java based projects</h3>

  <p align="center">
    This lib integrates all the elements the app needs in order to only keep the views, listeners and resources in the app project.
    <br />
    <br />
    <a href="https://github.com/lenra-io/app-lib-java/issues">Report Bug</a>
    ·
    <a href="https://github.com/lenra-io/app-lib-java/issues">Request Feature</a>
  </p>
</div>


<!-- USAGE EXAMPLES -->
## Usage

To incorporate it into your Lenra app project, add the dependency to your `build.gradle` file as follows:
```gradle
dependencies {
    def lenra = 'io.lenra:app:1.0.0'
    implementation lenra
		annotationProcessor lenra
		...
}
```

### Annotations

The lib provides a set of annotations to simplify the development of your app:
- `@AppManifest`: to define the manifest of the app
- `@AppView`: to create a view
- `@AppListener`: to create a listener

The `@AppView` and `@AppListener` annotations are used to generate enums at build time that can be used in the app: `ViewName` and `ListenerName`.

### App Manifest

To define the manifest of the app, create a static method in a class annotating it with `@AppManifest`:
```java
@AppManifest
public static Manifest manifest() {
	return new Manifest()
			.json(
					new Exposer(
							List.of(
									new Route(
											"/counter/global",
											new View(ViewName.LENRA_COUNTER)
													.find(new Find(Counter.class, Map.of("user", "global")))
									)
											.roles(List.of("guest", "user")),
									new Route(
											"/counter/me",
											new View(ViewName.LENRA_COUNTER)
													.find(new Find(Counter.class, Map.of("user", "@me")))
									)
							)
					)
			);
}
```

### App Views

To create a view, create a static method in a class annotating it with `@AppView`: 
```java
// myView JSON view
@AppView
public static Object myView() {
		return Map.of(
				"key", "value"
		);
}
```

A view can return any type of object, it will be serialized to JSON.

#### View parameters

A view can get parameters:
```java
// myView JSON view
@AppView
public static Object myView(@AppView.Data List<Counter> counters, @AppView.Props Map<String, Object> props, @AppView.Context Map<String, Object> context) {
		return Map.of(
				"key", "value"
		);
}
```

The parameters annotations let you define what are the needed parameters for the view (by default they are resolved in the next order):
- `@AppView.Data`: the data needed for the view
- `@AppView.Props`: the props passed to the view
- `@AppView.Context`: the context of the view

The parameters are mapped to the expected type from JSON.

### App Listeners

To create a listener, create a static method in a class annotating it with `@AppListener`: 
```java
// myListener listener
@AppListener
public static void myListener(String data, Api api) {
		// Do something with the data
}
```

#### Listener parameters

A listener can get parameters:
```java
// myListener listener
@AppListener
public static void myListener(@AppListener.Api Api api, @AppListener.Props Map<String, Object> props, @AppListener.Event Map<String, Object> event) {
		// Do something with the data
}
```

The parameters annotations let you define what are the needed parameters for the listener (by default they are resolved in the next order):
- `@AppListener.Api`: the API to call the Lenra API
- `@AppListener.Props`: the props passed to the listener
- `@AppListener.Event`: the event of the listener

The parameters are mapped to the expected type from JSON.


### Lenra API calls

To call a Lenra API from a listener, utilize the `Api` instance provided as the first parameter in your listener function or by the `@AppListener.Api` annotation. 

You can then create a document using the data API with the following code:
```java
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
class CustomData extends Data {
  private String value;
}

var myDoc = api.data.coll(CustomData.class).createDoc(new CustomData("Hello world"));
```

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

If you have a suggestion that would make this better, please open an issue with the tag "enhancement".
Don't forget to give the project a star if you liked it! Thanks again!generate

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

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- LICENSE -->
## License

Distributed under the **MIT** License. See [LICENSE](./LICENSE) for more information.

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- CONTACT -->
## Contact

Lenra - [@lenra_dev](https://twitter.com/lenra_dev) - contact@lenra.io

Project Link: [https://github.com/lenra-io/app-lib-java](https://github.com/lenra-io/app-lib-java)

<p align="right">(<a href="#top">back to top</a>)</p>


<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/lenra-io/app-lib-java.svg?style=for-the-badge
[contributors-url]: https://github.com/lenra-io/app-lib-java/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/lenra-io/app-lib-java.svg?style=for-the-badge
[forks-url]: https://github.com/lenra-io/app-lib-java/network/members
[stars-shield]: https://img.shields.io/github/stars/lenra-io/app-lib-java.svg?style=for-the-badge
[stars-url]: https://github.com/lenra-io/app-lib-java/stargazers
[issues-shield]: https://img.shields.io/github/issues/lenra-io/app-lib-java.svg?style=for-the-badge
[issues-url]: https://github.com/lenra-io/app-lib-java/issues
[license-shield]: https://img.shields.io/github/license/lenra-io/app-lib-java.svg?style=for-the-badge
[license-url]: https://github.com/lenra-io/app-lib-java/blob/master/LICENSE
