package io.lenra.api;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.lenra.api.components.View;
import io.lenra.api.components.view.definitions.Find;

/**
 * Unit test for simple App.
 */
public class ManifestTestKotlin {
	private static ObjectMapper mapper = new ObjectMapper();
	private static String jsonManifest = "{\"json\":{\"routes\":[{\"path\":\"/counter/global\",\"view\":{\"name\":\"counter\",\"find\":{\"coll\":\"counter\",\"query\":{\"user\":\"global\"}},\"_type\":\"view\"},\"roles\":[\"guest\",\"user\"]},{\"path\":\"/counter/me\",\"view\":{\"name\":\"counter\",\"find\":{\"coll\":\"counter\",\"query\":{\"user\":\"@me\"}},\"_type\":\"view\"}}]}}";

	@Test
	public void json() throws JsonProcessingException {
		Manifest manifest = Manifest.builder()
				.json(Exposer.builder().route(Route.builder().path("/counter/global")
						.view(View.builder().name("counter")
								.find(Find.builder().coll("counter").query(Map.of("user", "global")).build()).build())
						.role("guest").role("user").build())
						.route(Route.builder().path("/counter/me").view(View.builder().name("counter")
								.find(Find.builder().coll("counter").query(Map.of("user", "@me")).build()).build())
								.build())
						.build())
				.build();

		assertEquals(jsonManifest, mapper.writeValueAsString(manifest));
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

		assertEquals(jsonManifest, mapper.writeValueAsString(manifest));
	}
}
