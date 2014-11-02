package com.bankapp.service;

import java.util.List;

import com.bankapp.dao.BankAccountDAO;
import com.bankapp.form.BankAccount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BankAccountServiceImpl implements BankAccountService{
	
	@Autowired
	private BankAccountDAO bankAccountDAO;
	
	@Transactional
	public void addContact(BankAccount bankAccount) {
		// TODO Auto-generated method stub	
		bankAccountDAO.addContact(bankAccount);
		}
	
	@Transactional
	public List<BankAccount> listContact() {
		// TODO Auto-generated method stub
		return bankAccountDAO.listContact();
	}
	
	@Transactional
	public void removeContact(Integer id) {
		// TODO Auto-generated method stub
		bankAccountDAO.removeContact(id);
		
	}

}