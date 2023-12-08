package com.cbl.app.service;

import java.util.Optional;

import com.cbl.app.models.Partner;

public interface PartnerService {
	Partner save(Partner partner);
    Optional<Partner> findByUsername(String username);
}
