package io.lenra.applibjava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.lenra.applibjava.LenraApplication;
import io.lenra.applibjava.request.AppRequest;

@RestController
public class ServerController {
    @Autowired
    private LenraApplication app;

    @PostMapping(value = "/**", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Object index(@RequestBody AppRequest<?> request) {
        return request.handle(app);
    }
}