package com.hibernet.service;

import java.util.List;

import com.hibernet.model.Contact;

public interface ContactService {

	public boolean saveContact(Contact c);
	public List<Contact> getAllContacts();
	public Contact getContactById(Integer cid);
	public boolean deleteContact(Integer cid);
}
