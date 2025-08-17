package org.binitshrestha.ratingservice.service;

import lombok.RequiredArgsConstructor;
import org.binitshrestha.ratingservice.dto.RatingCreateRequest;
import org.binitshrestha.ratingservice.dto.RatingResponse;
import org.binitshrestha.ratingservice.repository.RatingRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RatingServiceImpl implements RatingService{
    private final RatingRepository ratingRepository;
    @Override
    public RatingResponse createRating(RatingCreateRequest request) {
        return null;
    }
}
