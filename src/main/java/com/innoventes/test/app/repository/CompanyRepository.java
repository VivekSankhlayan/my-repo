package com.innoventes.test.app.repository;

import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.SelectBeforeUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.innoventes.test.app.entity.Company;


public interface CompanyRepository extends JpaRepository<Company, Long> {
	
	 @Query(value = "SELECT * FROM COMPANY ", nativeQuery = true)
		public Company getCompanyByCode(String companyCode);
}