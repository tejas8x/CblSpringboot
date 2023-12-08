package com.cbl.app.service;

import java.util.List;

import com.cbl.app.models.Applicant;

public interface ApplicantService {
	void saveApplicant(Applicant applicant);
    
    List<Applicant> getAllApplicants();
	Applicant getApplicantById(Long id);
}
