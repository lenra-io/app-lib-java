package io.lenra.app;

import org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Ignore;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.lenra.app.components.View;
import io.lenra.app.components.view.definitions.Find;

/**
 * Unit test for simple App.
 */
public class ManifestTestKotlin {
	val mapper: ObjectMapper = ObjectMapper();

	@Test
	fun jsonApply() {
		val manifest = Manifest().apply {
			json = Exposer().apply {
				routes = listOf(
					Route().apply {
						path = "/counter/global"
						view = View().apply {
							name = "counter"
							find = Find(
								"counter",
								mapOf("user" to "global")
							)
						}
						roles = listOf("guest", "user")
					},
					Route().apply {
						path = "/counter/me"
						view = View().apply {
							name = "counter"
							find=Find(
								"counter",
								mapOf("user" to "@me")
							)
						}
					}
				)
			}
		};

		assertEquals(
				ManifestTestJava.JSON_MANIFEST,
				mapper.writeValueAsString(manifest));
	}
}
