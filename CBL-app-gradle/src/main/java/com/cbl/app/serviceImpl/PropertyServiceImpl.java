package com.cbl.app.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbl.app.models.Applicant;
import com.cbl.app.models.Property;
import com.cbl.app.repository.PropertyRepository;
import com.cbl.app.service.PropertyService;

@Service
public class PropertyServiceImpl implements PropertyService {

	@Autowired
	 private PropertyRepository propertyRepository;
	
	@Override
    public Property saveProperty(Property property) {
        return propertyRepository.save(property);
    }
	
	@Override
    public boolean existsById(Long id) {
        return propertyRepository.existsById(id);
    }

	@Override
	public List<Property> getAllProperties() {
		
		return propertyRepository.findAll();
	}

	@Override
	public Property getPropertyById(Long id) {
		
		return propertyRepository.findById(id).orElse(null);
	}
	
	




	

}
