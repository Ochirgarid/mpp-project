package edu.miu.cs.cs401.project.domain;

import java.time.LocalDate;
import java.time.LocalTime;

public class FlightNumber {
    private static int idCount = 0;
    private int id;
    private String number;
    private int capacity;
    private LocalTime departureTime;
    private LocalTime arrivalTime;

    Airport departureAirport;
    Airport arrivalAirport;

    public FlightNumber(String number, int capacity, LocalTime departureTime, LocalTime arrivalTime,
            Airport departureAirport, Airport arrivalAirport) {
        this.setNumber(number);
        this.setCapacity(capacity);
        this.setDepartureTime(departureTime);
        this.setArrivalTime(arrivalTime);
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.id = idCount++;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
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

}
