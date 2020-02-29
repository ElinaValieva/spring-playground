package com.spring.config.controller;

import com.spring.config.configuration.AppConfiguration;
import com.spring.config.configuration.BaseConfiguration;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ConfigurationRestController {

    private final AppConfiguration appConfiguration;

    @GetMapping("/config")
    public ResponseEntity<?> get() {
        BaseConfiguration dev = appConfiguration.getConfig("dev");
        BaseConfiguration test = appConfiguration.getConfig("test");
        return ResponseEntity.ok("Dev: " + dev.value + " Test: " + test.value);
    }
}
