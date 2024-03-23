package com.patika.kredinbizdeservice.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import com.patika.kredinbizdeservice.model.Bank;
import com.patika.kredinbizdeservice.model.Campaign;
import com.patika.kredinbizdeservice.model.CreditCard;
import com.patika.kredinbizdeservice.repository.BankRepository;

public class BankService implements IBankService{
	
	private BankRepository bankRepository = new BankRepository();
	
	@Override
	public Bank saveBank(Bank bank) {
		bankRepository.save(bank);
		return bank;
	}

	@Override
	public List<Bank> getAll() {
		return bankRepository.getAll();
	}

	@Override
	public Bank getByName(String name) {
		Optional<Bank> optionalBank = bankRepository.findByName(name);
		Bank bank = null;
		if(optionalBank.isPresent()) {
			bank = optionalBank.get();
		}
		return bank;
	}

	@Override
	public void delete(String name) {
		Optional<Bank> optionalBank = bankRepository.findByName(name);
		Bank bank = null;
		if(optionalBank.isPresent()) {
			bank = optionalBank.get();
			bankRepository.delete(bank);
		}
		
	}

	@Override
	public List<CreditCard> getCreditCardsByName(String bankName) {
		Optional<Bank> optionalBank = bankRepository.findByName(bankName);
		Bank bank = null;
		if(optionalBank.isPresent()) {
			bank = optionalBank.get();
			return bank.getCreditCards();
		}
		else {
			return Collections.emptyList();
		}
	}

	@Override
	public List<Campaign> getAllCampaignsSortedByDateDescending() {
		List<Campaign> campaigns = new ArrayList<>();
	    List<Bank> banks = bankRepository.getAll();
	    
	    banks.forEach(bank -> bank.getCreditCards().forEach(creditCard -> campaigns.addAll(creditCard.getCampaignList())));
	    
	    campaigns.sort(Comparator.comparing(Campaign::getCreateDate).reversed());
	    
	    return campaigns;
	}

}
