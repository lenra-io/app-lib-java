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

To incorporate it into your Lenra app project, simply run the following command:
```gradle
npm i @lenra/app-server
```

### Lenra API calls

To call a Lenra API from a listener, utilize the `Api` instance provided as the third parameter in your listener function. 

You can then create a document using the data API with the following code:
```java
class CustomType extends Data {
    /**
     * @param {string} value
     */
  constructor(value) {
    this.value = value;
  }
}

const myDoc = await api.data.coll(CustomType).createDoc(new CustomType("Hello world"));
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
