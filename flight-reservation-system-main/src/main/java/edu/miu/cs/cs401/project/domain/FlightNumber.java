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

    private Airport departureAirport;
    private Airport arrivalAirport;

    public FlightNumber(String number, int capacity, LocalTime departureTime, LocalTime arrivalTime,
            Airport departureAirport, Airport arrivalAirport) {
        this.setNumber(number);
        this.setCapacity(capacity);
        this.setDepartureTime(departureTime);
        this.setArrivalTime(arrivalTime);
        this.setDepartureAirport(departureAirport);
        this.setArrivalAirport(arrivalAirport);
        this.id = idCount++;
    }

    public Airport getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(Airport arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public Airport getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(Airport departureAirport) {
        this.departureAirport = departureAirport;
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

    @Override
    public String toString() {
        return "FlightNumber{" +
                "number='" + number + '\'' +
                ", capacity=" + capacity +
                ", departureTime=" + departureTime +
                ", arrivalTime=" + arrivalTime +
                ", departureAirport=" + departureAirport +
                ", arrivalAirport=" + arrivalAirport +
                '}';
    }
}
