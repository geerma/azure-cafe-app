package com.cafe.server.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CafeUserRepository extends JpaRepository<CafeUser, Long> {

    @Query("SELECT u FROM CafeUser u WHERE u.username = ?1")
    Optional<CafeUser> findByUsername(String username);

}