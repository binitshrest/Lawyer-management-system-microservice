package com.binitshrestha.lawyer_service.service;

import com.binitshrestha.lawyer_service.dto.LawyerCreateRequest;
import com.binitshrestha.lawyer_service.dto.LawyerCreateResponse;
import com.binitshrestha.lawyer_service.dto.LawyerResponse;
import com.binitshrestha.lawyer_service.model.Lawyer;

import java.util.List;
import java.util.Optional;

public interface LawyerService {
    public LawyerCreateResponse createLawyer(LawyerCreateRequest request);

    List<LawyerResponse> getLawyers();

    List<LawyerResponse> searchBySpecialization(String specialization);
}
