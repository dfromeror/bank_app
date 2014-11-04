package com.bankapp.form;
import java.math.BigInteger;
import java.util.Date;

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
@Table(name="TRANSACTION")
public class Transaction {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="transaction_id_seq")
	@SequenceGenerator(name="transaction_id_seq", sequenceName="transaction_id_seq", allocationSize=1)
	@Column(name="ID")
    private Integer id;
	
	@Column(name="DATE_TIME")
    private Date dateTime;
	
	@Column(name="VALUE")
    private BigInteger value;
	
	@Column(name="TYPE")
    private String type;
	
	@ManyToOne(fetch=FetchType.EAGER) 
	@JoinColumn(name="bank_accountr_fk_id")
	private BankAccount bankAcount;
	

	public BankAccount getBankAcount() {
		return bankAcount;
	}

	public void setBankAcount(BankAccount bankAcount) {
		this.bankAcount = bankAcount;
	}

	public Integer getId() {
		return id;
	}
 
	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public BigInteger getValue() {
		return value;
	}

	public void setValue(BigInteger value) {
		this.value = value;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	

}





