package harshal.temkar.reservation_service.kafka.servie;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import harshal.temkar.reservation_service.kafka.model.Notification;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class NotificationEventConsumer {

	@KafkaListener(topics = "${kafka.topic.notificationCreated}")
    public void consumeNotificatonCreatedEvent(Notification notification) {
		log.info("NotificationEventConsumer ==> consumeNotificatonCreatedEvent ==> Start");
		log.info(notification);
    }
}
