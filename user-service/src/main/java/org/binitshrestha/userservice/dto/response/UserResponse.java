package org.binitshrestha.userservice.dto.response;

import lombok.Builder;
import org.binitshrestha.common_contract.enums.RoleType;

@Builder
public record UserResponse(Long id, String firstName, String lastName, RoleType role) {
}
