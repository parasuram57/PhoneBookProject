package com.hibernet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hibernet.model.Contact;
import com.hibernet.service.ContactService;

@Controller
public class ViewContactsController {

	@Autowired
	private ContactService contactServ;
	
	@GetMapping("/editContact")
	public String editContact(@RequestParam("cid") Integer contactid,Model model) {
		
		Contact c = contactServ.getContactById(contactid);
		
		model.addAttribute("contact",c);
		
		return "contactInfo";
	}

	/*
	 * public String updateContact(Contact c,Model model) {
	 * 
	 * return ""; }
	 */
	
	@GetMapping("/deleteContact")
	public String deleteContact(@RequestParam("cid") Integer contactId) {
		
		boolean isDelete = contactServ.deleteContact(contactId);
		
		if(isDelete) {
			
			return "redirect:/viewContacts";
		}
		
		return "";
	}
	
}
