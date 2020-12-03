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
        this.setFlightNumber(flightNumber);
        this.setDepartureDate(departureDate);
        this.setArrivalDate(arrivalDate);
        this.setPassengerList(new ArrayList<>());
        this.setCrewList(new ArrayList<>());
        this.setPilotList(new ArrayList<>());

    }

    public FlightNumber getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(FlightNumber flightNumber) {
        this.flightNumber = flightNumber;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public List<Passenger> getPassengerList() {
        return passengerList;
    }

    public void setPassengerList(List<Passenger> passengerList) {
        this.passengerList = passengerList;
    }

    public List<Crew> getCrewList() {
        return crewList;
    }

    public void setCrewList(List<Crew> crewList) {
        this.crewList = crewList;
    }

    public List<Pilot> getPilotList() {
        return pilotList;
    }

    public void setPilotList(List<Pilot> pilotList) {
        this.pilotList = pilotList;
    }

    public Ticket createTicket(Reservation reservation) {
        Ticket ticket = new Ticket( reservation.getReservationCode(), this);
        return ticket;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightNumber=" + flightNumber +
                ", departureDate=" + departureDate +
                ", arrivalDate=" + arrivalDate +
                '}';
    }
}
