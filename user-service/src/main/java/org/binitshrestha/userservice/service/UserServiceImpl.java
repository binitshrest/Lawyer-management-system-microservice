package org.binitshrestha.userservice.service;

import lombok.RequiredArgsConstructor;
import org.binitshrestha.common_contract.dto.UserCreateRequest;
import org.binitshrestha.userservice.dto.CreateAdminRequestDto;
import org.binitshrestha.userservice.dto.CreateAdminResponseDto;
import org.binitshrestha.userservice.dto.request.UserUpdateRequest;
import org.binitshrestha.userservice.dto.response.UserResponse;
import org.binitshrestha.common_contract.dto.UserResponseDto;
import org.binitshrestha.common_contract.exception.EmailAlreadyExistsException;
import org.binitshrestha.userservice.exception.UserNotFoundException;
import org.binitshrestha.userservice.mapper.UserMapper;
import org.binitshrestha.userservice.model.Role;
import org.binitshrestha.userservice.model.RoleType;
import org.binitshrestha.userservice.model.User;
import org.binitshrestha.userservice.repository.RoleRepository;
import org.binitshrestha.userservice.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(UserMapper::mapToUserResponse)
                .toList();
    }

    @Override
    public UserResponseDto updateUser(Long id, UserUpdateRequest userUpdateRequest) {
        User updateUser = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User Id not found," + id));

        if (userRepository.existsByEmailAndIdNot(updateUser.getEmail(), id)) {
            throw new EmailAlreadyExistsException(
                    "A user with given email already exists" + userUpdateRequest.email());
        }

        updateUser.setFirstName(userUpdateRequest.firstName());
        updateUser.setLastName(userUpdateRequest.lastName());
        updateUser.setEmail(userUpdateRequest.email());

        userRepository.save(updateUser);
        return UserMapper.toResponse(updateUser);
    }

    @Override
    public Optional<User> findByEmail(String userEmail) {
        return userRepository.findByEmail(userEmail);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public CreateAdminResponseDto createAdministrator(CreateAdminRequestDto userDto) {
        Optional<Role> optionalRole = roleRepository.findByName(RoleType.ADMIN);
        if (optionalRole.isEmpty()) {
            return null;
        }
        User mapped = UserMapper.toModel(userDto);
        User newAdminUser = userRepository.save(
                mapped.toBuilder()
                        .password(passwordEncoder.encode(userDto.password()))
                        .role(optionalRole.get())
                        .build());
        return UserMapper.toAdminResponseDto(newAdminUser);
    }

    @Override
    public UserResponseDto createUserForLawyer(UserCreateRequest request) {
        Optional<Role> optionalRole = roleRepository.findByName(RoleType.LAWYER);

        if (optionalRole.isEmpty()) {
            return null;
        }

        User user = UserMapper.signUpToModel(request, optionalRole, passwordEncoder);

        User newAuthUser = userRepository.save(user);
        return UserMapper.toUserResponse(newAuthUser);
    }

    @Override
    public UserResponseDto getUserById(Long id) {
        return userRepository.findById(id).map(UserMapper::toUserResponse)
                .orElseThrow(() -> new UserNotFoundException("User Id not found," + id));
    }

    @Override
    public List<UserResponseDto> getUsersByRole(Long id) {
        return userRepository.findByRole(id).stream().map(UserMapper::toUserResponse).toList();
    }

}
