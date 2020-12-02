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
        this.setNumber(number);
        this.setCapacity(capacity);
        this.setDepartureDate(departureDate);
        this.setArrivalDate(arrivalDate);
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.id = idCount++;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }
}
