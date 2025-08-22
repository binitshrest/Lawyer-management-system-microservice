package org.binitshrestha.userservice.mapper;

import org.binitshrestha.common_contract.dto.RoleDto;
import org.binitshrestha.common_contract.dto.UserCreateRequest;
import org.binitshrestha.common_contract.dto.event.RatingCreatedEvent;
import org.binitshrestha.common_contract.enums.RoleType;
import org.binitshrestha.userservice.dto.CreateAdminRequestDto;
import org.binitshrestha.userservice.dto.CreateAdminResponseDto;
import org.binitshrestha.userservice.dto.request.RegisterUserReqDto;
import org.binitshrestha.userservice.dto.response.RegisterUserResDto;
import org.binitshrestha.userservice.dto.response.UserResponse;
import org.binitshrestha.common_contract.dto.UserResponseDto;
import org.binitshrestha.userservice.model.Role;
import org.binitshrestha.userservice.model.User;
import org.binitshrestha.userservice.model.UserRating;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

public class UserMapper {
    private UserMapper() {
    }

    public static UserResponse mapToUserResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .role(user.getRole().getName())
                .build();
    }

    public static User toModel(CreateAdminRequestDto adminRequestDto) {
        return User.builder()
                .firstName(adminRequestDto.firstName())
                .lastName(adminRequestDto.lastName())
                .email(adminRequestDto.email())
                .build();
    }
    public static User signUpToModel(RegisterUserReqDto registerUserDto, Optional<Role> role, PasswordEncoder passwordEncoder){
        return  User.builder()
                .firstName(registerUserDto.firstName())
                .lastName(registerUserDto.lastName())
                .email(registerUserDto.email())
                .password(
                        passwordEncoder.encode(registerUserDto.password()))
                .role(role.orElse(null))
                .build();
    }
    public static User signUpToModel(UserCreateRequest request, Optional<Role> role, PasswordEncoder passwordEncoder){
        return  User.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .password(
                        passwordEncoder.encode(request.password()))
                .role(role.orElse(null))
                .build();
    }


    public static UserResponseDto toResponse(User newUser) {
        return UserResponseDto.builder()
                .id(newUser.getId())
                .firstName(newUser.getFirstName())
                .lastName(newUser.getLastName())
                .email(newUser.getEmail())
                .role(RoleDto.builder()
                        .name(newUser.getRole().getName().toString())
                        .description(newUser.getRole().getDescription())
                        .build())
                .build();
    }

    public static RegisterUserResDto toResponseDto(User newAuthUser) {
        return RegisterUserResDto.builder()
                .email(newAuthUser.getEmail())
                .firstName(newAuthUser.getFirstName())
                .lastName(newAuthUser.getLastName())
                .role(RoleDto.builder()
                        .name(newAuthUser.getRole().getName().toString())
                        .description(newAuthUser.getRole().getDescription())
                        .build())
                .build();
    }

    public static UserResponseDto toUserResponse(User newAuthUser) {
        return UserResponseDto.builder()
                .id(newAuthUser.getId())
                .email(newAuthUser.getEmail())
                .firstName(newAuthUser.getFirstName())
                .lastName(newAuthUser.getLastName())
                .role(RoleDto.builder()
                        .name(newAuthUser.getRole().getName().toString())
                        .description(newAuthUser.getRole().getDescription())
                        .build())
                .build();
    }


    public static CreateAdminResponseDto toAdminResponseDto(User newAdminUser) {
        return CreateAdminResponseDto.builder()
                .firstName(newAdminUser.getFirstName())
                .lastName(newAdminUser.getLastName())
                .email(newAdminUser.getEmail())
                .roleDto(RoleDto.builder()
                        .name(newAdminUser.getRole().getName().toString())
                        .description(newAdminUser.getRole().getDescription())
                        .build())
                .build();
    }

    public static UserRating toUserRatingModel(RatingCreatedEvent event) {
        return UserRating.builder()
                .userId(Long.valueOf(event.userId()))
                .lawyerId(Long.valueOf(event.lawyerId()))
                .targetType(RoleType.valueOf(event.targetType()))
                .ratingValue(event.ratingValue())
                .comment(event.comment()).build();
    }
}
