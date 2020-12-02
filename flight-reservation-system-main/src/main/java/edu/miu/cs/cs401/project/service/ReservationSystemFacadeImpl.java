package edu.miu.cs.cs401.project.service;

import java.time.LocalDate;
import java.util.List;

import edu.miu.cs.cs401.project.domain.Agent;
import edu.miu.cs.cs401.project.domain.Airline;
import edu.miu.cs.cs401.project.domain.Airport;
import edu.miu.cs.cs401.project.domain.Flight;
import edu.miu.cs.cs401.project.domain.Passenger;
import edu.miu.cs.cs401.project.domain.Reservation;
import edu.miu.cs.cs401.project.repository.RepositoryFactory;

public class ReservationSystemFacadeImpl implements ReservationSystemFacade {

	@Override
	public List<Airport> findAllAirports() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Airport findAirportByAirportCode(String airportCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Airport> findAirportsByCity(String city) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Airline> findAirlinesByAirportCode(String airportCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Flight> findFlightsFromTo(String departure, String arrival, LocalDate date) {
		List<Flight> res = null;
		try {
			res = (List<Flight>) RepositoryFactory.getReservationSystemRepository()
					.findFlightsFromTo( departure, arrival, date);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public List<Reservation> findReservationsByPassengerId(Integer passengerId) {
		List<Reservation> res = null;
		try {
			res = (List<Reservation>) RepositoryFactory.getReservationSystemRepository()
					.findReservationsByPassengerId(passengerId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public List<Passenger> findPassengersByAgentCode(String agentCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reservation createReservation(Passenger passenger, List<Flight> flights) {
		
		Reservation reservation = new Reservation(flights);
		passenger.addReservation(reservation);
		return reservation;

	}

	@Override
	public Reservation createReservation(Agent agent, Passenger passenger, List<Flight> flights) {
		Reservation reservation = new Reservation(flights);
		reservation.setAgentId(agent.getId());
		passenger.addReservation(reservation);
		agent.addPassenger(passenger);
		return reservation;
	}

	@Override
	public void confirmReservation(Passenger passenger, String reservationCode) {
		// TODO Auto-generated method stub

	}

	@Override
	public void cancelReservation(Passenger passenger, String reservationCode) {
		// TODO Auto-generated method stub
	}

	@Override
	public void confirmReservation(Agent agent, String reservationCode) {
		// TODO Auto-generated method stub

	}

	@Override
	public void cancelReservation(Agent agent, String reservationCode) {
		// TODO Auto-generated method stub

	}

}
