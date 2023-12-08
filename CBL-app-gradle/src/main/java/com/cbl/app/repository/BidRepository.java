package com.cbl.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cbl.app.models.Bid;

public interface BidRepository extends JpaRepository<Bid, Long>{
	List<Bid> findByApplicantIdAndPropertyId(Long applicantId, Long propertyId);
    List<Bid> findByBidOnProperty(String bidOnProperty);

}
