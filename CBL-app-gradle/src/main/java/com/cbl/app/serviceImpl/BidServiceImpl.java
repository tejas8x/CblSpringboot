package com.cbl.app.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbl.app.models.Bid;
import com.cbl.app.repository.BidRepository;
import com.cbl.app.service.BidService;

@Service
public class BidServiceImpl implements BidService{

	@Autowired
    private BidRepository bidRepository;

	
	@Override
    public void saveBid(Bid bid) {
        bidRepository.save(bid);
    }
	
	  public List<Bid> getBidsByPropertyName(String propertyName) {
	        // Use the bidRepository to find bids by property name
	        return bidRepository.findByBidOnProperty(propertyName);
	    }
}
