package edu.miu.cs.cs401.project.domain;

import java.util.ArrayList;
import java.util.List;

public class Airline {

    private static int idCount = 0;

    private int id;
    private String code;
    private String name;
    private String history;
    private List<FlightNumber> flightNumberList;    

    public Airline(String code, String name, String history) {

        this.id = idCount++;
        this.setCode(code);
        this.setName(name);
        this.setHistory(history);
        this.flightNumberList = new ArrayList<FlightNumber>();

    }

    public void addFlightNumber(FlightNumber fn) throws Exception {
        validationFlightNumber(fn);
        this.flightNumberList.add(fn);
    }
    

    private void validationFlightNumber(FlightNumber fn) throws Exception {
        if(fn.getDepartureAirport().getCode().equals(fn.getArrivalAirport().getCode())) {
            throw new Exception("Invalid FlightNumber. Not allow to depart and arrive at the same airport." );
        }
        if(!fn.getDepartureAirport().isAirlineAllowedToDepart(this)) {
            throw new Exception("Invalid FlightNumber. Not allow to depart from the airport: " + fn.getDepartureAirport().getCode());
        }
        if(!fn.getArrivalAirport().isAirlineAllowedToArrival(this)) {
            throw new Exception("Invalid FlightNumber. Not allow to arrival to the airport: " + fn.getArrivalAirport().getCode());
        }
    }

    public List<FlightNumber> getFlightNumberList() {
		return flightNumberList;
	}

	public void setFlightNumberList(List<FlightNumber> flightNumberList) {
		this.flightNumberList = flightNumberList;
	}

	public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Airline{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", history='" + history + '\'' +
                '}';
    }

}
