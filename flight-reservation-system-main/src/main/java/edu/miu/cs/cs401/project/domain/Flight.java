package edu.miu.cs.cs401.project.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Flight {
    private static int idCount = 0;
    private int id;
    private FlightNumber flightNumber;
    private LocalDate departureDate;
    private LocalDate arrivalDate;
    private List<Passenger> passengerList;
    private List<Crew> crewList;
    private List<Pilot> pilotList;

    public Flight(FlightNumber flightNumber, LocalDate departureDate, LocalDate arrivalDate) {
        this.id = idCount++;
        this.flightNumber = flightNumber;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.passengerList = new ArrayList<>();
        this.crewList = new ArrayList<>();
        this.pilotList = new ArrayList<>();

    }

}
