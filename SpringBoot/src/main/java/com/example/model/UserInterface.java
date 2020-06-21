package com.example.model;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author Hugo Malglaive
 * @version 1.0
 * @since SpringBoot
 */
public interface UserInterface extends CrudRepository<User, Long> {

    List<User> findByNom(String nom);

}
