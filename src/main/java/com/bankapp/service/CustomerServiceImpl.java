package com.bankapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.dao.CustomerDAO;
import com.bankapp.form.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
    private CustomerDAO customerDAO;
	
	@Transactional
	public void addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerDAO.addCustomer(customer);
		
	}
	
	@Transactional
	public List<Customer> listCustomer() {
		// TODO Auto-generated method stub
		return customerDAO.listCustomer();
	}
	
	@Transactional
	public boolean removeCustomer(Integer id) {
		// TODO Auto-generated method stub
		return customerDAO.removeCustomer(id);
	}
	
	@Transactional
	public Customer getCustomer(Integer id) {
		// TODO Auto-generated method stub
		return customerDAO.getCustomer(id);
	}
	
	@Transactional
	public void updatePerson(Customer customer) {
		// TODO Auto-generated method stub
		customerDAO.updateCustomer(customer);
	}
	
}


