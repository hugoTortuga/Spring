package com.example.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Hugo Malglaive
 * @version 1.0
 * @since SpringBoot
 */
public class PersonForm {

	@NotNull
	@Size(min=2, max=50)
	private String name;

	@NotNull
	@Size(min=2, max=50)
	private String prenom;

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String toString() {
		return "Person(nom: " + this.name + ", prénom: " + this.prenom + ")";
	}

}
