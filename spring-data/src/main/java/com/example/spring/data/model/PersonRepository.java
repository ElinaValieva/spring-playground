package com.example.spring.data.model;

import com.example.spring.data.model.entity.Person;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query(value = "select new Person(p.id, p.name, p.info, p.permissions) from Person p left join fetch p.permissions")
    List<Person> findAll();

    @EntityGraph(value = "Person.all")
    List<Person> findAllByNameLike(String name);
}
