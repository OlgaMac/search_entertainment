package com.aston.search_entertainment.repository;

import com.aston.search_entertainment.domain.entity.Entertainment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntertainmentRepository extends JpaRepository<Entertainment, Long> {

    Entertainment findEntertainmentById(Long id);
}
