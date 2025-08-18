package com.binitshrestha.lawyer_service.kafka;

import lombok.extern.slf4j.Slf4j;
import org.binitshrestha.common_contract.dto.event.RatingCreatedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LawyerRatingConsumer {

    @KafkaListener(topics="rating-events", groupId="lawyer-service")
    public void handleRatingCreated(RatingCreatedEvent event){
        log.info("Lawyer-service received rating event: {}", event);

    }
}
