package com.at.aspect;

import org.aspectj.lang.JoinPoint;

public class AfterThrowingAdvice {
	
	public void afterThrowing(JoinPoint jp, IllegalArgumentException iae){
		
		String methoName = jp.getSignature().getName();
		System.out.println("Exception in  "+ methoName+" : " +iae.getMessage());
	}
}
