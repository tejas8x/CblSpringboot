package com.cbl.app.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cbl.app.models.Applicant;
import com.cbl.app.models.Bid;
import com.cbl.app.models.Property;
import com.cbl.app.repository.BidRepository;
import com.cbl.app.service.ApplicantService;
import com.cbl.app.service.BidService;
import com.cbl.app.service.PropertyService;

@Controller
@RequestMapping("/bids")
public class BidController {
	
	@Autowired
	private PropertyService propertyService;
	
	@Autowired
    private BidRepository bidRepository;

	
	@Autowired
    private BidService bidService;
 
	@GetMapping("/add")
    public String showBidForm(Model model) {
        model.addAttribute("bid", new Bid());
        List<Property> properties = propertyService.getAllProperties();
	     model.addAttribute("properties", properties);
        return "bid-form";
    }
	
	@PostMapping("/add")
	public String addBid(@ModelAttribute Bid bid, RedirectAttributes redirectAttributes) {
        // Check if the property with the given ID exists
		bid.setDate(LocalDate.now());
        Long propertyId = bid.getPropertyId();
        boolean propertyExists = propertyService.existsById(propertyId);
        String propertyName = bid.getBidOnProperty();

        if (propertyExists) {
              
            List<Bid> existingBids = bidService.getBidsByPropertyName(propertyName);

            if (existingBids.isEmpty()) {
                // No existing bids, set bidStatus to 'Let'
                bid.setBidStatus("Let");
            } else {
                // Existing bids, set bidStatus to 'None'
                bid.setBidStatus("Lost");
            }
        	
            bidService.saveBid(bid);
            return "redirect:/bids/bids"; // Redirect to the dashboard after adding a bid
        } else {
            // Property does not exist, show a popup message
            redirectAttributes.addFlashAttribute("propertyNotFound", true);
            return "redirect:/bids/add"; // Redirect back to the bid form
        }
    }
	
	@GetMapping("/bids")
    public String getAllBids(Model model) {
        List<Bid> bids = bidRepository.findAll();
        model.addAttribute("bids", bids);
        return "bidList";
    }
	
	@GetMapping("/propertyBidList")
    public String getPropertyBids(Model model) {
		return "property-bid-form";
       
    }
	
	 @GetMapping("/search")
	    public String searchBids(@RequestParam("propertyName") String propertyName, Model model) {
	        // Use BidService to get a list of bids by property name
	        List<Bid> matchingBids = bidService.getBidsByPropertyName(propertyName);

	        // Add the list to the model for Thymeleaf to use in the view
	        model.addAttribute("bids", matchingBids);

	        // Return the view name (property-bid-form.html)
	        return "property-bid-form";
	    }
}
