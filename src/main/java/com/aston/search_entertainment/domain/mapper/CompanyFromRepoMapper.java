package com.aston.search_entertainment.domain.mapper;

import com.aston.search_entertainment.domain.entity.Company;
import com.aston.search_entertainment.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class CompanyFromRepoMapper {

    private final CompanyRepository companyRepository;

    @Named("getCompanyFromRepo")
    public Company getCompanyFromRepo(Long id) {
        return companyRepository.findCompanyById(id);
    }

}