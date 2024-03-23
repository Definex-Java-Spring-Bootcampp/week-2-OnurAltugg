package com.patika.kredinbizdeservice.service;

import java.util.List;

import com.patika.kredinbizdeservice.model.Bank;
import com.patika.kredinbizdeservice.model.CreditCard;

public interface IBankService {
	
	Bank saveBank(Bank bank);
	
	List<Bank> getAll();
	
	Bank getByName(String name);
	
	void delete(String name);

	List<CreditCard> getCreditCardsByName(String bankName);

}
