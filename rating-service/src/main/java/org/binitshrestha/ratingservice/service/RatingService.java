package org.binitshrestha.ratingservice.service;

import org.binitshrestha.ratingservice.dto.RatingCreateRequest;
import org.binitshrestha.ratingservice.dto.RatingResponse;

public interface RatingService {
    RatingResponse createRating(RatingCreateRequest request);
}
