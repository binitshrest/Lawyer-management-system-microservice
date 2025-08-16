package org.binitshrestha.common_contract.dto;

import lombok.Builder;
import org.binitshrestha.common_contract.dto.RoleDto;


@Builder
public record UserResponseDto(
        Long id,
        String firstName,
        String lastName,
        String email,
        RoleDto role) {
}
