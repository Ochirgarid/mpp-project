package edu.miu.cs.cs401.project.repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import edu.miu.cs.cs401.project.domain.Address;
import edu.miu.cs.cs401.project.domain.Agent;
import edu.miu.cs.cs401.project.domain.Airline;
import edu.miu.cs.cs401.project.domain.Airport;
import edu.miu.cs.cs401.project.domain.Crew;
import edu.miu.cs.cs401.project.domain.Flight;
import edu.miu.cs.cs401.project.domain.FlightNumber;
import edu.miu.cs.cs401.project.domain.Passenger;
import edu.miu.cs.cs401.project.domain.Pilot;
import edu.miu.cs.cs401.project.domain.Reservation;
import edu.miu.cs.cs401.project.domain.Ticket;

public class ReservationSystemRepositoryImpl implements ReservationSystemRepository {
	
	private Map<String, Airport> airportsByCity = new HashMap<>();
	private Map<String, Airport> airports = new HashMap<>();
	private Map<Integer, Passenger> passengers = new HashMap<>();
	private Map<String, Airline> airlines= new HashMap<>();
	private Map<String, FlightNumber> flightNumbers= new HashMap<>();
	private Map<Integer, Pilot> pilots= new HashMap<>();
	private Map<Integer, Crew> crews= new HashMap<>();
	private Map<Integer, Agent> agents= new HashMap<>();
	private Map<String, Ticket> tickets= new HashMap<>();



	private List <Airline> allAirlines;
    private List <Airport> allAirports;
    private List <FlightNumber> allFlightNumbers;
    private List <Flight> allFlight;
    private List <Passenger> allPassenger;
    private List <Pilot> allPilot;
    private List <Crew> allCrew;
    private List <Agent> allAgent;
    private List <Ticket> allTicket;

	ReservationSystemRepositoryImpl() throws Exception {
		super();
		setupAirports();
		setupPassengers();
	}
	

	private void setupPassengers() {
		Address personAdd1 = new Address();
        Address personAdd2 = new Address();
        Address personAdd3 = new Address();
        Address personAdd4 = new Address();
        Address personAdd5 = new Address();
        Address personAdd6 = new Address();

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

		this.passengers.put(p1.getId(), p1);
		this.passengers.put(p2.getId(), p2);
		this.passengers.put(p3.getId(), p3);
		this.passengers.put(p4.getId(), p4);
		this.passengers.put(p5.getId(), p5);
		this.passengers.put(p6.getId(), p6);
		this.passengers.put(p7.getId(), p7);
		this.passengers.put(p8.getId(), p8);
		this.passengers.put(p9.getId(), p9);
		this.passengers.put(p10.getId(), p10);
	}

	private void dummyDatabase() {
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

        this.allCrew.add(c1);
        this.allCrew.add(c2);
        this.allCrew.add(c3);
        this.allCrew.add(c4);

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

        al1.setFlightNumberList(Arrays.asList(fn1, fn2, fn3));
        al2.setFlightNumberList(Arrays.asList(fn4, fn5));
        al3.setFlightNumberList(Arrays.asList(fn6));
        al4.setFlightNumberList(Arrays.asList(fn7));
        al5.setFlightNumberList(Arrays.asList(fn7));

        this.allAirlines.add(al1);
        this.allAirlines.add(al2);
        this.allAirlines.add(al3);
        this.allAirlines.add(al4);
        this.allAirlines.add(al5);

    }

	private void setupAirports() throws Exception {
		
		Airport airport1;
		Airport airport2;
		Airport airport3;
		Airport airport4;
		Airport airport5;

		airport1 = new Airport("CID", "Eastern Iowa Airport", new Address());		
		airport2 = new Airport("ORD", "Chicago O'Hare International Airport", new Address());
		airport3 = new Airport("CLT", "Charlotte Douglas International Airport", new Address());
		airport4 = new Airport("APT4", "Airport 4", new Address());
		airport5 = new Airport("APT5", "Airport 5", new Address());
		

		Airline al1 = new Airline("AL", "Airline1", "The best airline since 1940");
        Airline al2 = new Airline("AI", "Airline2", "The nicest airline since 1965");
        Airline al3 = new Airline("AN", "Airline3", "The coolest airline since 1998");

		airlines.put(al1.getCode(), al1);
		airlines.put(al2.getCode(), al2);
		airlines.put(al3.getCode(), al3);

		airport1.addArrivalAirline(al1);
		airport1.addArrivalAirline(al2);
        airport1.addArrivalAirline(al3);
        airport1.addDepartureAirline(al1);
		airport1.addDepartureAirline(al2);
        airport1.addDepartureAirline(al3);
        
        airport2.addArrivalAirline(al1);
		airport2.addArrivalAirline(al2);
        airport2.addArrivalAirline(al3);
        airport2.addDepartureAirline(al1);
		airport2.addDepartureAirline(al2);
        airport2.addDepartureAirline(al3);
        
        airport3.addArrivalAirline(al1);
		airport3.addArrivalAirline(al2);
        airport3.addArrivalAirline(al3);
        airport3.addDepartureAirline(al1);
		airport3.addDepartureAirline(al2);
        airport3.addDepartureAirline(al3);
		
		airports.put(airport1.getCode(), airport1);
		airportsByCity.put(airport1.getAddress().getCity(), airport1);

		airports.put(airport2.getCode(), airport2);
		airportsByCity.put(airport2.getAddress().getCity(), airport2);

		airports.put(airport3.getCode(), airport3);
		airportsByCity.put(airport3.getAddress().getCity(), airport3);


		// setup flights
		FlightNumber fn1 = new FlightNumber("fn1", 100, LocalTime.of(7, 20), LocalTime.of(8, 25), airport1, airport3);
        FlightNumber fn2 = new FlightNumber("fn2", 80, LocalTime.of(9, 45), LocalTime.of(12, 15), airport2, airport3);
        FlightNumber fn3 = new FlightNumber("fn3", 120, LocalTime.of(17, 10), LocalTime.of(22, 10), airport3, airport1);
		
		FlightNumber fn4 = new FlightNumber("fn4", 40, LocalTime.of(11, 30), LocalTime.of(13, 30), airport1, airport3);
        FlightNumber fn5 = new FlightNumber("fn5", 60, LocalTime.of(7, 50), LocalTime.of(11, 25), airport2, airport3);
        FlightNumber fn6 = new FlightNumber("fn6", 200, LocalTime.of(6, 15), LocalTime.of(9, 15), airport3, airport1);
        FlightNumber fn7 = new FlightNumber("fn7", 60, LocalTime.of(20, 25), LocalTime.of(23, 25), airport3, airport2);
		FlightNumber fn8 = new FlightNumber("fn8", 90, LocalTime.of(15, 15), LocalTime.of(18, 30), airport2, airport1);
		al1.addFlightNumber(fn1);
		al1.addFlightNumber(fn2);
		al1.addFlightNumber(fn3);

		al2.addFlightNumber(fn4);
		al2.addFlightNumber(fn5);
		
		al3.addFlightNumber(fn6);
		al3.addFlightNumber(fn7);
		al3.addFlightNumber(fn8);

		//flightnumbers
        flightNumbers.put(fn1.getNumber(), fn1);
        flightNumbers.put(fn2.getNumber(), fn2);
        flightNumbers.put(fn3.getNumber(), fn3);
        flightNumbers.put(fn4.getNumber(), fn4);
        flightNumbers.put(fn5.getNumber(), fn5);
        flightNumbers.put(fn6.getNumber(), fn6);
        flightNumbers.put(fn7.getNumber(), fn7);
        flightNumbers.put(fn8.getNumber(), fn8);
	}

	@Override
	public Collection<Airport> findAllAirports() {
		return airports.values();
	}

	@Override
	public Airport findAirportByAirportCode(String airportCode) {
		for(Airport airport : findAllAirports()) {
			if(airport.getCode().equalsIgnoreCase(airportCode)) {
				return airport;
			}
		}
		return null;
	}

	@Override
	public Collection<Airport> findAirportsByCity(String city) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Airline> findAirlinesByAirportCode(String airportCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Flight> findFlightsFromTo(String departure, String arrival, LocalDate date) {
		return  allFlight
				.stream()
				.filter( f->
					f.getFlightNumber().getDepartureAirport().getCode().equalsIgnoreCase(departure)
					&&
					f.getFlightNumber().getArrivalAirport().getCode().equalsIgnoreCase(arrival)
					&&
					f.getDepartureDate().equals(date)
				)
				.collect(Collectors.toList());
	}

	@Override
	public Collection<Reservation> findReservationsByPassengerId(Integer passengerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Passenger> findPassengersByAgentCode(String agentCode) {
		// TODO Auto-generated method stub
		return null;
	}

}
