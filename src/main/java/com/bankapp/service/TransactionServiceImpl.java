package com.bankapp.service;

import java.util.List;

import com.bankapp.dao.TransactionDAO;
import com.bankapp.form.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class TransactionServiceImpl implements TransactionService{
	
	@Autowired
	private TransactionDAO transactionDAO;
	
	@Transactional
	public void addContact(Transaction transaction) {
		// TODO Auto-generated method stub
		transactionDAO.addContact(transaction);
		
	}
	
	@Transactional
	public List<Transaction> listContact() {
		// TODO Auto-generated method stub
		return transactionDAO.listContact();
	}
	
}





