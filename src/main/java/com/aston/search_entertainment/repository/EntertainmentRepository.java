package com.aston.search_entertainment.repository;

import com.aston.search_entertainment.domain.entity.Entertainment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


public interface EntertainmentRepository extends JpaRepository<Entertainment, Long> {
    @Modifying
    @Transactional
    @Query("update Entertainment e set e.location = ?1,e.documents = ?2,e.url = ?3 where e.id = ?4")
    void setEntertainmentInfoById(String location, String documents,String url, Long id);

    Entertainment findEntertainmentById(Long id);
}
