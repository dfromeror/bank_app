package com.bankapp.service;

import java.util.List;

import com.bankapp.form.BankAccount;
import com.bankapp.form.Customer;

public interface BankAccountService {
	public void addBankAccount(BankAccount bankAccount);
    public List<BankAccount> listBankAccount();
    public boolean removeBankAccount(Integer id);
	public BankAccount getBankAccount(Integer id);
	public void updateBankAccount(BankAccount bankAccount);
	public List<BankAccount> listBankAccountByCustomer(Customer customer);	
}



