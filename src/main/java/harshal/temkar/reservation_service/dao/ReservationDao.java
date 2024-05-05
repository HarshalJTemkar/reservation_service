package harshal.temkar.reservation_service.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import harshal.temkar.reservation_service.model.Reservation;

public interface ReservationDao extends JpaRepository<Reservation, String> {

}
