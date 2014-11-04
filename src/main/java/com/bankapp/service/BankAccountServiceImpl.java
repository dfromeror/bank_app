package com.bankapp.service;

import java.sql.SQLException;
import java.util.List;

import com.bankapp.dao.BankAccountDAO;
import com.bankapp.dao.CustomerDAO;
import com.bankapp.form.BankAccount;
import com.bankapp.form.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BankAccountServiceImpl implements BankAccountService{
	
	@Autowired
	private BankAccountDAO bankAccountDAO;
	
	
	@Transactional
	public void addBankAccount(BankAccount bankAccount) {
		// TODO Auto-generated method stub	
		bankAccountDAO.addBankAccount(bankAccount);
		}
	
	@Transactional
	public List<BankAccount> listBankAccount() {
		// TODO Auto-generated method stub
		return bankAccountDAO.listBankAccount();
	}
	
	@Transactional
	public boolean removeBankAccount(Integer id) {
		// TODO Auto-generated method stub		
			return bankAccountDAO.removeBankAccount(id);		
					
	}	
	
	@Transactional
	public BankAccount getBankAccount(Integer id) {
		// TODO Auto-generated method stub
		return bankAccountDAO.getBankAccount(id);
	}
	
	@Transactional
	public void updateBankAccount(BankAccount bankAccount) {
		// TODO Auto-generated method stub
		bankAccountDAO.updateBankAccount(bankAccount);
	}
	
	@Transactional
	public List<BankAccount> listBankAccountByCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return bankAccountDAO.listBankAccountByCustomer(customer);
	}

	

}