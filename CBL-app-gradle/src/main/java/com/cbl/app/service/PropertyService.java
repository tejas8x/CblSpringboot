package com.cbl.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cbl.app.models.Property;

@Service
public interface PropertyService {
    boolean existsById(Long id);
	 Property saveProperty(Property property);
	 List<Property> getAllProperties();
     Property getPropertyById(Long id);
}
