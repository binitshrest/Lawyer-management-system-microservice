package com.binitshrestha.lawyer_service.dto;

import lombok.Builder;
import org.binitshrestha.common_contract.dto.UserResponseDto;

@Builder
public record LawyerResponse(
        UserResponseDto user,
        String licenceNumber,
        String  specialization,
        int yearsOfExperience,
        String availableStatus,
        Double hourlyRate,
        Boolean isVerified
) {
}
