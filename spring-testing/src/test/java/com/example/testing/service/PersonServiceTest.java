package com.example.testing.service;

import com.example.testing.model.Person;
import com.example.testing.repository.PersonRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
public class PersonServiceTest {

    @TestConfiguration
    static class PersonServiceConfiguration {

        @Bean
        public PersonService personService(PersonRepository personRepository) {
            return new PersonServiceImpl(personRepository);
        }
    }

    @Autowired
    PersonService personService;

    @MockBean
    PersonRepository personRepository;

    @Test
    public void getPersonsByName() {
        List<Person> personList = generatePersonList();
        Mockito.when(personRepository.findAllByUsername("test"))
                .thenReturn(personList);
        Assertions.assertEquals(generatePersonList(), personService.getPersonsByName("test"));
    }

    private List<Person> generatePersonList() {
        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            personList.add(new Person((long) i, "test", "user", "lastName"));
        }
        return personList;
    }
}