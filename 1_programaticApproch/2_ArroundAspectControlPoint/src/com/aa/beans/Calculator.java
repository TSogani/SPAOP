package com.aa.beans;

public class Calculator {
	
	
	public Calculator() {
		System.out.println("from constructor od calculator"+Thread.currentThread()+" : "+this.getClass().getName());
	}
	
	public int add(int a,int b){

		return a+b;
	}
	public int sub(int a,int b){
		
		return a-b;
	}
	
}
