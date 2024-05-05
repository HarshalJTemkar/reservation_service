package harshal.temkar.reservation_service.service;

import harshal.temkar.reservation_service.model.Reservation;

public interface ReservationService {

	public Reservation createReservation(Reservation reservation);
	
	public Reservation getReservationById(String id);
}
