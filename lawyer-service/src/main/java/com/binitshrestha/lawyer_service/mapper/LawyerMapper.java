package com.binitshrestha.lawyer_service.mapper;

import com.binitshrestha.lawyer_service.dto.LawyerCreateRequest;
import com.binitshrestha.lawyer_service.dto.LawyerCreateResponse;
import com.binitshrestha.lawyer_service.dto.LawyerResponse;
import com.binitshrestha.lawyer_service.model.Lawyer;
import org.binitshrestha.common_contract.dto.RoleDto;
import org.binitshrestha.common_contract.dto.UserCreateRequest;
import org.binitshrestha.common_contract.dto.UserResponseDto;
import org.binitshrestha.common_contract.enums.UserStatus;

import java.util.ArrayList;
import java.util.List;

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
                // .id(newLawyer.getId())
                // .userId(newLawyer.getUserId())
                .user(user)
                .licenceNumber(newLawyer.getLicenceNumber())
                .specialization(newLawyer.getSpecialization())
                .yearsOfExperience(String.valueOf(newLawyer.getYearsOfExperience()))
                .availabilityStatus(newLawyer.getAvailabilityStatus().name())
                .hourlyRate(String.valueOf(newLawyer.getHourlyRate()))
                .isVerified(String.valueOf(newLawyer.getIsVerified()))
                .build();
    }

    public static UserCreateRequest toUserCreateRequest(LawyerCreateRequest request) {
        return UserCreateRequest.builder()
                .email(request.email())
                .password(request.password())
                .firstName(request.firstName())
                .lastName(request.lastName())
                .role(
                        RoleDto.builder()
                                .name("LAWYER")
                                .build())
                .build();
    }

    public static List<LawyerResponse> toLawyerResponse(List<UserResponseDto> users, List<Lawyer> lawyers) {
        List<LawyerResponse> lawyerList = new ArrayList<>();
        for (UserResponseDto user : users) {
            Lawyer lawyer = lawyers.stream()
                    .filter(l -> l.getUserId().equals(user.id()))
                    .findFirst()
                    .orElse(null);

            if (lawyer != null) {
                lawyerList.add(
                        LawyerResponse.builder()
                                .user(user)
                                .licenceNumber(lawyer.getLicenceNumber())
                                .specialization(lawyer.getSpecialization())
                                .yearsOfExperience(lawyer.getYearsOfExperience())
                                .availableStatus(lawyer.getAvailabilityStatus().name())
                                .hourlyRate(lawyer.getHourlyRate())
                                .isVerified(lawyer.getIsVerified())
                                .build());
            }
        }

        return lawyerList;
    }
}
