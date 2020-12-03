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

    public String toString(){

        String result ="";
        result+= "Reservation code: " +this.reservationCode +", ";
        
        for (int i = 0; i < this.flightList.size(); i++){
            String flightCount = Integer.toString(i+1);
            result+= flightCount+ "- ";

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
            String departureDate = this.flightList.get(i).getDepartureDate().format(formatter);
            String arrivalDate = this.flightList.get(i).getArrivalDate().format(formatter);
            result+= "Departure date- "+ departureDate+ " Arrival date- "+ arrivalDate;

            String flightNumber = this.flightList.get(i).getFlightNumber().getNumber();
            result+= ", Flight number- "+ flightNumber;
            result+= "\n";
        }

        return result;

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

        for(Flight flight : flightList) {
            ticketList.add(flight.createTicket(this));
        }
        status = CONFIRMED_PURCHASED;
    }


}
