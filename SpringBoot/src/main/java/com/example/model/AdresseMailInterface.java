package com.example.model;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AdresseMailInterface extends CrudRepository<AdresseMail, Long> {

    List<AdresseMail> findByMail(String mail);

    AdresseMail findById(long id);

    List<AdresseMail> findByCustomer(Customer customer);

}
