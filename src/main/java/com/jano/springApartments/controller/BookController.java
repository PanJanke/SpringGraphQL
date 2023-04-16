package com.jano.springApartments.controller;

import com.jano.springApartments.model.Book;
import com.jano.springApartments.repository.BookRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @SchemaMapping(typeName = "Query",value = "allBooks") //jak nazwa ponizszej metody bylaby allBooks to samo @QueryMapping starczy.
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @QueryMapping
    public Book findOne(@Argument Integer id){
        return bookRepository.findOne(id);
    }

}
