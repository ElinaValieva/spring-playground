package com.example.spring.data.service;

import com.example.spring.data.model.PersonRepository;
import com.example.spring.data.model.entity.Author;
import com.example.spring.data.model.entity.Person;
import com.example.spring.data.model.entity.UserPermission;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@AllArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    @PostConstruct
    public void init() {
        personRepository.saveAll(IntStream.range(0, 10)
                .mapToObj(i -> Person.builder()
                        .name("User " + i)
                        .info("Info " + i)
                        .permissions(Arrays.asList(
                                UserPermission.builder()
                                        .name("READ")
                                        .build(),
                                UserPermission.builder()
                                        .name("WRITE")
                                        .build()))
                        .authors(Collections.singleton(Author.builder()
                                .name("Author " + i)
                                .description("Author description")
                                .build()))
                        .build())
                .collect(Collectors.toList()));
    }

    public List<Person> findPersons() {
        return personRepository.findAll();
    }

    public List<Person> findPersonByName() {
        return personRepository.findAllByNameLike("%User%");
    }
}
