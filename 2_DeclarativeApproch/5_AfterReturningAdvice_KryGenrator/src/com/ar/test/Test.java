package com.ar.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ar.beans.KeyGenrator;

public class Test {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("com/ar/common/applicationContext.xml");
		KeyGenrator keyGenrator = context.getBean("keyGenrator",KeyGenrator.class);
		boolean key = keyGenrator.genrateKey(9);
		if (key) {
			System.out.println("valid key");
		}else{
			System.out.println("invalid Key");
		}
		
	}

}
