package com.bankapp.dao;

import java.util.List;

import com.bankapp.form.BankAccount;

public interface BankAccountDAO {
	public void addContact(BankAccount bankAccount);
    public List<BankAccount> listContact();
    public void removeContact(Integer id);
}



