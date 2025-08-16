package com.binitshrestha.lawyer_service.service;

import com.binitshrestha.lawyer_service.dto.LawyerCreateRequest;
import com.binitshrestha.lawyer_service.dto.LawyerCreateResponse;

public interface LawyerService {
    public LawyerCreateResponse createLawyer(LawyerCreateRequest request);
}
