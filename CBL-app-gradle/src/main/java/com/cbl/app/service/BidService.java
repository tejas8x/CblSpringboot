package com.cbl.app.service;

import java.util.List;

import com.cbl.app.models.Bid;

public interface BidService {
	void saveBid(Bid bid);
	 public List<Bid> getBidsByPropertyName(String propertyName);
}
