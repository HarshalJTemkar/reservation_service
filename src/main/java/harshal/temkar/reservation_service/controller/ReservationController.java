package harshal.temkar.reservation_service.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import harshal.temkar.reservation_service.model.Reservation;
import harshal.temkar.reservation_service.service.ReservationService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/rest-api/reservation/v1")
@RequiredArgsConstructor
@Log4j2
public class ReservationController {
	
	private final ReservationService reservationService;

	@PostMapping
	public ResponseEntity<Reservation> createReservation(@Valid @RequestBody Reservation reservation) {
		log.info("ReservationController ==> createReservation ==> Start");
		return new ResponseEntity<>(reservationService.createReservation(reservation), HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Reservation> getReservationById(@NotBlank @PathVariable String id) {
		log.info("ReservationController ==> getReservationById ==> Start");
		return ResponseEntity.ok(reservationService.getReservationById(id));
	}
}
