package org.binitshrestha.userservice.repository;

import org.binitshrestha.common_contract.dto.UserResponseDto;
import org.binitshrestha.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAll();
    boolean existsByEmail(String email);

    boolean existsByEmailAndIdNot(String email, Long id);

    Optional<User> findByEmail(String email);
    @Query("SELECT u FROM User u JOIN FETCH u.role r WHERE r.id = :roleId")
    List<User> findByRole(@Param("roleId") Long roleId);
}
