package com.example.spring.data.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedEntityGraph(name = "Book.authors",
        attributeNodes = @NamedAttributeNode("authors")
)
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private Set<Author> authors = new HashSet<>();

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private Set<Reader> readers = new HashSet<>();

    public Book(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
