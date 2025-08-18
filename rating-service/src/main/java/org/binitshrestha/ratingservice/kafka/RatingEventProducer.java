package org.binitshrestha.ratingservice.kafka;

import lombok.RequiredArgsConstructor;
import org.binitshrestha.common_contract.dto.event.RatingCreatedEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RatingEventProducer {
    private final KafkaTemplate<String, RatingCreatedEvent> kafkaTemplate;
    public void publishRatingCreated(RatingCreatedEvent event){
        kafkaTemplate.send("rating-events", event.ratingId(), event);
    }

}
