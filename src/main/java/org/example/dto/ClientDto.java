package org.example.dto;

public class ClientDto {

	private String name;
	private String surname;

	public String getName() {
		return name;
	}

	public ClientDto setName(String name) {
		this.name = name;
		return this;
	}

	public String getSurname() {
		return surname;
	}

	public ClientDto setSurname(String surname) {
		this.surname = surname;
		return this;
	}
}
