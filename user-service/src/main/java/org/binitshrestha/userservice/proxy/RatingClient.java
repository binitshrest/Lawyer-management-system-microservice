package org.binitshrestha.userservice.proxy;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "rating-service", url="${rating.service.url}")
public class RatingClient {

//    @PostMapping("/rating")
//    public ResponseEntity<RatingResponse> createRating(@RequestBody RatingCreateRequest request)
}
