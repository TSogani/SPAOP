package com.aa.beans;

import org.springframework.stereotype.Component;

@Component("calculator")
public class Calculator {
	public  int add(int a, int b){
		
		return a+b;
	}
	public int mul(int a,int b){
		
		return a*b;
	}
}

