package com.cbl.app.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Bid {

	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
        private Long bidAmount;
	    private String bidOnProperty;
	    
	  
	    private Long applicantId;
	    private String bidApplicantName;
	    private Long propertyId;
	    private LocalDate date;
	    private String bidStatus;
}
