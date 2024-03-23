package com.patika.kredinbizdeservice.service;

import java.util.List;

import com.patika.kredinbizdeservice.model.Loan;

public interface ILoanService {
	
	 Loan save(Loan loan);

	 List<Loan> getAll();
}
