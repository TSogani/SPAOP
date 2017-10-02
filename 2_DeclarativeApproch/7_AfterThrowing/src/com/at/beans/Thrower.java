package com.at.beans;

public class Thrower {
	public int willThrow(int age){
		if(age>=18){
			return 1;
		}
		else{
			throw new IllegalArgumentException("age above 18, are allowed");
		}
	}
}
