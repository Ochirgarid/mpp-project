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
		this.address = address;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		this.email = email;
		this.id = idCount;
		idCount++;
	}

	public int getId() {
		return id;
	}	
}
