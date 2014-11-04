package com.bankapp.service;

import java.util.List;

import com.bankapp.form.Transaction;

public interface TransactionService {
	public boolean addTransaction(Transaction transaction);
    public List<Transaction> listTransaction();
	public List<Transaction>  listTransactionByAccount(Integer id);  
}



