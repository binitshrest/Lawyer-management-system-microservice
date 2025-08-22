package org.binitshrestha.userservice.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.binitshrestha.common_contract.dto.event.RatingCreatedEvent;
import org.binitshrestha.userservice.mapper.UserMapper;
import org.binitshrestha.userservice.model.UserRating;
import org.binitshrestha.userservice.repository.UserRatingRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static org.binitshrestha.userservice.mapper.UserMapper.toUserRatingModel;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserRatingConsumer {
    private final UserRatingRepository userRatingRepository;

    @KafkaListener(topics = "rating-events", groupId = "user-service")
    public void handleRatingCreated(RatingCreatedEvent event){
        log.info("User-service received rating event: {}", event);
        UserRating newUserRating = UserMapper.toUserRatingModel(event);
        userRatingRepository.save(newUserRating);
    }
}
