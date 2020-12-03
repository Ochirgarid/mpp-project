package edu.miu.cs.cs401.project;

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
import edu.miu.cs.cs401.project.service.ReservationSystemFacade;
import edu.miu.cs.cs401.project.service.ReservationSystemFacadeImpl;

public class ReservationSystemFacadeTest {
	
	ReservationSystemFacade resSystemFacade = new ReservationSystemFacadeImpl();

	@Test
	@Ignore
	public void findAllAirports(){
		
		List<Airport> airports = resSystemFacade.findAllAirports();
		
		assertNotNull(airports);
		assertTrue("list of airports is empty", airports.isEmpty());
	}
	
	@Test
	@Ignore
	public void findAirportByAirportCode(){
		String airportCode = "CID";
		
		Airport airport = resSystemFacade.findAirportByAirportCode(airportCode);
		
		assertNotNull(airport);
	}
	
	@Test
	@Ignore
	public void findAirportsByCity(String city){
		
	}
	
	@Test
	@Ignore
	public void findAirlinesByAirportCode(String airportCode){
		
	}
	
	@Test
	@Ignore
	public void findFlightsFromTo(String departure, String arrival, LocalDate date){
		
	}
	
	@Test
	@Ignore
	public void findReservationsByPassengerId(Integer passengerId){
		
	}

	@Test
	@Ignore
	public void findReservationsByAgentCode(int agentCode) {
		
	}
	
	@Test
	@Ignore
	public void createReservation(Passenger passenger, List<Flight> flights){
		
	}
	
	@Test
	@Ignore
	public void createReservation(Agent agent, Passenger passenger, List<Flight> flights) {
		
	}

	@Test
	@Ignore
	public void viewReservationDetails(int agentCode, String reservationCode) {
		
	}
	
	@Test
	@Ignore
	public void confirmReservation(Passenger passenger, String reservationCode) {
		
	}
	
	@Test
	@Ignore
	public void cancelReservation(Passenger passenger, String reservationCode) {
		
	}

	@Test
	@Ignore
	void confirmReservation(Agent agent, String reservationCode) {
		
	}
	
	@Test
	@Ignore
	void cancelReservation(Agent agent, String reservationCode) {
		
	}
}
