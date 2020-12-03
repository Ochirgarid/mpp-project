package edu.miu.cs.cs401.project.domain;

import org.apache.commons.lang3.RandomStringUtils;
import java.util.ArrayList;
import java.util.List;

public class Reservation {
    public static final int CONFIRMED_PURCHASED = 2;
    public static final int CREATED = 1;
    public static final int CANCEL = 0;

    private static int idCount = 0;
    private int id;
    private int agentId;
    private String reservationCode;
    private List<Flight> flightList;

    private List<Ticket> ticketList;
    private int status;

    public Reservation(List<Flight> flightList) {
        this.agentId = 0;
        this.id = idCount++;
        this.ticketList = new ArrayList<>();
        this.setReservationCode(generateCode());
        this.setFlightList(flightList);
    }

    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return this.status;
    }
    public String getStatusDetail() {
        if(status == CANCEL) {
            return "CANCELED";
        } else if(status == CREATED) {
            return "CREATED";
        } else {
            return "CONFIRMED_AND_PURCHASED";
        }
    }
    public String getReservationCode() {
        return reservationCode;
    }

    public void setReservationCode(String reservationCode) {
        this.reservationCode = reservationCode;
    }

    private String generateCode() {
        int length = 6;
        boolean useLetters = true;
        boolean useNumbers = true;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);

        return generatedString.toUpperCase();
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

    public void confirmAndPurchase() throws Exception {
        if(status == CANCEL) {
            throw new Exception("The reservation already canceled");
        } else if (status == CONFIRMED_PURCHASED) {
            throw new Exception("The reservation already confirmed and purchased");
        }
        Ticket ticket;
        for(Flight flight : flightList) {
            ticket = new Ticket(getReservationCode(), flight);
            ticketList.add(ticket);
        }
        status = CONFIRMED_PURCHASED;
    }
}
