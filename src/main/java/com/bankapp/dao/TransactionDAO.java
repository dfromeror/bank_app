package com.bankapp.dao;

import java.util.List;

import com.bankapp.form.Transaction;

public interface TransactionDAO {
	public void addTransaction(Transaction transaction);
    public List<Transaction> listTransaction();
	public List<Transaction>  listTransactionByAccount(Integer id);  
}



