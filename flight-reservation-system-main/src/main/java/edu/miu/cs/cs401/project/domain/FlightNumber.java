package edu.miu.cs.cs401.project.domain;

import java.time.LocalDate;

public class FlightNumber {
    private static int idCount = 0;
    private int id;
    private String number;
    private int capacity;
    private LocalDate departureDate;
    private LocalDate arrivalDate;

    Airport departureAirport;
    Airport arrivalAirport;

    public FlightNumber(String number, int capacity, LocalDate departureDate, LocalDate arrivalDate,
            Airport departureAirport, Airport arrivalAirport) {
        this.number = number;
        this.capacity = capacity;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.id = idCount++;
    }
}
