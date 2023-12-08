package com.cbl.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cbl.app.models.Applicant;
import com.cbl.app.models.Bid;
import com.cbl.app.models.Property;
import com.cbl.app.models.User;
import com.cbl.app.repository.ApplicantRepository;
import com.cbl.app.repository.BidRepository;
import com.cbl.app.service.ApplicantService;
import com.cbl.app.service.PropertyService;

@Controller
@RequestMapping("/applicants")
public class ApplicantController {

	
	 @Autowired
	    private ApplicantService applicantService;
	 
	 @Autowired
	    private ApplicantRepository applicantRepository;

	 @Autowired
	 private PropertyService propertyService;

	 @GetMapping("/form")
	    public String showApplicantForm(Model model) {
		 List<Property> properties = propertyService.getAllProperties();
	     model.addAttribute("properties", properties);
	        model.addAttribute("applicant", new Applicant());
	        return "applicant-form";
	    }
	
	 @PostMapping("/add")
	    public String addApplicant(@ModelAttribute Applicant applicant) {
	        applicantService.saveApplicant(applicant);
	        return "redirect:/dashboard"; // Redirect to the dashboard after adding an applicant
	    }
	 
	 @GetMapping("/list")
	    public String getAllApplicants(Model model) {
	        List<Applicant> applicants = applicantRepository.findAll();
	        model.addAttribute("applicants", applicants);
	        return "applicantList";
	    }
}
