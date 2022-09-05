package com.aston.search_entertainment.repository;

import com.aston.search_entertainment.domain.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    Company findCompanyById(Long id);
}
