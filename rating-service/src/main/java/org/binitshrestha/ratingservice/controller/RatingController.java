package org.binitshrestha.ratingservice.controller;

import lombok.RequiredArgsConstructor;
import org.binitshrestha.ratingservice.dto.RatingCreateRequest;
import org.binitshrestha.ratingservice.service.RatingService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ratings")
@RequiredArgsConstructor
public class RatingController {
    private final RatingService ratingService;

    public void createRating(@RequestBody RatingCreateRequest request){

        ratingService.createRating(request);
    }


}
