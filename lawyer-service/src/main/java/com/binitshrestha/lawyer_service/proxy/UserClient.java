package com.binitshrestha.lawyer_service.proxy;

import org.binitshrestha.common_contract.dto.UserCreateRequest;
import org.binitshrestha.common_contract.dto.UserResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "user-service", url = "${feign-client.user.service.url}")
public interface UserClient {
    @PostMapping(name = "create-user-details", value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    UserResponseDto createUser(@RequestBody UserCreateRequest request);

    @GetMapping(name = "get-email-by-emailId", value = "/{email}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    boolean getUserByEmail(@PathVariable("email") String email);

    @GetMapping("/role/{role_id}")
    List<UserResponseDto> getUsersByRole(@PathVariable("role_id") Long id);

}
