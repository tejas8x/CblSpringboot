package com.cbl.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cbl.app.models.Property;
import com.cbl.app.service.PropertyService;

@Controller
public class DashboardController {
	
	 @Autowired
	 private PropertyService propertyService;

	
	@GetMapping("/dashboard")
    public String showDashboard(Model model) {
		 List<Property> properties = propertyService.getAllProperties();
	     model.addAttribute("properties", properties);
          return "dashboard";
    }
	
	
}
