package com.bankapp.form;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TRANSACTION")
public class Transaction {
	
	@Id
    @Column(name="ID")
    @GeneratedValue
    private Integer id;
	
	@Column(name="DATE_TIME")
    private Date dateTime;
	
	@Column(name="VALUE")
    private BigInteger value;
	
	@Column(name="TYPE")
    private String type;

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





