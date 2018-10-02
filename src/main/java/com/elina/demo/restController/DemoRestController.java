package com.elina.demo.restController;

import com.elina.demo.configs.URLs;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {

    @GetMapping(URLs.URL)
    public ResponseEntity<?> get() {
        return ResponseEntity.ok("....");
    }
}
