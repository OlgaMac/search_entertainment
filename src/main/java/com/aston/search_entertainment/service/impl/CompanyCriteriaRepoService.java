package com.aston.search_entertainment.service.impl;

import com.aston.search_entertainment.domain.entity.Company;
import com.aston.search_entertainment.domain.entity.CompanyPage;
import com.aston.search_entertainment.domain.entity.CompanySearchCriteria;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
@Repository
public class CompanyCriteriaRepoService {
    private final EntityManager entityManager;
    private final CriteriaBuilder criteriaBuilder;

    public CompanyCriteriaRepoService(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.criteriaBuilder = entityManager.getCriteriaBuilder();
    }

    public Page<Company> findAllWithFilters(CompanyPage companyPage,
                                            CompanySearchCriteria companySearchCriteria){
        CriteriaQuery<Company> criteriaQuery = criteriaBuilder.createQuery(Company.class);
        Root<Company> companyRoot = criteriaQuery.from(Company.class);
        Predicate predicate = getPredicate(companySearchCriteria, companyRoot);
        criteriaQuery.where(predicate);
        setOrder(companyPage, criteriaQuery, companyRoot);

        TypedQuery<Company> typedQuery = entityManager.createQuery(criteriaQuery);
        typedQuery.setFirstResult(companyPage.getPageNumber() * companyPage.getPageSize());
        typedQuery.setMaxResults(companyPage.getPageSize());

        Pageable pageable = getPageable(companyPage);

        long companyCount = getCompaniesCount(predicate);

        return new PageImpl<>(typedQuery.getResultList(), pageable, companyCount);
    }

    private Predicate getPredicate(CompanySearchCriteria companySearchCriteria,
                                   Root<Company> employeeRoot) {
        List<Predicate> predicates = new ArrayList<>();

        if(Objects.nonNull(companySearchCriteria.getName())){
            predicates.add(
                    criteriaBuilder.like(employeeRoot.get("name"),
                            "%" + companySearchCriteria.getName() + "%")
            );
        }
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }

    private void setOrder(CompanyPage companyPage,
                          CriteriaQuery<Company> criteriaQuery,
                          Root<Company> employeeRoot) {
        if(companyPage.getSortDirection().equals(Sort.Direction.ASC)){
            criteriaQuery.orderBy(criteriaBuilder.asc(employeeRoot.get(companyPage.getSortBy())));
        } else {
            criteriaQuery.orderBy(criteriaBuilder.desc(employeeRoot.get(companyPage.getSortBy())));
        }
    }

    private Pageable getPageable(CompanyPage companyPage) {
        Sort sort = Sort.by(companyPage.getSortDirection(), companyPage.getSortBy());
        return PageRequest.of(companyPage.getPageNumber(), companyPage.getPageSize(), sort);
    }

    private long getCompaniesCount(Predicate predicate) {
        CriteriaQuery<Long> countQuery = criteriaBuilder.createQuery(Long.class);
        Root<Company> countRoot = countQuery.from(Company.class);
        countQuery.select(criteriaBuilder.count(countRoot)).where(predicate);
        return entityManager.createQuery(countQuery).getSingleResult();
    }
}
