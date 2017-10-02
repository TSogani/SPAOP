package com.ba.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ba.aspect.AuditAspect;
import com.ba.beans.AppConfig;
import com.ba.beans.LoanApprovar;

public class Test {
	public static void main(String[] args) {

	//	ApplicationContext context = new ClassPathXmlApplicationContext("com/ba/common/applicationContext.xml");
		ApplicationContext context = new AnnotationConfigApplicationContext(AuditAspect.class);
		LoanApprovar bean = context.getBean("loanApprovar",LoanApprovar.class);
		boolean approve = bean.approve(9211);
		System.out.println(approve);
	}

}
