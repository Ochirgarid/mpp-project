package edu.miu.cs.cs401.project.repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
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
	
	// private Map<String, Airport> airportsByCity = new HashMap<>();
	// private Map<String, Airport> airports = new HashMap<String,Airport>();
	private List <Airport> airports = new ArrayList<>();
	private Map<Integer, Passenger> passengers = new HashMap<>();
	private Map<String, Airline> airlines= new HashMap<>();
    private List <Flight> allFlight = new ArrayList<>();

    private Map<Integer, Pilot> pilots= new HashMap<>();
	private Map<Integer, Crew> crews= new HashMap<>();
	private Map<Integer, Agent> agents= new HashMap<>();
	private Map<String, Ticket> tickets= new HashMap<>();

	ReservationSystemRepositoryImpl() throws Exception {
		super();
		setupAirports();
        setupPassengers();
        setupAgents();
    }
    
    private void setupAgents(){

        Address agent1 = new Address();
        Address agent2 = new Address();
        Address agent3 = new Address();

        Agent a1 = new Agent(agent1, "Agent", "One", LocalDate.of(1990, 12, 1) , "Agentone@gmail.com");
        Agent a2 = new Agent(agent2, "Agent", "Two", LocalDate.of(1990, 12, 1) , "Agenttwo@gmail.com");
        Agent a3 = new Agent(agent3, "Agent", "Three", LocalDate.of(1990, 12, 1) , "Agentthree@gmail.com");

        this.agents.put(a1.getId(), a1);
        this.agents.put(a2.getId(), a2);
        this.agents.put(a3.getId(), a3);

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
		
		airports.add(airport1);
		airports.add(airport2);
		airports.add(airport3);
		airports.add(airport4);
		airports.add(airport5);

		// airports.put(airport1.getCode(), airport1);
		// airportsByCity.put(airport1.getAddress().getCity(), airport1);

		// airports.put(airport2.getCode(), airport2);
		// airportsByCity.put(airport2.getAddress().getCity(), airport2);

		// airports.put(airport3.getCode(), airport3);
		// airportsByCity.put(airport3.getAddress().getCity(), airport3);


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


        // create data for flights on specific date: 2020 Dec 02
        allFlight.add(new Flight(fn1,LocalDate.of(2020, 12, 02), LocalDate.of(2020, 12, 02)));
        allFlight.add(new Flight(fn2,LocalDate.of(2020, 12, 02), LocalDate.of(2020, 12, 02)));
        allFlight.add(new Flight(fn3,LocalDate.of(2020, 12, 02), LocalDate.of(2020, 12, 02)));
        allFlight.add(new Flight(fn4,LocalDate.of(2020, 12, 02), LocalDate.of(2020, 12, 02)));
        allFlight.add(new Flight(fn5,LocalDate.of(2020, 12, 02), LocalDate.of(2020, 12, 02)));
        allFlight.add(new Flight(fn6,LocalDate.of(2020, 12, 02), LocalDate.of(2020, 12, 02)));
        allFlight.add(new Flight(fn7,LocalDate.of(2020, 12, 02), LocalDate.of(2020, 12, 02)));
        allFlight.add(new Flight(fn8,LocalDate.of(2020, 12, 02), LocalDate.of(2020, 12, 02)));

        // create data for flights for today
        allFlight.add(new Flight(fn1,LocalDate.now(), LocalDate.now()));
        allFlight.add(new Flight(fn2,LocalDate.now(), LocalDate.now()));
        allFlight.add(new Flight(fn3,LocalDate.now(), LocalDate.now()));
        allFlight.add(new Flight(fn4,LocalDate.now(), LocalDate.now()));
        allFlight.add(new Flight(fn5,LocalDate.now(), LocalDate.now()));
        allFlight.add(new Flight(fn6,LocalDate.now(), LocalDate.now()));
        allFlight.add(new Flight(fn7,LocalDate.now(), LocalDate.now()));

	}

	@Override
	public List<Airport> findAllAirports() {
		return this.airports;
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
	public List<Airport> findAirportsByCity(String city) {
		return airports
				.stream()
				.filter( a->
					a.getAddress().getCity().equalsIgnoreCase(city)
				)
				.collect(Collectors.toList());
	}

	@Override
	public List<Airline> findAirlinesByAirportCode(String airportCode) {
		return findAirportByAirportCode(airportCode).getdepartureAirlines();
	}

	@Override
	public List<Flight> findFlightsFromTo(String departure, String arrival, LocalDate date) {
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
	public List<Reservation> findReservationsByPassengerId(Integer passengerId) {
		
		return  passengers.get(passengerId).getReservationList();
	}

	@Override
	public List<Passenger> findPassengersByAgentCode(int agentCode) {
		return agents.get(agentCode).getPassengerList();
	}

    @Override
    public Passenger findPassengerById(int id) {
        return passengers.get(id);
    }

	@Override
	public Agent findAgentById(int id) {
		return agents.get(id);
	}
}
