package io.lenra.api;

import static io.lenra.app.components.Components.view;
import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.lenra.app.Exposer;
import io.lenra.app.Manifest;
import io.lenra.app.Route;
import io.lenra.app.components.View;
import io.lenra.app.components.view.definitions.Find;

/**
 * Unit test for simple App.
 */
public class ManifestTestJava {
	private static ObjectMapper mapper = new ObjectMapper();
	public static String JSON_MANIFEST = "{\"json\":{\"routes\":[{\"path\":\"/counter/global\",\"view\":{\"name\":\"counter\",\"find\":{\"coll\":\"counter\",\"query\":{\"user\":\"global\"}},\"_type\":\"view\"},\"roles\":[\"guest\",\"user\"]},{\"path\":\"/counter/me\",\"view\":{\"name\":\"counter\",\"find\":{\"coll\":\"counter\",\"query\":{\"user\":\"@me\"}},\"_type\":\"view\"}}]}}";

	@Test
	@Ignore
	public void jsonBuilder() throws JsonProcessingException {
		Manifest manifest = new Manifest()
				.json(new Exposer()
						.routes(List.of(
								new Route()
										.path("/counter/global")
										.view(new View()
												.name("counter")
												.find(new Find()
														.coll("counter")
														.query(Map.of("user", "global"))))
										.roles(List.of("guest", "user")),
								new Route()
										.path("/counter/me")
										.view(new View()
												.name("counter")
												.find(new Find()
														.coll("counter")
														.query(Map.of("user", "@me")))))));

		assertEquals(
				JSON_MANIFEST,
				mapper.writeValueAsString(manifest));
	}

	@Test
	public void jsonContrstructor() throws JsonProcessingException {
		Manifest manifest = new Manifest(null, new Exposer(null, List.of(
				new Route(
						"/counter/global",
						new View("counter") {
							{
								setFind(new Find("counter", Map.of("user", "global")));
							}
						},
						List.of("guest", "user")),
				new Route(
						"/counter/me",
						new View("counter") {
							{
								setFind(new Find("counter", Map.of("user", "@me")));
							}
						}))));

		assertEquals(
				JSON_MANIFEST,
				mapper.writeValueAsString(manifest));
	}

	@Test
	public void jsonContrstructorWithComponentsMethods() throws JsonProcessingException {
		Manifest manifest = new Manifest(null, new Exposer(null, List.of(
				new Route(
						"/counter/global",
						view("counter",
								v -> v.setFind(new Find("counter", Map.of("user", "global")))),
						List.of("guest", "user")),
				new Route(
						"/counter/me",
						view("counter",
								v -> v.setFind(new Find("counter", Map.of("user", "@me"))))))));

		assertEquals(
				JSON_MANIFEST,
				mapper.writeValueAsString(manifest));
	}
}
