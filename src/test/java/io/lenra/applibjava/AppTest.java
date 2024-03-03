package io.lenra.applibjava;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.lenra.api.Exposer;
import io.lenra.api.Manifest;
import io.lenra.api.Route;
import io.lenra.api.components.View;
import io.lenra.api.components.view.definitions.Find;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     * 
     * @throws JsonProcessingException
     */
    @Test
    public void shouldAnswerWithTrue() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        Manifest manifest = Manifest.builder()
                .json(Exposer.builder()
                        .route(Route.builder()
                                .path("/counter/global")
                                .view(View.builder()
                                        .name("counter")
                                        .find(Find.builder()
                                                .coll("counter")
                                                .query(Map.of("user", "global"))
                                                .build())
                                        .build())
                                .role("guest")
                                .role("user")
                                .build())
                        .route(Route.builder()
                                .path("/counter/me")
                                .view(View.builder()
                                        .name("counter")
                                        .find(Find.builder()
                                                .coll("counter")
                                                .query(Map.of("user", "@me"))
                                                .build())
                                        .build())
                                .build())
                        .build())
                .build();

        assertEquals(
                "{\"json\":{\"routes\":[{\"path\":\"/counter/global\",\"view\":{\"name\":\"counter\",\"find\":{\"coll\":\"counter\",\"query\":{\"user\":\"global\"}},\"_type\":\"view\"},\"roles\":[\"guest\",\"user\"]},{\"path\":\"/counter/me\",\"view\":{\"name\":\"counter\",\"find\":{\"coll\":\"counter\",\"query\":{\"user\":\"@me\"}},\"_type\":\"view\"},\"roles\":[]}]}}",
                mapper.writeValueAsString(manifest));
    }
}
