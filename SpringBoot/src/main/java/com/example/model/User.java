package com.example.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * @author Hugo Malglaive
 * @version 1.0
 * @since SpringBoot
 */
@Entity
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String nom;
    private String pwd;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}