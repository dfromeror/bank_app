package com.bankapp.dao;

import java.math.BigInteger;

import java.util.List;

import com.bankapp.form.BankAccount;
import com.bankapp.form.Customer;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BankAccountDAOImpl implements BankAccountDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerDAOImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	private CustomerDAO customerDAO;
	
	@Autowired
	private TransactionDAO transactionDao;

	public void addBankAccount(BankAccount bankAccount) {
		// TODO Auto-generated method stub		
		sessionFactory.getCurrentSession().save(bankAccount);
	}

	public List<BankAccount> listBankAccount() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from BankAccount")
				.list();
	}

	public boolean removeBankAccount(Integer id) {		
		if(transactionDao.listTransactionByAccount(id).size()>0){
			return false;
		}
		else{
			BankAccount bankAccount=(BankAccount) sessionFactory.getCurrentSession().load(BankAccount.class, id);
			if(null != bankAccount){
				sessionFactory.getCurrentSession().delete(bankAccount);
				return true;
			}
			else{
				return false;
			}
		}	
		
	}

	public BankAccount getBankAccount(Integer id) {
		// TODO Auto-generated method stub
		BankAccount bankAccount=(BankAccount) sessionFactory.getCurrentSession().load(BankAccount.class,  new Integer(id));
		logger.info("BankAccount loaded successfully, BankAccount details="+bankAccount);
	    return bankAccount;
	}

	public void updateBankAccount(BankAccount bankAccount) {
		// TODO Auto-generated method stub
		 sessionFactory.getCurrentSession().update(bankAccount);
	     logger.info("BankAccount updated successfully, BankAccount Details="+bankAccount);
	}

	public List<BankAccount> listBankAccountByCustomer(Customer customer) {
		
		
		return sessionFactory.getCurrentSession().createQuery("from BankAccount where customer.id="+customer.getId())
				.list();		
	}

	public Boolean withdraw(Integer idAccount, BigInteger value) {
		BankAccount bankAccount=(BankAccount) sessionFactory.getCurrentSession().load(BankAccount.class, idAccount);
		BigInteger balance=bankAccount.getBalance();
		if( balance.compareTo(value)==-1){
			return false;
		}
		else{
			balance = balance.subtract(value);
			bankAccount.setBalance(balance);
			this.updateBankAccount(bankAccount);
			return true;
		}		
	}

	public Boolean deposit(Integer idAccount, BigInteger value) {
		BankAccount bankAccount=(BankAccount) sessionFactory.getCurrentSession().load(BankAccount.class, idAccount);
		BigInteger balance=bankAccount.getBalance();
		balance = balance.add(value);
		bankAccount.setBalance(balance);
		this.updateBankAccount(bankAccount);
		return true;
	}
	


}