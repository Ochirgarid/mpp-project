package edu.miu.cs.cs401.project;

import edu.miu.cs.cs401.project.domain.*;
import edu.miu.cs.cs401.project.repository.RepositoryFactory;
import edu.miu.cs.cs401.project.service.ReservationSystemFacade;
import edu.miu.cs.cs401.project.service.ReservationSystemFacadeImpl;

import java.time.LocalDate;
import java.util.List;

public class Application {

	public static void main(String[] args) throws Exception {
		System.out.println("Airline Reservation System");

		List<Flight> flightsFromCIDToCLTToday = RepositoryFactory.getReservationSystemRepository().findFlightsFromTo("CID", "CLT", LocalDate.now());
		System.out.println("Total flights from CID to CLT today: " + flightsFromCIDToCLTToday.size());

		// create two reservations
		Passenger p = RepositoryFactory.getReservationSystemRepository().findPassengerById(1);

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

}
