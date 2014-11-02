package com.bankapp.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bankapp.form.Customer;
import com.bankapp.service.CustomerService;



@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping("/customer")
	public String listCustomers(Map<String, Object> map) {
		map.put("customer", new Customer());
		map.put("customerList", customerService.listCustomer());
		return "customer";
	}

	
	
	@RequestMapping(value="customer/{id}")
	public String getCustomer(@PathVariable("id")
	Integer customerId, Map<String, Object> map) {		
		map.put("customer", customerService.getCustomer(customerId));		
		return "customer";
	}


	@RequestMapping(value = "customer/add", method = RequestMethod.POST)
	public String addCustomer(@ModelAttribute("customer")
	Customer customer, BindingResult result) {	
		
		if(customer.getId()== null || customer.getId() == 0){
            //new person, add it
			customerService.addCustomer(customer);
        }else{
            //existing person, call update
            customerService.updatePerson(customer);
        }	
		return "redirect:/customer";
	}

	@RequestMapping(value="customer/delete/{id}")	
	public String deleteCustomer(@PathVariable("id")
	Integer customerId) {		
		System.out.println("Delete customer with ID: " + customerId);		
		customerService.removeCustomer(customerId);
		return "redirect:/customer";
	}
	
	@RequestMapping("/edit/{id}")
    public String editCustomer(@PathVariable("id") int id, Map<String, Object> map){		
	
		System.out.println("Edit customer with ID: " + id);	
		map.put("customer", this.customerService.getCustomer(id));
        System.out.println("Edit customer with ID: " + id + "Finish_1");	
        map.put("customerList", this.customerService.listCustomer());
        System.out.println("Edit customer with ID: " + id + "Finish_2");
       
        return "customer";
    }
	
}
    