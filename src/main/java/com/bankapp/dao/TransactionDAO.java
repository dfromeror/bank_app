package com.bankapp.dao;

import java.util.List;

import com.bankapp.form.Transaction;

public interface TransactionDAO {
	public void addContact(Transaction transaction);
    public List<Transaction> listContact();  
}



