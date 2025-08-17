package org.binitshrestha.ratingservice.dto;

import lombok.Builder;

@Builder
public record RatingCreateRequest(
    Long userId,
    Long lawyerId,
    Long caseId,
    String ratingType,
    int ratingValue,
    String comments
) {
}
