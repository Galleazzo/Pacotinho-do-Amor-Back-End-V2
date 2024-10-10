package com.br.project.v2.infrastructure.repositories;

import com.br.project.v2.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    UserDetails findByUsername(String username);

    boolean existsByUsername(String username);

    @Query(nativeQuery = true, value = "SELECT * FROM user WHERE id = :id")
    User findByIdUniq(Long id);
}
