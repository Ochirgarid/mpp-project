package edu.miu.cs.cs401.project;

import edu.miu.cs.cs401.project.domain.Address;
import edu.miu.cs.cs401.project.domain.Airport;
import edu.miu.cs.cs401.project.domain.Flight;
import edu.miu.cs.cs401.project.repository.RepositoryFactory;
import edu.miu.cs.cs401.project.service.ReservationSystemFacade;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public class Application {

	public static void main(String[] args) throws Exception {
		System.out.println("Airline Reservation System");
		System.out.println("Added new here to test");
//		airport1 = new Airport("CID", "Eastern Iowa Airport", new Address());
//		airport2 = new Airport("ORD", "Chicago O'Hare International Airport", new Address());
//		airport3 = new Airport("CLT", "Charlotte Douglas International Airport", new Address());
		Collection<Flight> flightsFromCIDToCLTToday = RepositoryFactory.getReservationSystemRepository().findFlightsFromTo("CID", "CLT", LocalDate.now());
		System.out.println("total flights from CID to CLT today: " + flightsFromCIDToCLTToday.size());
	}

}
