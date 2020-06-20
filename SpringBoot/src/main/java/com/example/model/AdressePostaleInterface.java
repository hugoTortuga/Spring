package com.example.model;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AdressePostaleInterface extends CrudRepository<AdressePostale, Long> {

    AdressePostale findById(long id);

}
