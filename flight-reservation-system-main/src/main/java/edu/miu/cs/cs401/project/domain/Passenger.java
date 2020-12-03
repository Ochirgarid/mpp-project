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

    public void cancelReservation(String reservationCode) throws Exception {
        Reservation reservation = null;
        for(Reservation res : reservationList) {
            if(res.getReservationCode().equals(reservationCode)) {
                reservation = res;
                break;
            }
        }
        if(reservation == null) {
            throw new Exception("Reservation code: " + reservationCode + " not found");
        }

        if(reservation.getStatus() == Reservation.CANCEL) {
            throw new Exception("The reservation already canceled");
        } else if (reservation.getStatus() == Reservation.CONFIRMED_PURCHASED) {
            throw new Exception("Cannot cancel the reservation. The reservation already confirmed and purchased");
        }
        reservation.setStatus(Reservation.CANCEL);
    }
}
