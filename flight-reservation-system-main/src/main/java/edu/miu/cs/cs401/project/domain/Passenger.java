package edu.miu.cs.cs401.project.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Passenger extends Person {

    private List<Reservation> reservationList;

    public Passenger(Address address, String firstName, String lastName, LocalDate birthday, String email) {

        super(address, firstName, lastName, birthday, email);
        reservationList = new ArrayList<Reservation>();

    }

    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }

    public void addReservation(Reservation reservation){

        this.reservationList.add(reservation);

    }

}
