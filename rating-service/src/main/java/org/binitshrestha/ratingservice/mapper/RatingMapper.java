package org.binitshrestha.ratingservice.mapper;

import org.binitshrestha.common_contract.enums.RoleType;
import org.binitshrestha.ratingservice.dto.RatingCreateRequest;
import org.binitshrestha.common_contract.dto.event.RatingCreatedEvent;
import org.binitshrestha.ratingservice.dto.RatingResponse;
import org.binitshrestha.ratingservice.model.Rating;

public class RatingMapper {
    public static Rating toModel(RatingCreateRequest request) {
        return Rating.builder()
                .raterId(request.userId())
                .targetId(request.lawyerId())
                .targetType(RoleType.valueOf(request.ratingType()))
                .caseId(request.caseId())
                .ratingValue(request.ratingValue())
                .comment(request.comments())
                .givenBy(request.givenBy())
                .build();
    }

    public static RatingCreatedEvent toRatingCreatedEvent(Rating newRating) {
        return RatingCreatedEvent.builder()
                .ratingId(String.valueOf(newRating.getId()))
                .userId(String.valueOf(newRating.getRaterId()))
                .lawyerId(String.valueOf(newRating.getTargetId()))
                .targetType(String.valueOf(newRating.getTargetType()))
                .ratingValue(newRating.getRatingValue())
                .comment(newRating.getComment())
                .givenBy(newRating.getGivenBy())
                .createdAt(newRating.getCreatedAt())
                .build();
    }

    public static RatingResponse toRatingResponse(Rating newRating) {
        return RatingResponse.builder()
                .ratingId(String.valueOf(newRating.getId()))
                .userId(String.valueOf(newRating.getRaterId()))
                .lawyerId(String.valueOf(newRating.getTargetId()))
                .score(newRating.getRatingValue())
                .comment(newRating.getComment())
                .givenBy(newRating.getGivenBy())
                .build();
    }
}
