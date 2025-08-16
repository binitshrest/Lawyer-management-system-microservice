package com.binitshrestha.lawyer_service.repository;

import com.binitshrestha.lawyer_service.model.Lawyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LawyerRepository extends JpaRepository<Lawyer, Long> {
//    boolean existsByEmail(String email); // error here -> No property 'email' found for type 'Lawyer'
}
