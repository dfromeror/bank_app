package com.bankapp.service;

import java.util.List;

import com.bankapp.dao.BankAccountDAO;
import com.bankapp.dao.TransactionDAO;
import com.bankapp.form.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class TransactionServiceImpl implements TransactionService{
	
	@Autowired
	private TransactionDAO transactionDAO;	
	
	@Autowired
	private BankAccountDAO bankAccountDAO;	
	
	@Transactional
        public boolean addTransaction(Transaction transaction) {
                // TODO Auto-generated method stub
                if (transaction.getType().equals("CREDITO")) {
                        // A credit should increase the account balance
                        if (bankAccountDAO.deposit(transaction.getBankAcount().getId(), transaction.getValue())) {
                                transactionDAO.addTransaction(transaction);
                                return true;
                        } else {
                                return false;
                        }
                } else {
                        // A debit should decrease the account balance
                        if (bankAccountDAO.withdraw(transaction.getBankAcount().getId(), transaction.getValue())) {
                                transactionDAO.addTransaction(transaction);
                                return true;
                        } else {
                                return false;
                        }
                }
			
	}
	@Transactional
	public List<Transaction> listTransaction() {
		// TODO Auto-generated method stub
		return transactionDAO.listTransaction();
	}
	
	@Transactional
	public List<Transaction> listTransactionByAccount(Integer id) {
		// TODO Auto-generated method stub
		return transactionDAO.listTransactionByAccount(id);
		
	}
	
}





