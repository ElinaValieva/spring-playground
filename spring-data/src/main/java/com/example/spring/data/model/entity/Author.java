package com.example.spring.data.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Data
@ToString(exclude = {"book", "person"})
@AllArgsConstructor
@NoArgsConstructor
public class Author {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    private Book book;

    @ManyToOne(fetch = FetchType.LAZY)
    private Person person;
}
