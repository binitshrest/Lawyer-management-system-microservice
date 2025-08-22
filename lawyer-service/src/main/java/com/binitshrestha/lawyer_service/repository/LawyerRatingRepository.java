package com.binitshrestha.lawyer_service.repository;

import com.binitshrestha.lawyer_service.model.LawyerRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LawyerRatingRepository extends JpaRepository<LawyerRating, Long> {

}
