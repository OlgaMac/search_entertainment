package com.aston.search_entertainment.repository;

import com.aston.search_entertainment.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserById(Long id);
}
