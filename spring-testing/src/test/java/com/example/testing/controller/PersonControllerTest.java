package com.example.testing.controller;

import com.example.testing.model.Person;
import com.example.testing.service.PersonService;
import com.google.gson.Gson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(PersonController.class)
public class PersonControllerTest {

    @MockBean
    PersonService personService;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void getPersons() throws Exception {
        given(personService.getPersonsByName("test")).willReturn(generatePersonList());
        String mvcResult = mockMvc.perform(get("/persons/{name}", "test")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
        Assertions.assertEquals(getJsonFromList(generatePersonList()), mvcResult);
    }

    private String getJsonFromList(List<Person> personList) {
        return new Gson().toJson(personList);
    }

    private List<Person> generatePersonList() {
        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            personList.add(new Person((long) i, "test", "user", "lastName"));
        }
        return personList;
    }
}