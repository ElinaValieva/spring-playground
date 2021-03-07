package com.example.spring.data;

import com.example.spring.data.model.entity.Book;
import com.example.spring.data.model.entity.Person;
import com.example.spring.data.service.LibraryService;
import com.example.spring.data.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class LibraryController {

    private final LibraryService libraryService;
    private final PersonService personService;

    @GetMapping(value = "/join")
    public ResponseEntity<List<Book>> getAll() {
        return ResponseEntity.ok(libraryService.getAllByJoinFetch());
    }

    @GetMapping(value = "/limited")
    public ResponseEntity<List<Book>> getLimitedFieldsInfo() {
        return ResponseEntity.ok(libraryService.getAllByLimitLazyFields());
    }

    @GetMapping(value = "/entity-graph")
    public ResponseEntity<List<Person>> getByEntityGraph() {
        return ResponseEntity.ok(personService.findPersons());
    }

    @GetMapping(value = "/entity-graph-name")
    public ResponseEntity<List<Person>> getByEntityGraphByName() {
        return ResponseEntity.ok(personService.findPersonByName());
    }
}
