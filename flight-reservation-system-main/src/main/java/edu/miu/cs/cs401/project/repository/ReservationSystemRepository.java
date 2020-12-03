package edu.miu.cs.cs401.project.repository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import edu.miu.cs.cs401.project.domain.*;

public interface ReservationSystemRepository {
	
	List<Airport> findAllAirports();
	
	Airport findAirportByAirportCode(String airportCode);

	List<Airport> findAirportsByCity(String city); // Airport(s) of a city, e.g. Chicago has two major airports

	List<Airline> findAirlinesByAirportCode(String airportCode);

	List<Flight> findFlightsFromTo(String departure, String arrival, LocalDate date);

	List<Reservation> findReservationsByPassengerId(Integer passengerId);
	
	List<Passenger> findPassengersByAgentCode(String agentCode);

	Passenger findPassengerById(int id);

	Agent findAgentById(int id);

}
