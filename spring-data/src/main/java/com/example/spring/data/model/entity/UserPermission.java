package com.example.spring.data.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Builder
@ToString(exclude = {"person"})
@AllArgsConstructor
@NoArgsConstructor
public class UserPermission {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Person person;
}
