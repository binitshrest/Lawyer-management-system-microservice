package org.binitshrestha.ratingservice.mapper;

import org.binitshrestha.common_contract.enums.RoleType;
import org.binitshrestha.ratingservice.dto.RatingCreateRequest;
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
                .build();
    }
}
