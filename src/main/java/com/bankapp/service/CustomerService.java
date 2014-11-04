package com.bankapp.service;

import java.util.List;

import com.bankapp.form.Customer;

public interface CustomerService {	
	public void addCustomer(Customer customer);
	 public List<Customer> listCustomer();
	 public Customer getCustomer(Integer id);
	 public boolean removeCustomer(Integer id);
	public void updatePerson(Customer customer);
}


