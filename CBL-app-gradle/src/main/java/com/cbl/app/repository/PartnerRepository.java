package com.cbl.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cbl.app.models.Partner;

public interface PartnerRepository extends JpaRepository<Partner, Long> {
	 Optional<Partner> findByUsername(String username);
}
