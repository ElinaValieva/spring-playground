package com.example.spring.data.model;

import com.example.spring.data.model.entity.Book;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LibraryRepository extends JpaRepository<Book, Long> {

    @Query(value = "select b from Book b left join fetch b.authors left join fetch b.readers")
    List<Book> findAllWithJoinFetch(Sort sort);

    @Query(value = "select new Book(b.id, b.name, b.description) from Book b")
    List<Book> findAllWithLimitedFields();
}
