package org.binitshrestha.userservice.dto;

import lombok.Builder;
import org.binitshrestha.common_contract.dto.RoleDto;

@Builder
public record CreateAdminResponseDto(String firstName, String lastName, String email, RoleDto roleDto) {
}
