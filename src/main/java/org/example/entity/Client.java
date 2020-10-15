package org.example.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Client {
	@Id
	private UUID id;

	private String name;
	private String surname;

	public UUID getId() {
		return id;
	}

	public Client setId(UUID id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public Client setName(String name) {
		this.name = name;
		return this;
	}

	public String getSurname() {
		return surname;
	}

	public Client setSurname(String surname) {
		this.surname = surname;
		return this;
	}
}
