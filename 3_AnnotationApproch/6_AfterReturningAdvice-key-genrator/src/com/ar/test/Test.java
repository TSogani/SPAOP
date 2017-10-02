package com.ar.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ar.beans.KeyGenrator;

public class Test {

	
	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.ar.aspect");
		// class name also valid 
		// package name also valid
		KeyGenrator keyGenrator = context.getBean("keyGenrator",KeyGenrator.class);
		keyGenrator.genratorKey(8);
	}

}
