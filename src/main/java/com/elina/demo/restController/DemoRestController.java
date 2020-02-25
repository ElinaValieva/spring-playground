package com.elina.demo.restController;

import com.elina.demo.configs.AppConfig;
import com.elina.demo.configs.BaseConfig;
import com.elina.demo.configs.URLs;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class DemoRestController {

    private final AppConfig appConfig;

    @GetMapping(URLs.URL)
    public ResponseEntity<?> get() {
        BaseConfig dev = appConfig.getConfig("dev");
        BaseConfig test = appConfig.getConfig("test");
        return ResponseEntity.ok("Dev: " + dev.value + " Test: " + test.value);
    }
}
