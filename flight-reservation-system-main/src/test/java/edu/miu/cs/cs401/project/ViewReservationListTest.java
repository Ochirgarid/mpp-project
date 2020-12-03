package edu.miu.cs.cs401.project;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import edu.miu.cs.cs401.project.domain.Reservation;
import edu.miu.cs.cs401.project.service.ReservationSystemFacadeImpl;

public class ViewReservationListTest {

	@Test
	public void viewReservationList() {
		Integer passengerId = 1;
		
		ReservationSystemFacadeImpl reservationSystem = new ReservationSystemFacadeImpl();
        List<Reservation> reservations = reservationSystem.findReservationsByPassengerId(passengerId);

        System.out.println(reservations.toString());
        //assertEquals(p.getReservationList().size(), 1);
        //assertEquals(flightList.size(), reservation.getFlightList().size());
	}
}
