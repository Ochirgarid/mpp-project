package edu.miu.cs.cs401.project.domain;

import java.time.LocalDate;

public class Pilot extends Person {

    public Pilot(Address address, String firstName, String lastName, LocalDate birthday, String email) {
        super(address, firstName, lastName, birthday, email);
    }
}
