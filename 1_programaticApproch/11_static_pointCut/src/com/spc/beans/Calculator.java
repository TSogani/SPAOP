package com.spc.beans;

public class Calculator {
	public int add(int a, int b){
		
		return a+b;
	}
	public int mul(int a,int b){
		System.out.println("from calculator class - mul");
		return a*b;
	}
}
