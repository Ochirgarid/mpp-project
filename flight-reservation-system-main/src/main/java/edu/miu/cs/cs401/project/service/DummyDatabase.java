package edu.miu.cs.cs401.project.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import edu.miu.cs.cs401.project.domain.Address;
import edu.miu.cs.cs401.project.domain.Agent;
import edu.miu.cs.cs401.project.domain.Airline;
import edu.miu.cs.cs401.project.domain.Airport;
import edu.miu.cs.cs401.project.domain.Flight;
import edu.miu.cs.cs401.project.domain.FlightNumber;
import edu.miu.cs.cs401.project.domain.Passenger;
import edu.miu.cs.cs401.project.domain.Person;
import edu.miu.cs.cs401.project.domain.Pilot;
import edu.miu.cs.cs401.project.domain.Crew;
import edu.miu.cs.cs401.project.domain.Reservation;
import edu.miu.cs.cs401.project.domain.Ticket;

public class DummyDatabase {
    private List <Airline> allAirlines;
    private List <Airport> allAirports;
    private List <FlightNumber> allFlightNumbers;
    private List <Flight> allFlight;
    private List <Passenger> allPassenger;
    private List <Pilot> allPilot;
    private List <Crew> allCrew;
    private List <Agent> allAgent;
    private List <Ticket> allTicket;

    public DummyDatabase() {
        Address personAdd1 = new Address("Hirise 140", "Fairfield", "Iowa", "52557");
        Address personAdd2 = new Address("Hirise 141", "Fairfield", "Iowa", "52557");
        Address personAdd3 = new Address("Hirise 142", "Fairfield", "Iowa", "52557");
        Address personAdd4 = new Address("Hirise 143", "Fairfield", "Iowa", "52557");
        Address personAdd5 = new Address("Hirise 144", "Fairfield", "Iowa", "52557");
        Address personAdd6 = new Address("Hirise 145", "Fairfield", "Iowa", "52557");
        Address personAdd7 = new Address("Hirise 146", "Fairfield", "Iowa", "52557");
        Address personAdd8 = new Address("Hirise 147", "Fairfield", "Iowa", "52557");
        Address personAdd9 = new Address("Hirise 148", "Fairfield", "Iowa", "52557");
        Address personAdd10 = new Address("Hirise 149", "Fairfield", "Iowa", "52557");
        Address personAdd11 = new Address("Hirise 150", "Fairfield", "Iowa", "52557");
        Address personAdd12 = new Address("Hirise 151", "Fairfield", "Iowa", "52557");
        Address personAdd13 = new Address("Hirise 152", "Fairfield", "Iowa", "52557");
        Address personAdd14 = new Address("Hirise 153", "Fairfield", "Iowa", "52557");

        Passenger p1 = new Passenger(personAdd1, "John", "Dan", LocalDate.of(1990, 12, 1) , "JohnDan@gmail.com");
        Passenger p2 = new Passenger(personAdd1, "George", "Dan", LocalDate.of(1990, 12, 1) , "GeorgeDan@gmail.com");
        Passenger p3 = new Passenger(personAdd1, "Bya", "Dan", LocalDate.of(1990, 12, 1) , "ByaDan@gmail.com");
        Passenger p4 = new Passenger(personAdd2, "Dell", "Neil", LocalDate.of(1990, 12, 1) , "DellNeil@gmail.com");
        Passenger p5 = new Passenger(personAdd2, "Apply", "Neil", LocalDate.of(1990, 12, 1) , "ApplyNeil@gmail.com");
        Passenger p6 = new Passenger(personAdd2, "Grek", "Neil", LocalDate.of(1990, 12, 1) , "GrekNeil@gmail.com");
        Passenger p7 = new Passenger(personAdd3, "Nate", "Kris", LocalDate.of(1990, 12, 1) , "NateKris@gmail.com");
        Passenger p8 = new Passenger(personAdd4, "Nas", "Chris", LocalDate.of(1990, 12, 1) , "NasChris@gmail.com");
        Passenger p9 = new Passenger(personAdd5, "Haryy", "Potter", LocalDate.of(1990, 12, 1) , "HaryyPotter@gmail.com");
        Passenger p10 = new Passenger(personAdd6, "Tom", "Cruise", LocalDate.of(1990, 12, 1) , "TomCruise@gmail.com");

        this.allPassenger.add(p1);
        this.allPassenger.add(p2);
        this.allPassenger.add(p3);
        this.allPassenger.add(p4);
        this.allPassenger.add(p5);
        this.allPassenger.add(p6);
        this.allPassenger.add(p7);
        this.allPassenger.add(p8);
        this.allPassenger.add(p9);
        this.allPassenger.add(p10);

        Pilot pt1 = new Pilot(personAdd7, "Good", "Pilot", LocalDate.of(1990, 12, 1) , "GoodPilot@gmail.com");
        Pilot pt2 = new Pilot(personAdd7, "Bad", "Pilot", LocalDate.of(1990, 12, 1) , "BadPilot@gmail.com");
        Pilot pt3 = new Pilot(personAdd8, "Nice", "Pilot1", LocalDate.of(1990, 12, 1) , "NicePilot1@gmail.com");
        Pilot pt4 = new Pilot(personAdd9, "Kind", "Pilot2", LocalDate.of(1990, 12, 1) , "KindPilot2@gmail.com");
        Pilot pt5 = new Pilot(personAdd10, "Big", "Pilot3", LocalDate.of(1990, 12, 1) , "BigPilot3@gmail.com");

        this.allPilot.add(pt1);
        this.allPilot.add(pt2);
        this.allPilot.add(pt3);
        this.allPilot.add(pt4);
        this.allPilot.add(pt5);

        Crew c1 = new Crew(personAdd11, "Creqw", "Member", LocalDate.of(1990, 12, 1) , "TomCruise@gmail.com");
        Crew c2 = new Crew(personAdd12, "Wrec", "Bermem", LocalDate.of(1990, 12, 1) , "TomCruise@gmail.com");
        Crew c3 = new Crew(personAdd13, "Recw", "Bememr", LocalDate.of(1990, 12, 1) , "TomCruise@gmail.com");
        Crew c4 = new Crew(personAdd14, "Ecrw", "Rembem", LocalDate.of(1990, 12, 1) , "TomCruise@gmail.com");

        this.allCrew.add(c1)
        this.allCrew.add(c2)
        this.allCrew.add(c3)
        this.allCrew.add(c4)

        Address airportAdd1 = new Address("Frat 106", "Fairfield", "Iowa", "52557");
        Address airportAdd2 = new Address("Frat 107", "Fairfield", "Iowa", "52557");
        Address airportAdd3 = new Address("Frat 108", "Fairfield", "Iowa", "52557");
        Address airportAdd4 = new Address("Frat 109", "Fairfield", "Iowa", "52557");
        Address airportAdd5 = new Address("Frat 110", "Fairfield", "Iowa", "52557");

        Airport ap1 = new Airport("APT", "AIRPORT1", airportAdd1);
        Airport ap2 = new Airport("APT", "AIRPORT2", airportAdd2);
        Airport ap3 = new Airport("APT", "AIRPORT3", airportAdd3);
        Airport ap4 = new Airport("APT", "AIRPORT4", airportAdd4);
        Airport ap5 = new Airport("APT", "AIRPORT5", airportAdd5);

        this.allAirports.add(ap1);
        this.allAirports.add(ap2);
        this.allAirports.add(ap3);
        this.allAirports.add(ap4);
        this.allAirports.add(ap5);

        FlightNumber fn1 = new FlightNumber("fn1", 100, LocalTime.of(7, 20), LocalTime.of(8, 25), ap1, ap2);
        FlightNumber fn2 = new FlightNumber("fn2", 80, LocalTime.of(9, 45), LocalTime.of(12, 15), ap2, ap3);
        FlightNumber fn3 = new FlightNumber("fn3", 120, LocalTime.of(17, 10), LocalTime.of(22, 10), ap3, ap4);
        FlightNumber fn4 = new FlightNumber("fn4", 40, LocalTime.of(11, 30), LocalTime.of(13, 30), ap4, ap5);
        FlightNumber fn5 = new FlightNumber("fn5", 60, LocalTime.of(7, 50), LocalTime.of(11, 25), ap5, ap4);
        FlightNumber fn6 = new FlightNumber("fn6", 200, LocalTime.of(6, 15), LocalTime.of(9, 15), ap4, ap3);
        FlightNumber fn7 = new FlightNumber("fn7", 60, LocalTime.of(20, 25), LocalTime.of(23, 25), ap3, ap2);
        FlightNumber fn8 = new FlightNumber("fn8", 90, LocalTime.of(15, 15), LocalTime.of(18, 30), ap2, ap1);

        Airline al1 = new Airline("AL", "Airline1", "The best airline since 1940");
        Airline al2 = new Airline("AI", "Airline2", "The nicest airline since 1965");
        Airline al3 = new Airline("AN", "Airline3", "The coolest airline since 1998");
        Airline al4 = new Airline("AE", "Airline4", "The cheapest airline since 1990");
        Airline al5 = new Airline("IL", "Airline5", "The fastest airline since 2000");

        al1.setFlightNumberList(Array.asList(fn1, fn2, fn3));
        al2.setFlightNumberList(Array.asList(fn4, fn5));
        al3.setFlightNumberList(Array.asList(fn6));
        al4.setFlightNumberList(Array.asList(fn7));
        al5.setFlightNumberList(Array.asList(fn7));

        this.allAirlines.add(al1);
        this.allAirlines.add(al2);
        this.allAirlines.add(al3);
        this.allAirlines.add(al4);
        this.allAirlines.add(al5);

    }

    public List <Passenger> getPassenger() {
        return this.allPassenger;
    }

    public List <Crew> getCrew() {
        return this.allCrew;
    }
    public List <Pilot> getPilot() {
        return this.allPilot;
    }

    public List <Airport> getAirpots() {
        return this.allAirports;
    }
    public List <Airline> getAirlines() {
        return this.allAirlines;
    }
    public List <Flight> getFlights() {
        return this.allFlight;
    }
    
    public String getNewTicketCode() {
        String code = "";

        for(int i = 0; i < 20; i++) {
            int x = (int) Math.floor(Math.random() * 10);
            code = code + Integer.toString(x);
        }

        return code;
    }
    
}
