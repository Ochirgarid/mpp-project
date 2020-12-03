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
		System.out.println("Added new here to test");
//		airport1 = new Airport("CID", "Eastern Iowa Airport", new Address());
//		airport2 = new Airport("ORD", "Chicago O'Hare International Airport", new Address());
//		airport3 = new Airport("CLT", "Charlotte Douglas International Airport", new Address());
		List<Flight> flightsFromCIDToCLTToday = RepositoryFactory.getReservationSystemRepository().findFlightsFromTo("CID", "CLT", LocalDate.now());
		System.out.println("total flights from CID to CLT today: " + flightsFromCIDToCLTToday.size());


		// create two reservations
		Passenger p = RepositoryFactory.getReservationSystemRepository().findPassengerById(1);
		System.out.print(p.getReservationList().size());

		ReservationSystemFacade reservationSystem = new ReservationSystemFacadeImpl();
		reservationSystem.createReservation(p, flightsFromCIDToCLTToday);
		reservationSystem.createReservation(p, flightsFromCIDToCLTToday);

		System.out.print(p.getReservationList().size());

		// cancel reservation

	}

}
