package com.example.spring.data.model.entity;

import com.example.spring.data.model.entity.Author;
import com.example.spring.data.model.entity.UserPermission;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@NamedEntityGraphs({
        @NamedEntityGraph(
                name = "Person.all", includeAllAttributes = true
        )
})
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String info;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private List<UserPermission> permissions = new ArrayList<>();

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private Set<Author> authors = new HashSet<>();

    public Person(Long id, String name, String info, List<UserPermission> permissions) {
        this.id = id;
        this.name = name;
        this.info = info;
        this.permissions = permissions;
    }
}
