package org.binitshrestha.userservice.repository;

import org.binitshrestha.userservice.model.UserRating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRatingRepository extends JpaRepository<UserRating, Long> {

}
