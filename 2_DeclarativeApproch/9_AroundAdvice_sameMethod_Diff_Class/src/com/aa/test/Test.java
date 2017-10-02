package com.aa.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aa.beans.Calculator;
import com.aa.beans.ScientificCalculator;

public class Test {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/aa/common/applicationContext.xml");

		Calculator calculator = context.getBean("calculator", Calculator.class);
		ScientificCalculator scientificCalculator = context.getBean("scientificCalculator", ScientificCalculator.class);
		int add = calculator.add(10, 20);
		System.out.println(add);

		int add2 = scientificCalculator.add(10, 20);
		System.out.println(add2);
	}

}
