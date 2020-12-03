package edu.miu.cs.cs401.project.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import edu.miu.cs.cs401.project.domain.*;
import edu.miu.cs.cs401.project.repository.RepositoryFactory;
import edu.miu.cs.cs401.project.repository.ReservationSystemRepository;

public class ReservationSystemFacadeImpl implements ReservationSystemFacade {

	@Override
	public List <Airport> findAllAirports() {
		List <Airport> allAirports = null;
		try {
			allAirports = (List<Airport>) RepositoryFactory.getReservationSystemRepository()
					.findAllAirports();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allAirports;
	}

	@Override
	public Airport findAirportByAirportCode(String airportCode) {
		Airport resultAirport = null;
		try {
			resultAirport = (Airport) RepositoryFactory.getReservationSystemRepository()
					.findAirportByAirportCode(airportCode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultAirport;
	}

	@Override
	public List<Airport> findAirportsByCity(String city) {
		List <Airport> cityAirports = null;
		try {
			cityAirports = (List<Airport>) RepositoryFactory.getReservationSystemRepository()
					.findAirportsByCity(city);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cityAirports;
	}

	@Override
	public List<Airline> findAirlinesByAirportCode(String airportCode) {
		List <Airline> airlinesByAirportCode = null;
		try {
			airlinesByAirportCode = (List<Airline>) RepositoryFactory.getReservationSystemRepository()
					.findAirlinesByAirportCode(airportCode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return airlinesByAirportCode;
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

	public HashMap<Passenger, List<Reservation>> findReservationsByAgentCode(int agentCode) throws Exception {

		ReservationSystemRepository repo = RepositoryFactory.getReservationSystemRepository();

		List<Passenger> passengerList = repo.findAgentById(agentCode).getPassengerList();

		HashMap<Passenger, List<Reservation>> passengerReservations = new HashMap<Passenger, List<Reservation>>();

		for (int i = 0; i < passengerList.size(); i++){
			List<Reservation> reservationList = passengerList.get(i).getReservationList();
			passengerReservations.put(passengerList.get(i), reservationList);
		}

		return passengerReservations;

	}

	public void viewReservationDetails(int agentCode, String reservationCode) throws Exception {

		ReservationSystemRepository repo = RepositoryFactory.getReservationSystemRepository();

		List<Passenger> passengerList = repo.findAgentById(agentCode).getPassengerList();

		for (int i = 0; i < passengerList.size(); i++){
			//List<Reservation> reservationList = repo.findReservationsByPassengerId(passengerList.get(i).getId());
			List<Reservation> reservationList = passengerList.get(i).getReservationList();
			for (int j = 0; j < reservationList.size(); j++){
				if (reservationList.get(j).getReservationCode().equalsIgnoreCase(reservationCode)){
					System.out.println(reservationList.get(j).toString());
				}
			}
		}

	}

	@Override
	public Reservation createReservation(Passenger passenger, List<Flight> flights) {
		Reservation reservation = new Reservation(flights);
		reservation.setStatus(Reservation.CREATED);
		passenger.addReservation(reservation);
		return reservation;
	}

	@Override
	public Reservation createReservation(Agent agent, Passenger passenger, List<Flight> flights) {
		Reservation reservation = new Reservation(flights);
		reservation.setAgentId(agent.getId());
		passenger.addReservation(reservation);
		boolean check = false;
		for (int i = 0; i < agent.getPassengerList().size(); i++){
			if (agent.getPassengerList().get(i).getId() == passenger.getId()){
				check = true;
			}
		}
		if (check == false){
			agent.addPassenger(passenger);
		}
		reservation.setStatus(Reservation.CREATED);
		return reservation;
	}

	@Override
	public void confirmReservation(Passenger passenger, String reservationCode) throws Exception {
		passenger.confirmReservation(reservationCode);
	}

	@Override
	public void cancelReservation(Passenger passenger, String reservationCode) throws Exception {
		passenger.cancelReservation(reservationCode);
	}

	@Override
	public void confirmReservation(Agent agent, String reservationCode) throws Exception {
		agent.confirmReservation(reservationCode);
	}

	@Override
	public void cancelReservation(Agent agent, String reservationCode) throws Exception {
		agent.cancelReservation(reservationCode);

	}

}
