package org.binitshrestha.ratingservice.service;

import lombok.RequiredArgsConstructor;
import org.binitshrestha.ratingservice.dto.RatingCreateRequest;
import org.binitshrestha.ratingservice.dto.RatingCreatedEvent;
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
        RatingCreatedEvent event = new RatingCreatedEvent(
                newRating.getId(),
                newRating.getRaterId(),
                newRating.getTargetId(),
                newRating.getTargetType(),
                newRating.getRatingValue(),
                newRating.getComment(),
                newRating.getCreatedAt()
        );

        return null;
    }
}
