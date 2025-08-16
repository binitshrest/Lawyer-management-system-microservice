package com.binitshrestha.lawyer_service.controller;

import com.binitshrestha.lawyer_service.dto.LawyerCreateRequest;
import com.binitshrestha.lawyer_service.dto.LawyerCreateResponse;
import com.binitshrestha.lawyer_service.service.LawyerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/lawyers")
@RequiredArgsConstructor
public class LawyerController {

    private final LawyerService lawyerService;

    @PostMapping("/signup/lawyer")
    public ResponseEntity<LawyerCreateResponse> registerLawyer(@RequestBody LawyerCreateRequest lawyerCreateRequest) {
       LawyerCreateResponse registeredLawyer = lawyerService.createLawyer(lawyerCreateRequest);
       return ResponseEntity.ok(registeredLawyer);
    }


}
