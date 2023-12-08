package com.cbl.app.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbl.app.models.Applicant;
import com.cbl.app.repository.ApplicantRepository;
import com.cbl.app.service.ApplicantService;

@Service
public class ApplicantServiceImpl implements ApplicantService{

	@Autowired
	 private ApplicantRepository applicantRepository;

	@Override
	 public void saveApplicant(Applicant applicant) {
	     applicantRepository.save(applicant);
	 }

	@Override
	public List<Applicant> getAllApplicants() {
		
		return applicantRepository.findAll();
	}

	@Override
	public Applicant getApplicantById(Long id) {
		
		return applicantRepository.findById(id).orElse(null);
	}
	
	

}
