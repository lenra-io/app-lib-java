package io.lenra.api;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.lenra.api.components.View;
import io.lenra.api.components.view.definitions.Find;

/**
 * Unit test for simple App.
 */
class ManifestTestGroovy extends GroovyTestCase {
	static def mapper = new ObjectMapper();

	static class TestClass {
		String name;
		String value;
	}

	@Test
	void testJson() {
		println "json test case"
		def manifest = new Manifest(
			json: new Exposer(
				routes: [
					new Route(
						path: "/counter/global",
						view: new View(
							name: "counter",
							find: new Find(
								coll: "counter",
								query: [user: "global"]
							)
						),
						roles: [
							"guest",
							"user"
						]
					),
					new Route(
						path: "/counter/me",
						view: new View(
							name: "counter",
							find: new Find(
								coll: "counter",
								query: [user: "@me"]
							)
						)
					)
				]
			)
		);

		assertToString(mapper.writeValueAsString(manifest), "{\"json\":{\"routes\":[{\"path\":\"/counter/global\",\"view\":{\"name\":\"counter\",\"find\":{\"coll\":\"counter\",\"query\":{\"user\":\"global\"}},\"_type\":\"view\"},\"roles\":[\"guest\",\"user\"]},{\"path\":\"/counter/me\",\"view\":{\"name\":\"counter\",\"find\":{\"coll\":\"counter\",\"query\":{\"user\":\"@me\"}},\"_type\":\"view\"}}]}}");
	}
}
