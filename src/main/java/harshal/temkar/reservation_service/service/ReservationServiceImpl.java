package harshal.temkar.reservation_service.service;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import harshal.temkar.reservation_service.dao.ReservationDao;
import harshal.temkar.reservation_service.exception.IdNotFoundException;
import harshal.temkar.reservation_service.kafka.servie.ReservationEventPublisher;
import harshal.temkar.reservation_service.model.Reservation;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Transactional
@Log4j2
@RequiredArgsConstructor
@CacheConfig(cacheNames = { "reservation" })
public class ReservationServiceImpl implements ReservationService {
	
	private final ReservationDao reservationDao;
	
	private final ReservationEventPublisher reservationEventPublisher;

	@Override
	@CacheEvict(allEntries = true)
	public Reservation createReservation(Reservation reservation) {
		log.info("ReservationServiceImpl ==> createReservation ==> Start");
		reservation = reservationDao.save(reservation);
		log.info("ReservationServiceImpl ==> createReservation ==> publishReservationCreatedEvent ==> Start");
		reservationEventPublisher.publishReservationCreatedEvent(reservation);
		return reservation;
	}

	@Override
	@Cacheable(key = "#id", unless = "#result == null")
	public Reservation getReservationById(String id) {
		log.info("ReservationServiceImpl ==> getReservationById ==> Start");
		return reservationDao.findById(id).orElseThrow(() -> new IdNotFoundException("Not Found", new Throwable("Id not found: " + id)));
	}

}
