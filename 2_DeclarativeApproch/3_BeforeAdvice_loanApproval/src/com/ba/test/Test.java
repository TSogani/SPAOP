package com.ba.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ba.beans.LoanApproval;

public class Test {
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("com/ba/common/applicationContext.xml");
		LoanApproval bean = context.getBean("loanApproval",LoanApproval.class);
		boolean approve = bean.approve(9211);
		System.out.println(approve);
	}

}
