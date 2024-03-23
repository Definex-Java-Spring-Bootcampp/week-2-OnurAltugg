package com.patika.kredinbizdeservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patika.kredinbizdeservice.model.Bank;
import com.patika.kredinbizdeservice.model.CreditCard;
import com.patika.kredinbizdeservice.service.IBankService;

@RestController
@RequestMapping("/api/banks")
public class BankController {
	
	@Autowired
	private IBankService bankService;
	
	@Autowired
	public BankController(IBankService bankService) {
		this.bankService = bankService;
	}
	
	@GetMapping
	public List<Bank> getAll(){
		return bankService.getAll();
	}
	
	@PostMapping
	public Bank create(@RequestBody Bank bank) {
		return bankService.saveBank(bank);
	}
	
	@DeleteMapping("/{bankName}")
	public void delete(@PathVariable String bankName) {
		bankService.delete(bankName);
	}
	
	@GetMapping("/{bankName}")
	public Bank getBankByName(String bankName) {
		return bankService.getByName(bankName);
	}
	
	@GetMapping("/{bankName}/credit-cards")
	public List<CreditCard> getBankCreditCards(@PathVariable String bankName) {
        return bankService.getCreditCardsByName(bankName);
    }

}
