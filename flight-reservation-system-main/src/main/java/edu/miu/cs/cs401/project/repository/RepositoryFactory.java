package edu.miu.cs.cs401.project.repository;

public class RepositoryFactory {
	
	private static ReservationSystemRepository reservationSystemRepository;


	public static ReservationSystemRepository getReservationSystemRepository() throws Exception {
		if(reservationSystemRepository == null){
			reservationSystemRepository = new ReservationSystemRepositoryImpl();
		}
		return reservationSystemRepository;
	}
	

}
