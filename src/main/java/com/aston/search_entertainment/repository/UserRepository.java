package com.aston.search_entertainment.repository;

import com.aston.search_entertainment.domain.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
    List<UserEntity> findAll();

    @Override
    Optional<UserEntity> findById(Long aLong);

    @Override
    void deleteById(Long aLong);

    Optional<UserEntity> findByEmail(String email);




}
