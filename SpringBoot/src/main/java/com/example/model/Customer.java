package com.example.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;

/**
 * @author Hugo Malglaive
 * @version 1.0
 * @since SpringBoot
 */
@Entity
@XmlRootElement(name="customer")
public class Customer {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String lastName;

	@XmlElement
	public Collection<AdresseMail> getMails() {
		return mails;
	}

	public void setMails(Collection<AdresseMail> mails) {
		this.mails = mails;
	}

	@OneToMany(mappedBy = "customer", cascade={CascadeType.REMOVE})
	private Collection<AdresseMail> mails ;

	@ManyToMany(cascade={CascadeType.REMOVE})
	private Collection<AdressePostale> adressesPostales ;


	protected Customer() {}

	public Customer(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return String.format(
				"%d : %s %s",
				id, firstName, lastName);
	}
	@XmlElement
	public Collection<AdressePostale> getAdressesPostales() {
		return adressesPostales;
	}

	public void setAdressesPostales(Collection<AdressePostale> adressesPostales) {
		this.adressesPostales = adressesPostales;
	}
	@XmlElement
	public Long getId() {
		return id;
	}

	@XmlElement
	public String getFirstName() {
		return firstName;
	}

	@XmlElement
	public String getLastName() {
		return lastName;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}