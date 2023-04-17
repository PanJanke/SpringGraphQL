package com.jano.springApartments.repository;

import com.jano.springApartments.Utils.CsvUtils;
import com.jano.springApartments.model.Rating;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import com.jano.springApartments.model.Apartment;
@Repository
public class ApartmentRepository {
    private List<Apartment> apartments = new ArrayList<>();

    public List<Apartment> findAll() {
        return apartments;
    }

    public Apartment findOneApartment(Integer id) {
        return apartments.stream()
                .filter(apartment -> apartment.getId() == id)
                .findFirst().orElseThrow(() -> new RuntimeException("Apartment not found"));
    }

    @PostConstruct
    private void init() {

        apartments= CsvUtils.readListFromCsv("apartments.csv");
    }



}





