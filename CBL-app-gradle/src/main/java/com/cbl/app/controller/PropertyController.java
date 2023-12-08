package com.cbl.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cbl.app.models.Property;
import com.cbl.app.service.PropertyService;

@Controller
public class PropertyController {

	@Autowired
    private PropertyService propertyService;
	
	@GetMapping("/addProperty")
    public String showAddPropertyForm(Model model) {
        model.addAttribute("property", new Property());
        List<Property> properties = propertyService.getAllProperties();
	     model.addAttribute("properties", properties);
        return "add-property-form"; 
    }
	
	@PostMapping("/addProperty")
    public String addProperty(@ModelAttribute Property property) {
        propertyService.saveProperty(property);
        return "redirect:/dashboard"; 
    }
}
