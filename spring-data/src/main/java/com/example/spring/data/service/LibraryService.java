package com.example.spring.data.service;

import com.example.spring.data.model.LibraryRepository;
import com.example.spring.data.model.entity.Author;
import com.example.spring.data.model.entity.Book;
import com.example.spring.data.model.entity.Reader;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@AllArgsConstructor
public class LibraryService {

    private final LibraryRepository libraryRepository;

    @PostConstruct
    void init() {
        libraryRepository.saveAll(IntStream.range(0, 10)
                .mapToObj(i -> Book.builder()
                        .name("Book " + i)
                        .description("Book description " + i)
                        .authors(Collections.singleton(Author.builder()
                                .name("Author " + i)
                                .description("Author description")
                                .build()))
                        .readers(Collections.singleton(Reader.builder()
                                .name("Reader " + i)
                                .lastName("Last name" + i)
                                .address("Address")
                                .description("Description")
                                .build()))
                        .build())
                .collect(Collectors.toList()));
    }

    public List<Book> getAllByJoinFetch() {
        return libraryRepository.findAllWithJoinFetch(Sort.by(Sort.Direction.DESC, "id"));
    }

    public List<Book> getAllByLimitLazyFields() {
        return libraryRepository.findAllWithLimitedFields();
    }

}
