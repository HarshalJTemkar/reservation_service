package harshal.temkar.reservation_service.kafka.servie;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import harshal.temkar.reservation_service.model.Reservation;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class ReservationEventPublisher {

	private final KafkaTemplate<String, Reservation> kafkaTemplate;

	@Value("${kafka.topic.reservationCreated}")
	private String reservationCreatedTopic;

	public void publishReservationCreatedEvent(Reservation reservation) {
		log.info("ReservationEventPublisher ==> publishReservationCreatedEvent ==> Start");
		kafkaTemplate.send(reservationCreatedTopic, reservation);
	}
}
