package com.ba.beans;

import org.springframework.stereotype.Component;

@Component
public class LoanAprover {
	public boolean approver(int loanID){
		if(loanID==9211){
			return true;
		}
		return false;
	}
}
