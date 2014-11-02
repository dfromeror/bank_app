package com.bankapp.service;

import java.util.List;

import com.bankapp.form.Transaction;

public interface TransactionService {
	public void addContact(Transaction transaction);
    public List<Transaction> listContact();  
}



