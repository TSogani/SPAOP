package com.at.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.at.beans.Thrower;

public class Test {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.at.aspect");
		Thrower thrower = context.getBean("thrower",Thrower.class);
		int willThrow = thrower.willThrow(2);
		System.out.println("flag is : "+willThrow);
	}
}
