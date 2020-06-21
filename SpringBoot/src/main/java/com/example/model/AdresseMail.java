package com.example.model;

import javax.persistence.*;

/**
 * @author Hugo Malglaive
 * @version 1.0
 * @since SpringBoot
 */
@Entity
public class AdresseMail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String mail;
    @ManyToOne
    @JoinColumn(name ="customer_fk")
    private Customer customer ;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public AdresseMail() {
    }

    public AdresseMail(String _mail) {
        this.mail = _mail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return mail;
    }
}