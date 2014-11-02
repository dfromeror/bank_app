package com.bankapp.form;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BANK_ACCOUNT")
public class BankAccount {
	@Id
    @Column(name="ID")
    @GeneratedValue
    private Integer id;
	
	@Column(name="NUMBER")
    private String number;
	
	@Column(name="BALANCE")
    private BigInteger balance;
	
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







	
     
    


