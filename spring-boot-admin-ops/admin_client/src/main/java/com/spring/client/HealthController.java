package com.spring.client;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/actuator/api")
public class HealthController {

    @GetMapping("/health")
    public ResponseEntity healthCheck() {
        return ResponseEntity.ok("OK");
    }
}
