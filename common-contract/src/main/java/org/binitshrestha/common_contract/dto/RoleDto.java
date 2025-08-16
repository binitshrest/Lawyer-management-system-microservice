package org.binitshrestha.common_contract.dto;

import lombok.Builder;

@Builder
public record RoleDto(String name, String description) {
    public RoleDto(String name, String description) {
        this.name = name != null ? name.toUpperCase() : null;
        this.description = description;
    }
}
