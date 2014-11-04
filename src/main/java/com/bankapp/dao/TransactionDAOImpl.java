package com.bankapp.dao;

import java.util.List;

import com.bankapp.form.Transaction;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TransactionDAOImpl implements TransactionDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	public void addTransaction(Transaction transaction) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(transaction);		
	}

	public List<Transaction> listTransaction() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Transaction")
				.list();
	}

	public List<Transaction> listTransactionByAccount(Integer id) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Transaction where bankAcount.id="+id)
				.list();
	}
	
}





