package com.bankapp.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




import com.bankapp.form.Customer;
import com.bankapp.service.BankAccountService;
import com.bankapp.service.CustomerService;



@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private BankAccountService bankAccountService;

	@RequestMapping("/customer")
	public String listCustomers(Map<String, Object> map, HttpSession httpSession) {
		map.put("customer", new Customer());
		map.put("customerList", customerService.listCustomer());
		httpSession.setAttribute("msgError", "");
		return "customer";
	}
	
	@RequestMapping("/")
	public String index(Map<String, Object> map, HttpSession httpSession) {
		map.put("customer", new Customer());
		map.put("customerList", customerService.listCustomer());
		httpSession.setAttribute("msgError", "");
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
	Customer customer, BindingResult result, HttpSession httpSession) {		
		
		if(customer.getName().length()==0){
			httpSession.setAttribute("msgError", "Debe Ingresar su nombre");
		}
		else if(customer.getAddress().length()==0){
			httpSession.setAttribute("msgError", "Debe ingresar su dirección");
		}
		else if(customer.getPhone().length()==0){
			httpSession.setAttribute("msgError", "Debe Ingresar su teléfono");
		}
		else{
			httpSession.setAttribute("msgError", "");
			if(customer.getId()== null || customer.getId() == 0){
	            //new person, add it
				customerService.addCustomer(customer);
	        }else{
	            //existing person, call update
	            customerService.updatePerson(customer);
	        }	
			return "redirect:/customer";
		}
		
		if(customer.getId()== null || customer.getId() == 0){
			return "redirect:/customer";
		}
		else{
			return "redirect:/customer/edit/"+customer.getId();
			
		}

	}

	@RequestMapping(value="customer/delete/{id}")	
	public String deleteCustomer(@PathVariable("id")
	Integer customerId, HttpSession httpSession) {		
		if(customerService.removeCustomer(customerId)){
			httpSession.setAttribute("msgError", "");			
		}
		else{
			httpSession.setAttribute("msgError", "El cliente no se pudo eliminar porque no exite o porque tiene asociadas una o más cuentas");
		}
		return "redirect:/customer";
		
	}
	
	@RequestMapping("customer/edit/{id}")
    public String editCustomer(@PathVariable("id") int id, Map<String, Object> map){		
	
		System.out.println("Edit customer with ID: " + id);	
		map.put("customer", this.customerService.getCustomer(id));
        System.out.println("Edit customer with ID: " + id + "Finish_1");	
        map.put("customerList", this.customerService.listCustomer());
        System.out.println("Edit customer with ID: " + id + "Finish_2");
       
        return "customer";
    }
	
}
    