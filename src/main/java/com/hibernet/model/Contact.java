package com.hibernet.model;

import java.util.Date;

import javax.validation.constraints.Size;



import lombok.Data;
@Data
public class Contact {

	 
	private int contactId;
	@Size(min=2, max=30)
	private String contactName;
	
	private String contactEmail;
	
	private Long contactNumber;
	private Date createdDate;
	private Date updateddate;
}
