package org.binitshrestha.userservice.dto.request;

import lombok.Builder;
import org.binitshrestha.common_contract.dto.RoleDto;

@Builder
public record UserUpdateRequest(String firstName, String lastName, String email, String password, RoleDto role) {
}