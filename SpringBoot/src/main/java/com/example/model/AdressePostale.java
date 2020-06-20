package com.example.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * @author Hugo Malglaive
 * @version 1.0
 * @since SpringBoot
 */
@Entity
public class AdressePostale {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String rue;

    private String ville;

    private String codePostal;

    private int numRue;

    @ManyToMany
    private Collection<Customer> contacts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public int getNumRue() {
        return numRue;
    }

    public void setNumRue(int numRue) {
        this.numRue = numRue;
    }

    public Collection<Customer> getContacts() {
        return contacts;
    }

    public void setContacts(Collection<Customer> contacts) {
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        return "AdressePostale{" +
                "id=" + id +
                ", rue='" + rue + '\'' +
                ", ville='" + ville + '\'' +
                ", codePostal='" + codePostal + '\'' +
                ", numRue=" + numRue +
                ", contacts=" + contacts +
                '}';
    }
}
