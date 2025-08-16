package com.binitshrestha.lawyer_service.dto;

import lombok.Builder;
import org.binitshrestha.common_contract.dto.RoleDto;

@Builder
public record LawyerCreateRequest(
        String firstName,
        String lastName,
        String email,
        String password,
        RoleDto role,
        String licenceNumber,
        String specialization,
        String yearsOfExperience,
        String availabilityStatus,
        String hourlyRate,
        String isVerified) {
}
