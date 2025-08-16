package com.binitshrestha.lawyer_service.repository;

import com.binitshrestha.lawyer_service.model.Lawyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface LawyerRepository extends JpaRepository<Lawyer, Long> {
    List<Lawyer> findByUserIdIn(Collection<Long> userIds);
}
