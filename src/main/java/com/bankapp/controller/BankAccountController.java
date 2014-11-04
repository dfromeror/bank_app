package com.bankapp.controller;

import java.math.BigInteger;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bankapp.form.BankAccount;
import com.bankapp.form.Customer;
import com.bankapp.service.BankAccountService;
import com.bankapp.service.CustomerService;

@Controller
public class BankAccountController {
	
	@Autowired
	private BankAccountService bankAccountService;
	@Autowired
	private CustomerService customerService;
	//private Customer customerParent;
	
	@RequestMapping("/bankaccount")
	public String listBankAccounts(Map<String, Object> map) {
		map.put("bankAccount", new BankAccount());
		map.put("bankAccountList", bankAccountService.listBankAccount());
		return "bankaccount";
	}
	
	@RequestMapping("customer/{id_customer}/bankaccount")
	public String listBankAccounts(Map<String, Object> map, @PathVariable("id_customer")
	Integer id,  HttpSession httpSession) {	
		
		Customer customer= customerService.getCustomer(id);
		httpSession.setAttribute("id_customer", id);		
		//customerParent=customer;
		map.put("bankAccount", new BankAccount());	
		map.put("customer",customer);	
		map.put("bankAccountList", bankAccountService.listBankAccountByCustomer(customer));
		return "bankaccount";
	}	
	
	
	@RequestMapping(value="bankaccount/{id}")
	public String getBankAccount(@PathVariable("id")
	Integer Id, Map<String, Object> map) {		
		map.put("bankAccount", bankAccountService.getBankAccount(Id));		
		return "bankaccount";
	}


	@RequestMapping(value = "bankaccount/add", method = RequestMethod.POST)
	public String addBankAccount(@ModelAttribute("bankAccount")
	BankAccount bankAccount, BindingResult result, HttpSession httpSession) {
		
		if(bankAccount.getNumber().length()==0){
			httpSession.setAttribute("msgError", "Debe Ingresar su el número de la cuenta");
		}		
		else{
			httpSession.setAttribute("msgError", "");
			Integer idCliente=(Integer) httpSession.getAttribute("id_customer");
			System.out.println("Edit ID_customer with ID_customer: " + idCliente);
			bankAccount.setCustomer(customerService.getCustomer(idCliente));	
			System.out.println("Edit ID_customer with ID_customer: " + bankAccount);
			if(bankAccount.getId()== null || bankAccount.getId() == 0){
	            //new person, add it
				bankAccount.setBalance(BigInteger.ZERO);
				bankAccountService.addBankAccount(bankAccount);
	        }else{
	            //existing person, call update
	        	bankAccountService.updateBankAccount(bankAccount);
	        }	
			return "redirect:/bankaccount";
		}
		
		if(bankAccount.getId()== null || bankAccount.getId() == 0){
			return "redirect:/bankaccount";
		}
		else{
			return "redirect:/bankaccount/edit/"+bankAccount.getId();
		}
		
		
	}

	@RequestMapping(value="bankaccount/delete/{id}")	
	public String deleteBankAccount(@PathVariable("id")
	Integer id,  HttpSession httpSession) {		
		System.out.println("Delete customer with ID: " + id);			
		if(bankAccountService.removeBankAccount(id)){
			httpSession.setAttribute("msgError", "");			
		}
		else{
			httpSession.setAttribute("msgError", "la Cuenta no se pudo eliminar porque no exite o porque tiene asociadas una o más transacciones");
		}
		return "redirect:/bankaccount";
	}
	
	@RequestMapping("bankaccount/edit/{id}")
    public String editBankAccount(@PathVariable("id") int id, Map<String, Object> map){		
	
		System.out.println("Edit bankAccount with ID: " + id);	
		map.put("bankAccount", this.bankAccountService.getBankAccount(id));
        System.out.println("Edit bankAccount with ID: " + id + "Finish_1");	
        map.put("bankAccountList", this.bankAccountService.listBankAccount());
        System.out.println("Edit bankAccount with ID: " + id + "Finish_2");
       
        return "bankaccount";
    }

}
