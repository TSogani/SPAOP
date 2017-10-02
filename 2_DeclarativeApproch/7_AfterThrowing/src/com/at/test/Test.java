package com.at.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.at.beans.Thrower;

public class Test {
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("com/at/common/applicationContext.xml");
		Thrower th = context.getBean("thrower",Thrower.class);
		int returnVal = th.willThrow(25);
		if (returnVal == 1) {
			System.out.println("valid Entry , enjoy. ");
		}
		
	}

}
