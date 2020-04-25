package com.example.testing.service;

import com.example.testing.model.Person;
import com.example.testing.repository.PersonRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Override
    public List<Person> getPersonsByName(String name) {
        return personRepository.findAllByUsername(name);
    }
}
