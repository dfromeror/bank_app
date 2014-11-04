package com.bankapp.form;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CUSTOMER")
public class Customer {


	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="cliente_id_seq")
	@SequenceGenerator(name="cliente_id_seq", sequenceName="cliente_id_seq", allocationSize=1)
	@Column(name="ID")
    private Integer id;
     
    @Column(name="NAME")    
    private String name;
 
    @Column(name="ADDRESS")
    private String address;
 
    @Column(name="PHONE")
    private String phone;   
  
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}


