package edu.miu.cs.cs401.project;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.miu.cs.cs401.project.domain.*;
import org.junit.Before;
import org.junit.Test;

import edu.miu.cs.cs401.project.service.ReservationSystemFacade;
import edu.miu.cs.cs401.project.service.ReservationSystemFacadeImpl;

/**
 * Unit test for simple App.
 */
public class CreateReservationTest 
{
    Passenger p;
    List<Flight> flightList;

    @Before
    public void initData() {
        Pilot[] pilots = {
                new Pilot(new Address(), "John", "Al", LocalDate.of(1989, 3, 24), "john@gmail.com"),
                new Pilot(new Address(), "Dang", "Nguyen", LocalDate.of(1988, 8, 3), "dang@gmail.com")};
        Crew[] crews = {
                new Crew(new Address(), "Diana", "Al", LocalDate.of(1989, 3, 24), "john@gmail.com"),
                new Crew(new Address(), "Maria", "Nguyen", LocalDate.of(1988, 8, 3), "dang@gmail.com")};
        Address address = new Address("street", "city", "state", "zipCode");
        p = new Passenger(address, "dang", "nguyen", LocalDate.of(1989, 3, 24), "hainguyen@miu.edu.vn");
        flightList = new ArrayList<>();

        Airport depature = new Airport("ap1", "AIRPORT1", address);
        Airport arrival = new Airport("ap2", "AIRPORT2", address);

        FlightNumber fn1 = new FlightNumber("fn1", 100, LocalTime.of(7, 15), LocalTime.of(9, 15), depature, arrival);
        Flight f1 = new Flight(fn1, LocalDate.of(2020, 12, 1), LocalDate.of(2020, 12, 02), Arrays.asList(crews), Arrays.asList(pilots));
        flightList.add(f1);
        System.out.println("flightList====:" + flightList.size());


    }

    /**
     * Create a reservation by a passenger test
     */
    @Test
    public void givenPassenger_withoutReservation_whenCreateReservation_thenReservationExistOnThatPassenger()
    {
        ReservationSystemFacadeImpl reservationSystem = new ReservationSystemFacadeImpl();
        Reservation reservation = reservationSystem.createReservation(p, flightList);

        assertEquals(p.getReservationList().size(), 1);
        assertEquals(flightList.size(), reservation.getFlightList().size());

    }
}
