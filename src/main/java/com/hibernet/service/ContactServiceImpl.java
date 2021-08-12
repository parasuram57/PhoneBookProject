package com.hibernet.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hibernet.entity.ContactEntity;
import com.hibernet.exception.PhonebookAppException;
import com.hibernet.model.Contact;
import com.hibernet.repo.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRep;
	
	@Override
	public boolean saveContact(Contact c) {
		
		boolean isSaved=false;
		
		try {
			int i=10/0;
		ContactEntity entity=new ContactEntity();
		
		BeanUtils.copyProperties(c, entity);
		System.err.println(entity);
		
		ContactEntity savedEntity = contactRep.save(entity);
		
		if(savedEntity.getContactId() != null) {
			isSaved=true;
		}
		}catch(Exception e){
			
			throw new PhonebookAppException("Saved Failed....!!");
		}
		
		return isSaved;
		//return true;
	}

	@Override
	public List<Contact> getAllContacts() {
		// TODO Auto-generated method stub
		
		List<ContactEntity> entities=contactRep.findAll();
		
		/* Legacy Approach
		 * List<Contact> contacts=new ArrayList<Contact>(); for(ContactEntity
		 * entity:entities) { Contact contact= new Contact();
		 * BeanUtils.copyProperties(entity,contact); contacts.add(contact); }
		 */
		
		//java 8 feature
		//List<Contact> Contacts=entities.stream().map(entity -> {
		return entities.stream().map(entity -> {
			Contact contact= new Contact(); 
			BeanUtils.copyProperties(entity,contact);
			return contact;
		}).collect(Collectors.toList());
		
		//return Contacts;
	}

	@Override
	public Contact getContactById(Integer cid) {
		// TODO Auto-generated method stub
		Optional<ContactEntity> findById = contactRep.findById(cid);
		//optional ,when you search id if its not there it will null ,bcz optional
		
		if (findById.isPresent()) {
			
			ContactEntity contactEntity = findById.get();
			Contact c=new Contact();
			BeanUtils.copyProperties(contactEntity, c);
			
			return c;
		}
		
		return null;
	}

	@Override
	public boolean deleteContact(Integer cid) {
		// TODO Auto-generated method stub
		
		contactRep.deleteById(cid);
		
		return true;
	}

}
