package com.cbl.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cbl.app.models.Property;

public interface PropertyRepository extends JpaRepository<Property, Long>{
	List<Property> findByUserId(Long userId);
}
