package com.jano.springApartments.controller;

import com.jano.springApartments.model.Apartment;
import com.jano.springApartments.repository.ApartmentRepository;
import com.jano.springApartments.repository.BookRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
@Controller
public class ApartmentController {

    private final ApartmentRepository apartmentRepository;

    public ApartmentController(ApartmentRepository apartmentRepository) {
        this.apartmentRepository = apartmentRepository;
    }

    @SchemaMapping(typeName = "Query",value = "allApartments")
    public List<Apartment> findAll() {
        return apartmentRepository.findAll();
    }

    @QueryMapping
    public Apartment findOneApartment(@Argument Integer id){
        return apartmentRepository.findOneApartment(id);
    }
}
