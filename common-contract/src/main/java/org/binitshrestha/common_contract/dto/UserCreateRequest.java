package org.binitshrestha.common_contract.dto;

import lombok.Builder;

@Builder
public record UserCreateRequest(
        String firstName,
        String lastName,
        String email,
        String password,
        RoleDto role) {
}
