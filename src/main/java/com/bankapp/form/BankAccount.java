package com.bankapp.form;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="BANK_ACCOUNT")
public class BankAccount {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="bank_account_id_seq")
	@SequenceGenerator(name="bank_account_id_seq", sequenceName="bank_account_id_seq", allocationSize=1)
	@Column(name="ID")
	private Integer id;
	
	@Column(name="NUMBER")
    private String number;
	
	@Column(name="BALANCE")
    private BigInteger balance;
	
	
	@ManyToOne(fetch=FetchType.EAGER) 
	@JoinColumn(name="customer_fk_id")
	private Customer customer;
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public BigInteger getBalance() {
		return balance;
	}

	public void setBalance(BigInteger balance) {
		this.balance = balance;
	}
}







	
     
    


