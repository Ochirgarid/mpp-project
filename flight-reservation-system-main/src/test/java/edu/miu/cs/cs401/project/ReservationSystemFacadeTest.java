package edu.miu.cs.cs401.project;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import edu.miu.cs.cs401.project.domain.Agent;
import edu.miu.cs.cs401.project.domain.Airline;
import edu.miu.cs.cs401.project.domain.Airport;
import edu.miu.cs.cs401.project.domain.Flight;
import edu.miu.cs.cs401.project.domain.Passenger;
import edu.miu.cs.cs401.project.domain.Reservation;
import edu.miu.cs.cs401.project.repository.RepositoryFactory;
import edu.miu.cs.cs401.project.repository.ReservationSystemRepository;
import edu.miu.cs.cs401.project.repository.ReservationSystemRepositoryImpl;
import edu.miu.cs.cs401.project.service.ReservationSystemFacade;
import edu.miu.cs.cs401.project.service.ReservationSystemFacadeImpl;

public class ReservationSystemFacadeTest {
	
	ReservationSystemFacade resSystemFacade = new ReservationSystemFacadeImpl();
	private static ReservationSystemRepository reservationSystemRepository;
	private static ReservationSystemFacade reservationSystem;

	static {
		try {
			reservationSystemRepository = RepositoryFactory.getReservationSystemRepository();
			reservationSystem = new ReservationSystemFacadeImpl();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//@Test
	public void findAllAirports(){
		
		List<Airport> airports = resSystemFacade.findAllAirports();
		System.out.println("airpots : "+airports.toString());
		assertNotNull(airports);
		assertFalse("list of airports is empty", airports.isEmpty());
	}
	
	//@Test
	public void findAirportByAirportCode(){
		String airportCode = "CID";
		
		Airport airport = resSystemFacade.findAirportByAirportCode(airportCode);
		
		assertNotNull(airport);
	}
	
	//@Test
	public void findAirportsByCity(){
		String city = reservationSystemRepository.getSampleCity();
		System.out.println("Sample city:" + city);

		List<Airport> airport = resSystemFacade.findAirportsByCity(city);
		
		System.out.println("size: "+airport.size());
		
		assertNotNull(airport);
	}
	
	//@Test
	public void findAirlinesByAirportCode(){
		String airportCode = "CID";
		
		List <Airline> departingAirlines = resSystemFacade.findAirlinesByAirportCode(airportCode);
		System.out.println("size: " + departingAirlines.size());
		assertNotNull(departingAirlines);
		assertFalse("list of airlines is empty", departingAirlines.isEmpty());
	
	}
	
	//@Test
	public void findFlightsFromTo(String departure, String arrival, LocalDate date){
		
	}
	
	@Test
	public void findReservationsByPassengerId(){
		Integer passengerId = 2;
		
		Passenger p = reservationSystemRepository.findPassengerById(passengerId);
		
		List<Flight> flightsFromCIDToCLTToday = resSystemFacade.findFlightsFromTo("CID", "CLT", LocalDate.now());

		Reservation reservation3 = resSystemFacade.createReservation(p, flightsFromCIDToCLTToday);
		Reservation reservation4 = resSystemFacade.createReservation(p, flightsFromCIDToCLTToday);
		List<Reservation> reservations = resSystemFacade.findReservationsByPassengerId(passengerId);
		
		assertNotNull("Can't be null", reservations);
		assertTrue("It is empty",reservations.size()>0);
	}

	//@Test
	public void findReservationsByAgentCode(int agentCode) {
		
	}
	
	//@Test
	
	public void createReservation(Passenger passenger, List<Flight> flights){
		
	}
	
	//@Test
	
	public void createReservation(Agent agent, Passenger passenger, List<Flight> flights) {
		
	}

	//@Test
	
	public void viewReservationDetails(int agentCode, String reservationCode) {
		
	}
	
	//@Test
	
	public void confirmReservation(Passenger passenger, String reservationCode) {
		
	}
	
	//@Test
	
	public void cancelReservation(Passenger passenger, String reservationCode) {
		
	}

	//@Test
	
	void confirmReservation(Agent agent, String reservationCode) {
		
	}
	
	//@Test
	
	void cancelReservation(Agent agent, String reservationCode) {
		
	}
}
