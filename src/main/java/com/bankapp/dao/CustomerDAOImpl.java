package com.bankapp.dao;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bankapp.form.Customer;

@Repository
public class CustomerDAOImpl implements  CustomerDAO {
	 
	private static final Logger logger = LoggerFactory.getLogger(CustomerDAOImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	public void addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(customer);
		
	}

	public List<Customer> listCustomer() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Customer")
				.list();		
	}

	public void removeCustomer(Integer id) {
		// TODO Auto-generated method stub
		Customer customer=(Customer) sessionFactory.getCurrentSession().load(Customer.class, id);
		if (null != customer) {
			sessionFactory.getCurrentSession().delete(customer);
		}
		
	}

	public Customer getCustomer(Integer id) {
		// TODO Auto-generated method stub		
		Customer customer=(Customer) sessionFactory.getCurrentSession().load(Customer.class,  new Integer(id));
		logger.info("Customer loaded successfully, customer details="+customer);
	    return customer;		
	}

	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub		
		  sessionFactory.getCurrentSession().update(customer);
	      logger.info("Customer updated successfully, Customer Details="+customer);
	}
	

	
	
}



