package com.patika.kredinbizdeservice.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.patika.kredinbizdeservice.model.Bank;

public class BankRepository {
	
	private List<Bank> bankList = new ArrayList<>();
	
	public void save(Bank bank) {
		bankList.add(bank);
	}
	
	public List<Bank> getAll(){
		return bankList;
	}
	
	public Optional<Bank> findByName(String bankName) {
        return bankList.stream()
                .filter(bank -> bank.getName().equals(bankName))
                .findFirst();
    }
	
	public void delete(Bank bank) {
		bankList.remove(bank);
	}

}
