package com.patika.kredinbizdeservice.service;

import java.util.List;

import com.patika.kredinbizdeservice.model.Loan;
import com.patika.kredinbizdeservice.repository.LoanRepository;

public class LoanService implements ILoanService {
	
	private LoanRepository loanRepository = new LoanRepository();

	@Override
	public Loan save(Loan loan) {
		loanRepository.save(loan);
		return loan;
	}

	@Override
	public List<Loan> getAll() {
		return loanRepository.getAll();
	}

}
