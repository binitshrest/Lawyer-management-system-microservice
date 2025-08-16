package org.binitshrestha.userservice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.binitshrestha.common_contract.dto.UserCreateRequest;
import org.binitshrestha.userservice.dto.request.UserUpdateRequest;
import org.binitshrestha.common_contract.dto.UserResponseDto;
import org.binitshrestha.userservice.mapper.UserMapper;
import org.binitshrestha.userservice.model.User;
import org.binitshrestha.userservice.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
@Slf4j
public class UserController {
    private final UserService userService;

    @GetMapping("/me")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<UserResponseDto> authenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();
        User user = userService.findByEmail(userEmail)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        UserResponseDto response = UserMapper.toResponse(user);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}") // api for user
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<UserResponseDto> updateUser(@PathVariable("id") Long id,
            @RequestBody UserUpdateRequest userRequest) {
        UserResponseDto response = userService.updateUser(id, userRequest);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{id}") // api for admin
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/create") // api for admin
    UserResponseDto createUser(@RequestBody UserCreateRequest request) {
        return userService.createUserForLawyer(request);
    }

    @GetMapping("/{email}")
    boolean getUserByEmail(@PathVariable("email") String email) {
        Optional<User> user = userService.findByEmail(email);
        return user.isPresent();
    }

}
