package com.ba.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ba.beans.LoanApprover;
import com.ba.util.AuthManager;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/ba/common/applicationContext.xml");
		LoanApprover loanApprover = context.getBean("loanApprover",LoanApprover.class);
		AuthManager authManager  = context.getBean("authManager",AuthManager.class);
		authManager.login("john", "welcome");
		boolean loanApprover2 = loanApprover.loanApprover(9211);
		if (loanApprover2) {
			System.out.println("approve");	
		}
		authManager.logout();
		
	}
}
