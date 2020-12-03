package edu.miu.cs.cs401.project;

import edu.miu.cs.cs401.project.domain.*;
import edu.miu.cs.cs401.project.repository.RepositoryFactory;
import edu.miu.cs.cs401.project.repository.ReservationSystemRepository;
import edu.miu.cs.cs401.project.service.ReservationSystemFacade;
import edu.miu.cs.cs401.project.service.ReservationSystemFacadeImpl;

import java.time.LocalDate;
import java.util.List;

public class Application {
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

	public Application() throws Exception {
	}

	public static void main(String[] args) throws Exception {
		System.out.println("Airline Reservation System");

		ReservationSystemFacade reservationSystem = new ReservationSystemFacadeImpl();

		// get a list of all Airports
		System.out.println("-------------------- get a list of all Airports -------------------------------");
		List <Airport> allAirports = reservationSystem.findAllAirports();
		String sampleCity = "";
		for (Airport a: allAirports) {
			if(sampleCity.isEmpty()) {
				sampleCity = a.getAddress().getCity();
			}
			System.out.println(a.toString());
		}

		// find an Airport by AirportCode
		System.out.println("-------------------- find an Airport by AirportCode ----------------------------");
		Airport codeAirports = reservationSystem.findAirportByAirportCode("CLT");
		System.out.println(codeAirports.toString());

		// find all Airports by a city
		System.out.println("-------------------- find all Airports by a city -------------------------------");
		System.out.println("Sample city:" + sampleCity);
		List <Airport> cityAirports = reservationSystem.findAirportsByCity(sampleCity);
		for (Airport a: cityAirports) {
			System.out.println(a.toString());
		}

		// find all Airlines departing from the Airport by AirportCode
		System.out.println("-------- find all Airlines departing from the Airport by AirportCode -----------");
		List <Airline> departingAirlines = reservationSystem.findAirlinesByAirportCode("CLT");
		for (Airline a: departingAirlines) {
			System.out.println(a.toString());
		}


		List<Flight> flightsFromCIDToCLTToday = RepositoryFactory.getReservationSystemRepository().findFlightsFromTo("CID", "CLT", LocalDate.now());
		passengerConfirm_andCancel_Reservation();

		agentConfirm_andCancel_Reservation();

		agentGetPassengerAndReservation();

	}

	private static void passengerConfirm_andCancel_Reservation() throws Exception {
		List<Flight> flightsFromCIDToCLTToday = reservationSystemRepository.findFlightsFromTo("CID", "CLT", LocalDate.now());
		System.out.println("Total flights from CID to CLT today: " + flightsFromCIDToCLTToday.size());

		// create two reservations
		Passenger p = reservationSystemRepository.findPassengerById(1);

		ReservationSystemFacade reservationSystem = new ReservationSystemFacadeImpl();
		Reservation reservation1 = reservationSystem.createReservation(p, flightsFromCIDToCLTToday);
		Reservation reservation2 = reservationSystem.createReservation(p, flightsFromCIDToCLTToday);

		// confirm reservation1
		System.out.println("-------------------- passenger confirm reservation1 -------------------------------");
		System.out.println("Before the Passenger confirm reservation1. Status: " + reservation1.getStatusDetail());
		reservationSystem.confirmReservation(p, reservation1.getReservationCode());
		System.out.println("After the Passenger confirm the reservation1. Status: " + reservation1.getStatusDetail());
		System.out.println("---- list tickets of the reservation1: ");
		for(Ticket t : reservation1.getTicketList()) {
			System.out.println("	" + t);
		}

		// cancel reservation2
		System.out.println("-------------------- passenger cancel reservation2 -------------------------------");
		System.out.println("Before the Passenger cancel reservation2. Status: " + reservation2.getStatusDetail());
		reservationSystem.cancelReservation(p, reservation2.getReservationCode());
		System.out.println("After the Passenger cancel reservation2. Status: " + reservation2.getStatusDetail());
	}

	private static void agentConfirm_andCancel_Reservation() throws Exception {
		List<Flight> flightsFromCIDToCLTToday = reservationSystemRepository.findFlightsFromTo("CID", "CLT", LocalDate.now());
		System.out.println("Total flights from CID to CLT today: " + flightsFromCIDToCLTToday.size());

		// create two reservations
		Passenger p = reservationSystemRepository.findPassengerById(1);
		Agent agent = new Agent(new Address(), "","",LocalDate.of(1989,2, 3),"");

		Reservation reservation3 = reservationSystem.createReservation(agent, p, flightsFromCIDToCLTToday);
		Reservation reservation4 = reservationSystem.createReservation(agent, p, flightsFromCIDToCLTToday);

		// agent confirm reservation3
		System.out.println("-------------------- agent confirm reservation3 -------------------------------");
		System.out.println("agentId: " + agent);
		System.out.println("Before the Agent confirm reservation3. Status: " + reservation3.getStatusDetail());
		reservationSystem.confirmReservation(agent, reservation3.getReservationCode());
		System.out.println("After the Agent confirm the reservation3. Status: " + reservation3.getStatusDetail());
		System.out.println("---- list tickets of the reservation3: ");
		for(Ticket t : reservation3.getTicketList()) {
			System.out.println("	" + t);
		}

		// agent cancel reservation4
		System.out.println("-------------------- agent cancel reservation4 -------------------------------");
		System.out.println("agentId: " + agent);
		System.out.println("Before the Agent cancel reservation4. Status: " + reservation4.getStatusDetail());
		reservationSystem.cancelReservation(agent, reservation4.getReservationCode());
		System.out.println("After the Agent cancel reservation4. Status: " + reservation4.getStatusDetail());
	}

	private static void agentGetPassengerAndReservation() throws Exception {

		System.out.println("-------------------- agent views reservation -------------------------------");
		List<Flight> flightsFromCIDToCLTToday = reservationSystemRepository.findFlightsFromTo("CID", "CLT", LocalDate.now());
		Passenger p = reservationSystemRepository.findPassengerById(1);
		Passenger p2 = reservationSystemRepository.findPassengerById(2);
		Agent agent = reservationSystemRepository.findAgentById(11);

		Reservation reservation3 = reservationSystem.createReservation(agent, p, flightsFromCIDToCLTToday);
		Reservation reservation4 = reservationSystem.createReservation(agent, p, flightsFromCIDToCLTToday);

		reservationSystem.viewReservationDetails(11, reservation3.getReservationCode());
		reservationSystem.viewReservationDetails(11, reservation4.getReservationCode());


	}

}
