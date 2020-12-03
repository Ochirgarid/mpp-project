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

    public Flight(FlightNumber flightNumber, LocalDate departureDate, LocalDate arrivalDate, List<Crew> crews, List<Pilot> pilots) {
        this.id = idCount++;
        this.flightNumber = flightNumber;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.passengerList = new ArrayList<>();
        this.crewList = crews;
        this.pilotList = pilots;
    }

    public FlightNumber getFlightNumber() {
        return flightNumber;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void addPassenger(Passenger passenger) throws Exception {
        int totalPassenger = passengerList.size() + crewList.size() + pilotList.size();
        if(totalPassenger > flightNumber.getCapacity()) {
            throw new Exception("Sorry the flight already full capacity");
        }
        passengerList.add(passenger);
    }

    public void removePassenger(Passenger passenger) {
        if(passenger != null) {
            for(Passenger p : passengerList) {
                if (p.getId() == passenger.getId()) {
                    passengerList.remove(p);
                    break;
                }
            }
        }
    }
    public List<Passenger> getPassengerList() {
        return passengerList;
    }

    public List<Crew> getCrewList() {
        return crewList;
    }

    public List<Pilot> getPilotList() {
        return pilotList;
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
