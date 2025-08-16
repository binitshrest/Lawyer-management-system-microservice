package com.binitshrestha.lawyer_service.service;

import com.binitshrestha.lawyer_service.dto.LawyerCreateRequest;
import com.binitshrestha.lawyer_service.dto.LawyerCreateResponse;
import com.binitshrestha.lawyer_service.mapper.LawyerMapper;
import com.binitshrestha.lawyer_service.model.Lawyer;
import com.binitshrestha.lawyer_service.proxy.UserClient;
import com.binitshrestha.lawyer_service.repository.LawyerRepository;
import lombok.RequiredArgsConstructor;
import org.binitshrestha.common_contract.dto.RoleDto;
import org.binitshrestha.common_contract.dto.UserCreateRequest;
import org.binitshrestha.common_contract.dto.UserResponseDto;
import org.binitshrestha.common_contract.exception.EmailAlreadyExistsException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LawyerServiceImpl implements LawyerService {
    private final UserClient userClient;
    private final LawyerRepository lawyerRepository;

    @Transactional
    public LawyerCreateResponse createLawyer(LawyerCreateRequest request) {
        if (userClient.getUserByEmail(request.email())) {
            throw new EmailAlreadyExistsException("A Lawyer with given email already exists" + request.email());
        }

        UserCreateRequest userCreateRequest = UserCreateRequest.builder()
                .email(request.email())
                .password(request.password())
                .firstName(request.firstName())
                .lastName(request.lastName())
                .role(
                        RoleDto.builder()
                                .name("LAWYER")
                                .build())
                .build();

        UserResponseDto user = userClient.createUser(userCreateRequest);

        Lawyer newLawyer = LawyerMapper.toModel(request, user);
        lawyerRepository.save(newLawyer);
        return LawyerMapper.toResponse(newLawyer, user);
    }
}
