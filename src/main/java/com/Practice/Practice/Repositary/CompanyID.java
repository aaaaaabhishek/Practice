package com.Practice.Practice.Repositary;

import com.Practice.Practice.Dto.CompanyDto;
import com.Practice.Practice.Entity.Company;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CompanyID  extends JpaRepository<Company, Id> {

    Optional<Company> findById(UUID id);

    Optional<Company> findbyCompanycode(String company_code);
}
