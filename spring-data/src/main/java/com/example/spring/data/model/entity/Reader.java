package com.example.spring.data.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Data
@ToString(exclude = {"book"})
@AllArgsConstructor
@NoArgsConstructor
public class Reader {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String lastName;

    private String address;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    private Book book;
}
