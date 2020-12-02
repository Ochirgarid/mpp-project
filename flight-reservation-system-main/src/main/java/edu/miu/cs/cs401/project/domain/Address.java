package edu.miu.cs.cs401.project.domain;

import java.util.Locale;
import com.github.javafaker.Faker;

public class Address {

    private static int idCount = 0;

    private int id;
    private String street;
    private String city;
    private String state;
    private String zipCode;

    public Address() {
        Faker faker = new Faker(new Locale("us-en"));

		this.street = faker.address().buildingNumber() + " " + faker.address().streetName();
		this.city = faker.address().city();
		this.state = faker.address().state();
		this.zipCode = faker.address().zipCode();
    }
    public Address(String street, String city, String state, String zipCode) {

        this.setStreet(street);
        this.setCity(city);
        this.setState(state);
        this.setZipCode(zipCode);
        this.id = idCount++;

    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

}
