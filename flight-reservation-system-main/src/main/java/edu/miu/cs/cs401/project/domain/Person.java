package edu.miu.cs.cs401.project.domain;

import java.time.LocalDate;

public class Person {
	private Address address;
	private int id;
	private static int idCount = 0;
	private String firstName;
	private String lastName;
	private LocalDate birthday;
	private String email;

	public Person(Address address, String firstName, String lastName, LocalDate birthday, String email) {
		this.setAddress(address);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setBirthday(birthday);
		this.setEmail(email);
		this.id = idCount;
		idCount++;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getId() {
		return id;
	}	
}
