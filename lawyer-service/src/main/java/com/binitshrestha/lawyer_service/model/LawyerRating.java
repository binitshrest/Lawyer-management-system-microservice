package com.binitshrestha.lawyer_service.model;

import jakarta.persistence.*;
import lombok.*;
import org.binitshrestha.common_contract.enums.RoleType;

import java.time.Instant;

@Entity
@Table(name =  "tbl_lawyer_rating")
@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LawyerRating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long lawyerId;
    private Long userId;
    private RoleType targetType;
    private Double ratingValue;
    private String comment;
    private String givenBy;
    private Instant createdAt;
    private Instant updatedAt;
}
