package com.aston.search_entertainment.repository;

import com.aston.search_entertainment.domain.entity.ConfirmationToken;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken, Long> {
    Optional<ConfirmationToken> findByToken(String token);
}
