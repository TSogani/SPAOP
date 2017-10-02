package com.ba.beans;

import org.springframework.stereotype.Component;

@Component("loanApprovar")
public class LoanApprovar {
	public boolean approve(int loanId){
		if(loanId == 9211){
			return true;
		}
		return false;
	}
}
