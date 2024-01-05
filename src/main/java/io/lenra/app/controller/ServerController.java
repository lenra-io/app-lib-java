package io.lenra.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.lenra.app.LenraApplication;
import io.lenra.app.request.AppRequest;

@RestController
public class ServerController {
    @Autowired
    private LenraApplication app;

    @PostMapping(value = "/**", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Object index(@RequestBody AppRequest<?> request) {
        return request.handle(app);
    }
}