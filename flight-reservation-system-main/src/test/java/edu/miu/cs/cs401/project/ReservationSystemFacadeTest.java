package edu.miu.cs.cs401.project;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import edu.miu.cs.cs401.project.domain.*;
import org.junit.Test;

import edu.miu.cs.cs401.project.repository.RepositoryFactory;
import edu.miu.cs.cs401.project.repository.ReservationSystemRepository;
import edu.miu.cs.cs401.project.service.ReservationSystemFacade;
import edu.miu.cs.cs401.project.service.ReservationSystemFacadeImpl;

import static org.junit.Assert.*;

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

	@Test
	public void findAllAirports(){
		
		List<Airport> airports = resSystemFacade.findAllAirports();
		System.out.println("airpots : "+airports.toString());
		assertNotNull(airports);
		assertFalse("list of airports is empty", airports.isEmpty());
	}
	
	@Test
	public void findAirportByAirportCode(){
		String airportCode = "CID";
		
		Airport airport = resSystemFacade.findAirportByAirportCode(airportCode);
		
		assertNotNull(airport);
	}
	
	@Test
	public void findAirportsByCity(){
		String city = reservationSystemRepository.getSampleCity();
		System.out.println("Sample city:" + city);

		List<Airport> airport = resSystemFacade.findAirportsByCity(city);
		
		System.out.println("size: "+airport.size());
		
		assertNotNull(airport);
	}
	
	@Test
	public void findAirlinesByAirportCode(){
		String airportCode = "CID";
		
		List <Airline> departingAirlines = resSystemFacade.findAirlinesByAirportCode(airportCode);
		System.out.println("size: " + departingAirlines.size());
		assertNotNull(departingAirlines);
		assertFalse("list of airlines is empty", departingAirlines.isEmpty());
	
	}
	
	@Test
	public void findFlightsFromTo(){
		String departure = "CID";
		String arrival = "CLT";
		LocalDate date = LocalDate.of(2020, 12, 03);
		System.out.println("-------------------- Search for flights  -------------------------------");
		System.out.println("from '"+departure+"' to '"+arrival+"'");
		System.out.println("Date '"+date.format(DateTimeFormatter.ofPattern("dd LLLL yyyy"))+"'");

		List<Flight> flights = reservationSystem.findFlightsFromTo(departure, arrival, date);
		
		assertNotNull("Can't be null", flights);
	}
	
	@Test
	public void findReservationsByPassengerId(){
		Integer passengerId = 5;
		
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

	@Test public void givenPassenger_andValidReservationCode_whenConfirmReservation_thenReservationIsConfirm_andTicketsCreated() throws Exception {
		List<Flight> flightsFromCIDToCLTToday = reservationSystem.findFlightsFromTo("CID", "CLT", LocalDate.now());
		// create reservation
		Passenger p = new Passenger(new Address(), "John", "Dan", LocalDate.of(1990, 12, 1) , "JohnDan@gmail.com");
		Reservation reservation1 = reservationSystem.createReservation(p, flightsFromCIDToCLTToday);
		// confirm reservation1
		reservationSystem.confirmReservation(p, reservation1.getReservationCode());

		assertEquals(Reservation.CONFIRMED_PURCHASED, reservation1.getStatus());
		assertEquals(flightsFromCIDToCLTToday.size(), reservation1.getFlightList().size());
	}

	@Test(expected = Exception.class)
	public void givenPassenger_andValidReservationCode_withConfirmedStatus_whenConfirmReservation_thenThrowException() throws Exception {
		List<Flight> flightsFromCIDToCLTToday = reservationSystem.findFlightsFromTo("CID", "CLT", LocalDate.now());
		// create reservation
		Passenger p = new Passenger(new Address(), "John", "Dan", LocalDate.of(1990, 12, 1) , "JohnDan@gmail.com");
		Reservation reservation1 = reservationSystem.createReservation(p, flightsFromCIDToCLTToday);
		reservation1.setStatus(Reservation.CONFIRMED_PURCHASED);
		// confirm reservation1
		reservationSystem.confirmReservation(p, reservation1.getReservationCode());
	}

	@Test(expected = Exception.class)
	public void givenPassenger_andValidReservationCode_withCanceledStatus_whenConfirmReservation_thenThrowException() throws Exception {
		List<Flight> flightsFromCIDToCLTToday = reservationSystem.findFlightsFromTo("CID", "CLT", LocalDate.now());
		// create reservation
		Passenger p = new Passenger(new Address(), "John", "Dan", LocalDate.of(1990, 12, 1) , "JohnDan@gmail.com");
		Reservation reservation1 = reservationSystem.createReservation(p, flightsFromCIDToCLTToday);
		reservation1.setStatus(Reservation.CANCEL);
		// confirm reservation1
		reservationSystem.confirmReservation(p, reservation1.getReservationCode());
	}

	@Test(expected = Exception.class)
	public void givenPassenger_andInValidReservationCode_whenconfirmReservation_thenThrowException() throws Exception {
		Passenger p = new Passenger(new Address(), "John", "Dan", LocalDate.of(1990, 12, 1) , "JohnDan@gmail.com");
		reservationSystem.confirmReservation(p, "INVALID_RESERVATION_CODE");
	}

	@Test public void givenAgent_andValidReservationCode_whenConfirmReservation_thenReservationIsConfirm_andTicketsCreated() throws Exception {
		List<Flight> flightsFromCIDToCLTToday = reservationSystem.findFlightsFromTo("CID", "CLT", LocalDate.now());
		// create reservation
		Passenger p = new Passenger(new Address(), "John", "Dan", LocalDate.of(1990, 12, 1) , "JohnDan@gmail.com");
		Agent agent = new Agent(new Address(), "","",LocalDate.of(1989,2, 3),"");
		Reservation reservation3 = reservationSystem.createReservation(agent, p, flightsFromCIDToCLTToday);

		reservationSystem.confirmReservation(agent, reservation3.getReservationCode());

		assertEquals(Reservation.CONFIRMED_PURCHASED, reservation3.getStatus());
		assertEquals(flightsFromCIDToCLTToday.size(), reservation3.getFlightList().size());
	}

	@Test(expected = Exception.class)
	public void givenAgent_andValidReservationCode_withConfirmedStatus_whenConfirmReservation_thenThrowException() throws Exception {
		List<Flight> flightsFromCIDToCLTToday = reservationSystem.findFlightsFromTo("CID", "CLT", LocalDate.now());
		// create reservation
		Passenger p = new Passenger(new Address(), "John", "Dan", LocalDate.of(1990, 12, 1) , "JohnDan@gmail.com");
		Agent agent = new Agent(new Address(), "","",LocalDate.of(1989,2, 3),"");

		Reservation reservation1 = reservationSystem.createReservation(p, flightsFromCIDToCLTToday);
		reservation1.setStatus(Reservation.CONFIRMED_PURCHASED);
		// confirm reservation1
		reservationSystem.confirmReservation(agent, reservation1.getReservationCode());
	}

	@Test(expected = Exception.class)
	public void givenAgent_andValidReservationCode_withCanceledStatus_whenConfirmReservation_thenThrowException() throws Exception {
		List<Flight> flightsFromCIDToCLTToday = reservationSystem.findFlightsFromTo("CID", "CLT", LocalDate.now());
		// create reservation
		Passenger p = new Passenger(new Address(), "John", "Dan", LocalDate.of(1990, 12, 1) , "JohnDan@gmail.com");
		Agent agent = new Agent(new Address(), "","",LocalDate.of(1989,2, 3),"");

		Reservation reservation1 = reservationSystem.createReservation(p, flightsFromCIDToCLTToday);
		reservation1.setStatus(Reservation.CANCEL);
		// confirm reservation1
		reservationSystem.confirmReservation(agent, reservation1.getReservationCode());
	}

	@Test(expected = Exception.class)
	public void givenAgent_andInValidReservationCode_whenConfirmReservation_thenThrowException() throws Exception {
		Passenger p = new Passenger(new Address(), "John", "Dan", LocalDate.of(1990, 12, 1) , "JohnDan@gmail.com");
		Agent agent = new Agent(new Address(), "","",LocalDate.of(1989,2, 3),"");

		reservationSystem.confirmReservation(agent, "INVALID_RESERVATION_CODE");
	}

	@Test
	public void givenPassenger_andValidReservationCode_whenCancelReservation_thenReservationCanceled() throws Exception {
		List<Flight> flightsFromCIDToCLTToday = reservationSystemRepository.findFlightsFromTo("CID", "CLT", LocalDate.now());
		Passenger p = new Passenger(new Address(), "John", "Dan", LocalDate.of(1990, 12, 1) , "JohnDan@gmail.com");
		Reservation reservation3 = reservationSystem.createReservation(p, flightsFromCIDToCLTToday);

		reservationSystem.cancelReservation(p, reservation3.getReservationCode());
		assertEquals(Reservation.CANCEL, reservation3.getStatus());
	}
	@Test(expected = Exception.class)
	public void givenPassenger_andValidReservationCode_withCanceledStatus_whenCancelReservation_thenThrowException() throws Exception {
		List<Flight> flightsFromCIDToCLTToday = reservationSystemRepository.findFlightsFromTo("CID", "CLT", LocalDate.now());
		Passenger p = new Passenger(new Address(), "John", "Dan", LocalDate.of(1990, 12, 1) , "JohnDan@gmail.com");
		Reservation reservation3 = reservationSystem.createReservation(p, flightsFromCIDToCLTToday);
		reservation3.setStatus(Reservation.CANCEL);
		reservationSystem.cancelReservation(p, reservation3.getReservationCode());
	}

	@Test(expected = Exception.class)
	public void givenPassenger_andValidReservationCode_withConfirmedStatus_whenCancelReservation_thenThrowException() throws Exception {
		List<Flight> flightsFromCIDToCLTToday = reservationSystemRepository.findFlightsFromTo("CID", "CLT", LocalDate.now());
		Passenger p = new Passenger(new Address(), "John", "Dan", LocalDate.of(1990, 12, 1) , "JohnDan@gmail.com");
		Reservation reservation3 = reservationSystem.createReservation(p, flightsFromCIDToCLTToday);
		reservation3.setStatus(Reservation.CONFIRMED_PURCHASED);
		reservationSystem.cancelReservation(p, reservation3.getReservationCode());
	}
	@Test(expected = Exception.class)
	public void givenPassenger_andInvalidReservationCode_whenCancelReservation_thenThrowException() throws Exception {
		Passenger p = new Passenger(new Address(), "John", "Dan", LocalDate.of(1990, 12, 1) , "JohnDan@gmail.com");
		reservationSystem.cancelReservation(p, "INVALID_RESERVATION_CODE");
	}

	@Test
	public void givenAgent_andValidReservationCode_whenCancelReservation_thenReservationCanceled() throws Exception {
		List<Flight> flightsFromCIDToCLTToday = reservationSystemRepository.findFlightsFromTo("CID", "CLT", LocalDate.now());
		Passenger p = new Passenger(new Address(), "John", "Dan", LocalDate.of(1990, 12, 1) , "JohnDan@gmail.com");
		Agent agent = new Agent(new Address(), "","",LocalDate.of(1989,2, 3),"");

		Reservation reservation3 = reservationSystem.createReservation(agent, p, flightsFromCIDToCLTToday);

		reservationSystem.cancelReservation(agent, reservation3.getReservationCode());
		assertEquals(Reservation.CANCEL, reservation3.getStatus());
	}
	@Test(expected = Exception.class)
	public void givenAgent_andValidReservationCode_withCanceledStatus_whenCancelReservation_thenThrowException() throws Exception {
		List<Flight> flightsFromCIDToCLTToday = reservationSystemRepository.findFlightsFromTo("CID", "CLT", LocalDate.now());
		Passenger p = new Passenger(new Address(), "John", "Dan", LocalDate.of(1990, 12, 1) , "JohnDan@gmail.com");
		Agent agent = new Agent(new Address(), "","",LocalDate.of(1989,2, 3),"");

		Reservation reservation3 = reservationSystem.createReservation(agent, p, flightsFromCIDToCLTToday);
		reservation3.setStatus(Reservation.CANCEL);
		reservationSystem.cancelReservation(agent, reservation3.getReservationCode());
	}

	@Test(expected = Exception.class)
	public void givenAgent_andValidReservationCode_withConfirmedStatus_whenCancelReservation_thenThrowException() throws Exception {
		List<Flight> flightsFromCIDToCLTToday = reservationSystemRepository.findFlightsFromTo("CID", "CLT", LocalDate.now());
		Passenger p = new Passenger(new Address(), "John", "Dan", LocalDate.of(1990, 12, 1) , "JohnDan@gmail.com");
		Agent agent = new Agent(new Address(), "","",LocalDate.of(1989,2, 3),"");

		Reservation reservation3 = reservationSystem.createReservation(agent, p, flightsFromCIDToCLTToday);
		reservation3.setStatus(Reservation.CONFIRMED_PURCHASED);
		reservationSystem.cancelReservation(agent, reservation3.getReservationCode());
	}
	@Test(expected = Exception.class)
	public void givenAgent_andInvalidReservationCode_whenCancelReservation_thenThrowException() throws Exception {
		Agent agent = new Agent(new Address(), "","",LocalDate.of(1989,2, 3),"");
		reservationSystem.cancelReservation(agent, "INVALID_RESERVATION_CODE");
	}
	//@Test
	
	void confirmReservation(Agent agent, String reservationCode) {
		
	}
	
	//@Test
	
	void cancelReservation(Agent agent, String reservationCode) {
		
	}
}
