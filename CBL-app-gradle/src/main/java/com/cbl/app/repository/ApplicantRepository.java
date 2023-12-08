package com.cbl.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cbl.app.models.Applicant;

public interface ApplicantRepository extends JpaRepository<Applicant, Long> {
	List<Applicant> findByUserId(Long userId);
}
