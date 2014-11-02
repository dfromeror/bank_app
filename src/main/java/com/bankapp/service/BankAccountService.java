package com.bankapp.service;

import java.util.List;

import com.bankapp.form.BankAccount;

public interface BankAccountService {
	public void addContact(BankAccount bankAccount);
    public List<BankAccount> listContact();
    public void removeContact(Integer id);
}



