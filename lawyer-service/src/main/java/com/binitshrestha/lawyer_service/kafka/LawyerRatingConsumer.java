package com.binitshrestha.lawyer_service.kafka;

import com.binitshrestha.lawyer_service.mapper.LawyerMapper;
import com.binitshrestha.lawyer_service.model.LawyerRating;
import com.binitshrestha.lawyer_service.repository.LawyerRatingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.binitshrestha.common_contract.dto.event.RatingCreatedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class LawyerRatingConsumer {
    private final LawyerRatingRepository lawyerRatingRepository;

    @KafkaListener(topics="rating-events", groupId="lawyer-service")
    public void handleRatingCreated(RatingCreatedEvent event){
        log.info("Lawyer-service received rating event: {}", event);

        LawyerRating newLawyerRating = LawyerMapper.toLawyerRatingModel(event);
        lawyerRatingRepository.save(newLawyerRating);
    }
}
