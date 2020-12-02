package edu.miu.cs.cs401.project.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Agent extends Person {
    
    private List<Passenger> passengerList;

    public Agent(Address address, String firstName, String lastName, LocalDate birthday, String email) {
        super(address, firstName, lastName, birthday, email);
        passengerList = new ArrayList<>();
        this.id = idCount++;
    }

    public int getId() {
        return id;
    }

    public void addPassenger(Passenger passenger) {

        this.passengerList.add(passenger);

    }

}
