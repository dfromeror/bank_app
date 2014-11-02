package com.bankapp.service;

import java.util.List;

import com.bankapp.form.Contact;

public interface ContactService {
	
	public void addContact(Contact contact);
    public List<Contact> listContact();
    public void removeContact(Integer id);

}
