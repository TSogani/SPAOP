package com.ar.aspect;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

import com.ar.beans.MememberShip;

public class AfterAspect implements AfterReturningAdvice{

	@Override
	public void afterReturning(Object ret, Method method, Object[] argument,
			Object target) throws Throwable {
		double amount= 0;
		MememberShip mememberShip=null;
		amount = (double)ret;
		mememberShip = (MememberShip)argument[0];
		
		
		if(amount>20000 && mememberShip.getType().equals("gold")){
			System.out.println("congrtssss..! You are in 30% Discount zone,Lets shopping more");
		}
		else if(amount>10000 && mememberShip.getType().equals("platinum")){
			System.out.println("congo! Yor are in 10% dicount zone,Lets shopping more");
		}else{
			System.out.println("thanks for shopping");
		}
	}

}
