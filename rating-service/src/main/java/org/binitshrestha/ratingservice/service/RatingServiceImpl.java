package org.binitshrestha.ratingservice.service;

import lombok.RequiredArgsConstructor;
import org.binitshrestha.ratingservice.dto.RatingCreateRequest;
import org.binitshrestha.common_contract.dto.event.RatingCreatedEvent;
import org.binitshrestha.ratingservice.dto.RatingResponse;
import org.binitshrestha.ratingservice.kafka.RatingEventProducer;
import org.binitshrestha.ratingservice.mapper.RatingMapper;
import org.binitshrestha.ratingservice.model.Rating;
import org.binitshrestha.ratingservice.repository.RatingRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RatingServiceImpl implements RatingService{
    private final RatingRepository ratingRepository;
    private final RatingEventProducer eventProducer;
    @Override
    public RatingResponse createRating(RatingCreateRequest request) {
        Rating newRating = RatingMapper.toModel(request);
        ratingRepository.save(newRating);
        // Publish Kafka Event
        RatingCreatedEvent eventToPublish = RatingMapper.toRatingCreatedEvent(newRating);
        eventProducer.publishRatingCreated(eventToPublish);
        //convert to dto
        return RatingMapper.toRatingResponse(newRating);
    }
}
