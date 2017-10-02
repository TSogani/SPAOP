package com.ba.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ba.aspect.SecurityAspect;
import com.ba.beans.LoanAprover;
import com.ba.util.AuthManager;

public class Test {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SecurityAspect.class);
		
		LoanAprover proxy = context.getBean("loanAprover", LoanAprover.class);
		
		AuthManager authManager = context.getBean("authManager", AuthManager.class);
		
		authManager.login("john", "welcome");
		
		boolean approver = proxy.approver(9211);
		System.out.println(approver);
		
		context.close(); 
	}
}
