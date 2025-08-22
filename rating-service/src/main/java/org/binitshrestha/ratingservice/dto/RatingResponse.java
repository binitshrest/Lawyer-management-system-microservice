package org.binitshrestha.ratingservice.dto;

import lombok.Builder;

import java.time.Instant;

@Builder
public record RatingResponse(
        String ratingId,
        String userId,
        String lawyerId,
        double score,
        String comment,
        Instant CreatedAt,
        String givenBy
) {
}
