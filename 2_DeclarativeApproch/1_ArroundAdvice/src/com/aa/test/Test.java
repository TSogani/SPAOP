package com.aa.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aa.beans.Calculator;

public class Test {

	public static void main(String[] args) {

		ApplicationContext  context = new ClassPathXmlApplicationContext("com/aa/common/applicationContext.xml");
		
		Calculator calculator = context.getBean("calculator",Calculator.class);
		int add = calculator.add(10, 20);
		System.out.println(add);
		
		int mul = calculator.mul(10, 20);
		System.out.println(mul);          
	}
	

}
