package com.binitshrestha.lawyer_service.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.binitshrestha.common_contract.enums.UserStatus;

@Entity
@Table(name = "tbl_lawyer")
@Getter @Setter
public class Lawyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String licenceNumber;
    private String specialization;
    private int yearsOfExperience;
    @Enumerated(EnumType.STRING)
    private UserStatus availabilityStatus;
    private Double hourlyRate;
    private Boolean isVerified;
}
