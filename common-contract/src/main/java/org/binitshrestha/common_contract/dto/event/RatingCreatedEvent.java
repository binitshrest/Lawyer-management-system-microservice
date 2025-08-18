package org.binitshrestha.common_contract.dto.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Builder
@AllArgsConstructor
@Getter @Setter
public record RatingCreatedEvent(
        String ratingId,
        String userId,
        String lawyerId,
        String targetType,
        double ratingValue,
        String comment,
        Instant createdAt
) {
}