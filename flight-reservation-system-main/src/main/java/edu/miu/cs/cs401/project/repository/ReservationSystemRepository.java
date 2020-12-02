package edu.miu.cs.cs401.project.repository;

import java.util.Collection;

import edu.miu.cs.cs401.project.domain.Airline;
import edu.miu.cs.cs401.project.domain.Airport;
import edu.miu.cs.cs401.project.domain.Flight;
import edu.miu.cs.cs401.project.domain.Passenger;
import edu.miu.cs.cs401.project.domain.Reservation;

public interface ReservationSystemRepository {
	
	Collection<Airport> findAllAirports();
	
	Airport findAirportByAirportCode(String airportCode);
	
	Collection<Airport> findAirportsByCity(String city); // Airport(s) of a city, e.g. Chicago has two major airports
	
	Collection<Airline> findAirlinesByAirportCode(String airportCode);
	
	Collection<Flight> findFlightsFromTo(String departure, String arrival);
	
	Collection<Reservation> findReservationsByPassengerId(Integer passengerId);
	
	Collection<Passenger> findPassengersByAgentCode(String agentCode);
	
}
