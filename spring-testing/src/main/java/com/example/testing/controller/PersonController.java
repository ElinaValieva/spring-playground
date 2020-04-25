package com.example.testing.controller;

import com.example.testing.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping("/persons/{name}")
    public ResponseEntity<?> getPersons(@PathVariable("name") String name) {
        return ResponseEntity.ok(personService.getPersonsByName(name));
    }
}
