package edu.miu.cs.cs401.project.domain;

import java.util.ArrayList;
import java.util.List;

public class Reservation {

    private static int idCount = 0;

    private int id;
    private int agentId;
    private String reservationCode;
    private List<Flight> flightList;

    public Reservation(List<Flight> flightList) {

        this.id = idCount++;
        this.setReservationCode(generateCode());
        this.setFlightList(new ArrayList<Flight>());

    }

    public String getReservationCode() {
        return reservationCode;
    }

    public void setReservationCode(String reservationCode) {
        this.reservationCode = reservationCode;
    }

    private String generateCode() {
		return null;

        //TO DO

    }

    public List<Flight> getFlightList() {
        return flightList;
    }

    public void setFlightList(List<Flight> flightList) {
        this.flightList = flightList;
    }

    public int getAgentId() {
        return agentId;
    }

    public void setAgentId(int agentId) {
        this.agentId = agentId;
    }

}
