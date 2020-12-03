package edu.miu.cs.cs401.project.domain;

import org.apache.commons.lang3.RandomStringUtils;

public class Ticket {

    private static int idCount = 0;

    private int id;
    private String reservationCode;
    private String number;
    private Flight flight;

    public Ticket(String reservationCode, Flight flight) {

        this.id = idCount++;
        this.setReservationCode(reservationCode);
        this.setFlight(flight);
        this.setNumber(generateNumber());

    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getReservationCode() {
        return reservationCode;
    }

    public void setReservationCode(String reservationCode) {
        this.reservationCode = reservationCode;
    }

    private String generateNumber() {
        int length = 20;
        boolean useLetters = false;
        boolean useNumbers = true;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);

        return generatedString.toUpperCase();

    }

    @Override
    public String toString() {
        return "Ticket{" +
                "reservationCode='" + reservationCode + '\'' +
                ", number='" + number + '\'' +
                ", flight=" + flight +
                '}';
    }
}
