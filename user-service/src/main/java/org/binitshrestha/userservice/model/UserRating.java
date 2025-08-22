package org.binitshrestha.userservice.model;


import jakarta.persistence.*;
import lombok.*;
import org.binitshrestha.common_contract.enums.RoleType;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_user_rating")
@Getter
@Setter
@Builder
@AllArgsConstructor @NoArgsConstructor
public class UserRating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Long lawyerId;
    private RoleType targetType;
    private double ratingValue;
    private int ratingCount;
    private String comment;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
