package com.patika.kredinbizdeservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patika.kredinbizdeservice.model.Loan;
import com.patika.kredinbizdeservice.service.ILoanService;

@RestController
@RequestMapping("api/loans")
public class LoanController {
	
	@Autowired
    private ILoanService loanService;

    @Autowired
    public LoanController(ILoanService loanService) {
        this.loanService = loanService;
    }
    
    @GetMapping()
    public List<Loan> getAll(){
    	return loanService.getAll();
    }
    
    @PostMapping()
    public Loan create(@RequestBody Loan loan) {
    	return loanService.save(loan);
    }

}
