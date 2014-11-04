package com.bankapp.dao;

import java.math.BigInteger;
import java.sql.SQLException;
import java.util.List;

import com.bankapp.form.BankAccount;
import com.bankapp.form.Customer;

public interface BankAccountDAO {
	public void addBankAccount(BankAccount bankAccount);
    public List<BankAccount> listBankAccount();
    public boolean removeBankAccount(Integer id);
	public BankAccount getBankAccount(Integer id);
	public void updateBankAccount(BankAccount bankAccount);
	public List<BankAccount> listBankAccountByCustomer(Customer customer);
	public Boolean withdraw(Integer idAccount, BigInteger value);
	public Boolean deposit(Integer idAccount, BigInteger value);
}



