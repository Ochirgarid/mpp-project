package edu.miu.cs.cs401.project.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Agent extends Person {
    private static int idCount = 0;
    private int id;
    private List<Passenger> passengerList;    

    public Agent(Address address, String firstName, String lastName, LocalDate birthday, String email) {
        super(address, firstName, lastName, birthday, email);
        passengerList = new ArrayList<>();
        id = idCount++;
    }
}
