package org.binitshrestha.ratingservice.controller;

import lombok.RequiredArgsConstructor;
import org.binitshrestha.ratingservice.dto.RatingCreateRequest;
import org.binitshrestha.ratingservice.dto.RatingResponse;
import org.binitshrestha.ratingservice.service.RatingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ratings")
@RequiredArgsConstructor
public class RatingController {
    private final RatingService ratingService;

    @PostMapping
    public ResponseEntity<RatingResponse> createRating(@RequestBody RatingCreateRequest request) {
        RatingResponse rating = ratingService.createRating(request);
        return ResponseEntity.ok(rating);
    }
}
