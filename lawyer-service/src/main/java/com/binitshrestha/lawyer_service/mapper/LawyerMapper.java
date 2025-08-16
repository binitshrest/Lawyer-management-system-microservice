package com.binitshrestha.lawyer_service.mapper;

import com.binitshrestha.lawyer_service.dto.LawyerCreateRequest;
import com.binitshrestha.lawyer_service.dto.LawyerCreateResponse;
import com.binitshrestha.lawyer_service.model.Lawyer;
import org.binitshrestha.common_contract.dto.UserResponseDto;
import org.binitshrestha.common_contract.enums.UserStatus;

public class LawyerMapper {
    private LawyerMapper() {
    }

    public static Lawyer toModel(LawyerCreateRequest request, UserResponseDto user) {
        return Lawyer.builder()
                .userId(user.id())
                .licenceNumber(request.licenceNumber())
                .specialization(request.specialization())
                .yearsOfExperience(Integer.parseInt(request.yearsOfExperience()))
                .availabilityStatus(UserStatus.valueOf(request.availabilityStatus()))
                .hourlyRate(Double.valueOf(request.hourlyRate()))
                .isVerified(Boolean.valueOf(request.isVerified()))
                .build();
    }

    public static LawyerCreateResponse toResponse(Lawyer newLawyer, UserResponseDto user) {
        return LawyerCreateResponse.builder()
//                .id(newLawyer.getId())
//                .userId(newLawyer.getUserId())
                .user(user)
                .licenceNumber(newLawyer.getLicenceNumber())
                .specialization(newLawyer.getSpecialization())
                .yearsOfExperience(String.valueOf(newLawyer.getYearsOfExperience()))
                .availabilityStatus(newLawyer.getAvailabilityStatus().name())
                .hourlyRate(String.valueOf(newLawyer.getHourlyRate()))
                .isVerified(String.valueOf(newLawyer.getIsVerified()))
                .build();
    }
}
