package com.bankapp.controller;

import java.math.BigInteger;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bankapp.form.BankAccount;
import com.bankapp.form.Transaction;
import com.bankapp.service.BankAccountService;
import com.bankapp.service.TransactionService;

@Controller
public class TransactionController {
	@Autowired
	private BankAccountService bankAccountService;
	@Autowired
	private TransactionService transactionService;
	//private Customer customerParent;
	
	
	@RequestMapping("bankaccount/{id_account}/transaction")
	public String listBankAccounts(Map<String, Object> map, @PathVariable("id_account")
	Integer id,  HttpSession httpSession) {			
		BankAccount bankAccount= bankAccountService.getBankAccount(id);
		httpSession.setAttribute("id_transaction", id);		
		//customerParent=customer;
		map.put("transaction", new Transaction());	
		map.put("bankAccount",bankAccount);	
		map.put("transactionList", transactionService.listTransactionByAccount(id));
		return "transactions";
	}	
	
	
	@RequestMapping("bankaccount/transaction/credit/")
    public String registerCreditTransaction( Map<String, Object> map){			
		Transaction transaction=  new Transaction();		
		transaction.setType("CREDITO");		
		map.put("transaction", transaction);	       
        return "transaction";
    }
	
	@RequestMapping("bankaccount/transaction/debit/")
    public String registerDebitTransaction( Map<String, Object> map){			
		Transaction transaction=  new Transaction();
		transaction.setType("DEBITO");			
		map.put("transaction", transaction);	       
        return "transaction";
    }
	


	@RequestMapping(value = "bankaccount/transaction/add", method = RequestMethod.POST)
	public String addBankAccount(@ModelAttribute("transaction")
	Transaction transaction, BindingResult result, HttpSession httpSession) {	
		
		try{
			if( transaction.getValue().compareTo(BigInteger.ZERO)>0){
				
			}			
		}
		catch(NullPointerException e){
			transaction.setValue(BigInteger.ZERO);
		}
		
		if( transaction.getValue().compareTo(BigInteger.ZERO)<=0){
			httpSession.setAttribute("msgError", "Debe Ingresar un valor mayor a cero");
		}		
		else{
			httpSession.setAttribute("msgError", "");
			Integer idTransaction=(Integer) httpSession.getAttribute("id_transaction");
			transaction.setBankAcount(bankAccountService.getBankAccount(idTransaction));
			Date date = new Date();
			transaction.setDateTime(date);
			if(transactionService.addTransaction(transaction)){
				httpSession.setAttribute("msgError", "");
				return "redirect:/bankaccount";
			}
			else{
				httpSession.setAttribute("msgError", "El valor a retirar es mayor que el saldo");
				return "transaction";
			}
			
		}	
		
		return "transaction";
		
		
	}



}
