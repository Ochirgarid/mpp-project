package edu.miu.cs.cs401.project.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Agent extends Person {
    
    private List<Passenger> passengerList;

    public Agent(Address address, String firstName, String lastName, LocalDate birthday, String email) {
        super(address, firstName, lastName, birthday, email);
        passengerList = new ArrayList<Passenger>();
    }

    public void addPassenger(Passenger passenger) {

        this.passengerList.add(passenger);

    }

    public Reservation findReservationByCode(String reservationCode) {
        Reservation reservation = null;
        for(Passenger p : passengerList) {
            reservation = p.findReservationByCode(reservationCode);
            if(reservation != null) {
                return reservation;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Agent{" +
                "id=" + this.getId() +
                '}';
    }

    public void cancelReservation(String reservationCode) throws Exception {
        Reservation reservation = null;
        Passenger passenger = null;
        for(Passenger p : passengerList) {
            reservation = p.findReservationByCode(reservationCode);
            if(reservation != null) {
                passenger = p;
                break;
            }
        }
        if(reservation == null) {
            throw new Exception("Reservation code: " + reservationCode + " not found");
        }
        passenger.cancelReservation(reservation.getReservationCode());
    }

    public void confirmReservation(String reservationCode) throws Exception {
        Reservation reservation = null;
        Passenger passenger = null;
        for(Passenger p : passengerList) {
            reservation = p.findReservationByCode(reservationCode);
            if(reservation != null) {
                passenger = p;
                break;
            }
        }
        if(reservation == null) {
            throw new Exception("Reservation code: " + reservationCode + " not found");
        }
        passenger.confirmReservation(reservation.getReservationCode());
    }
    public List<Passenger> getPassengerList(){
        return this.passengerList;
    }

}
