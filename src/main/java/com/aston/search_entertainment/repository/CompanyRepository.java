package com.aston.search_entertainment.repository;

import com.aston.search_entertainment.domain.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    Company getCompanyById (Long id);
    Company findCompanyById(Long id);

    @Modifying
    @Transactional
    @Query("update Company e set e.name = ?1,e.link = ?2,e.location = ?3,e.documents = ?4 where e.id = ?5")
    void setCompanyInfoById(String name, String link, String location, String documents, Long id);
}
