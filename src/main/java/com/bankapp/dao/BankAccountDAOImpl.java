package com.bankapp.dao;

import java.util.List;

import com.bankapp.form.BankAccount;
import com.bankapp.form.Contact;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BankAccountDAOImpl implements BankAccountDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	public void addContact(BankAccount bankAccount) {
		// TODO Auto-generated method stub		
		sessionFactory.getCurrentSession().save(bankAccount);
	}

	public List<BankAccount> listContact() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from BankAccount")
				.list();
	}

	public void removeContact(Integer id) {
		// TODO Auto-generated method stub
		BankAccount bankAccount=(BankAccount) sessionFactory.getCurrentSession().load(BankAccount.class, id);
		
		if(null != bankAccount){
			sessionFactory.getCurrentSession().delete(bankAccount);
		}
		
	}

}