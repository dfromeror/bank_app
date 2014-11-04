package com.bankapp.dao;
import com.bankapp.form.Customer;

import java.util.List;

public interface CustomerDAO {
	 public void addCustomer(Customer customer);
	 public List<Customer> listCustomer();
	 public boolean removeCustomer(Integer id);
	public Customer getCustomer(Integer id);
	public void updateCustomer(Customer customer);
}





 

