package com.example.testing.repository;

import com.example.testing.model.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Long> {

    List<Person> findAllByUsername(String username);
}
