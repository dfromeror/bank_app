package com.bankapp.dao;

import com.bankapp.form.Contact;

import java.util.List;

public interface ContactDAO {

	public void addContact(Contact contact);
    public List<Contact> listContact();
    public void removeContact(Integer id);
}
