package com.example.testing.service;

import com.example.testing.model.Person;

import java.util.List;

public interface PersonService {

    List<Person> getPersonsByName(String name);
}
