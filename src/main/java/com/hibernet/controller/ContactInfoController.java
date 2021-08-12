package com.hibernet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hibernet.model.Contact;
import com.hibernet.service.ContactService;

@Controller
public class ContactInfoController {

	@Autowired
	private ContactService contactservice;
	
	@GetMapping(value= {"/","/addContact"})
	public String loadForm(Model model) {
		
		Contact c=new Contact();
		
		model.addAttribute("contact",c);
		
		return "contactInfo";
		}
	
	
	
	@PostMapping("/saveContact")
	public String handleSubmitBtn(@ModelAttribute("contact") Contact c,RedirectAttributes att) {
		System.err.println(c);
		
		
		boolean isSaved = contactservice.saveContact(c);
		
		
		 if (isSaved) {
		  
		  att.addAttribute("sucMsg","contact saved"); }else {
		  att.addAttribute("errMsg","Failed to save"); }
		 
		
		return "redirect:/contactCreation";
	}
	
	//@RequestMapping(value="/prgTest.html",method={RequestMethod.POST})
		@GetMapping(value= "/contactCreation")
		public String ContactCreation( Model model){
		    
			//Contact d=new Contact();
			
			model.addAttribute("contact",new Contact());
			
			return "contactInfo";
		}
	
	
	@GetMapping("/viewContacts")
	public String handleViewCContactsLink(Model model) {
		
		List<Contact> allContacts = contactservice.getAllContacts();
		model.addAttribute("contacts",allContacts);
		return "viewContacts";
	}
}
