package com.aa.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aa.beans.Calculator;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/aa/common/application-context.xml");
		Calculator proxy = context.getBean("calculator", Calculator.class);
		int sum = proxy.add(100, 200);
		System.out.println("Sum : "+sum);
		
		int sum1 = proxy.add(100, 200);
		System.out.println("Sum : "+sum1);
		
	}
}
