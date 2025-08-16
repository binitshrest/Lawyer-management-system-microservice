package com.binitshrestha.lawyer_service.dto;

import lombok.Builder;
import org.binitshrestha.common_contract.dto.UserResponseDto;

@Builder
public record LawyerCreateResponse(
//        Long id,
//        Long userId,
        UserResponseDto user,
        String licenceNumber,
        String specialization,
        String yearsOfExperience,
        String availabilityStatus,
        String hourlyRate,
        String isVerified

) {
}
