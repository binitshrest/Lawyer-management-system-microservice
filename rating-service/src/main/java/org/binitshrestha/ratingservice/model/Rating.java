package org.binitshrestha.ratingservice.model;

import jakarta.persistence.*;
import lombok.*;
import org.binitshrestha.common_contract.enums.RoleType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_rating")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long raterId;
    private Long targetId;
    private RoleType targetType;
    private Long caseId;
    private double ratingValue;
    private String comment;
    @CreationTimestamp
    private Instant createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
