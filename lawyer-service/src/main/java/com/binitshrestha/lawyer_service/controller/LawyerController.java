package com.binitshrestha.lawyer_service.controller;

import com.binitshrestha.lawyer_service.dto.LawyerCreateRequest;
import com.binitshrestha.lawyer_service.dto.LawyerCreateResponse;
import com.binitshrestha.lawyer_service.dto.LawyerResponse;
import com.binitshrestha.lawyer_service.service.LawyerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<LawyerResponse>> getLawyers() {
        return ResponseEntity.ok(lawyerService.getLawyers());
    }

}
