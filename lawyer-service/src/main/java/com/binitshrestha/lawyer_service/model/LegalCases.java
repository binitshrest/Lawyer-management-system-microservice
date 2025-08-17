package com.binitshrestha.lawyer_service.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_legal_cases")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LegalCases {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long user_id; // fk
    private Long lawyer_id; // fk
    @Enumerated(EnumType.STRING)
    private CaseStatus status;
    private String case_title;
    private String description;
    @CreationTimestamp
    private LocalDateTime created_at;
    @UpdateTimestamp
    private LocalDateTime closed_at;
}
