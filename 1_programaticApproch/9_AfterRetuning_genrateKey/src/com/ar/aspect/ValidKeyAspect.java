package com.ar.aspect;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class ValidKeyAspect implements AfterReturningAdvice{

	@Override
	public void afterReturning(Object returnValue, Method methodName, Object[] argument,
			Object target) throws Throwable {

		if((boolean) returnValue){
			throw new IllegalAccessException("invalid key genrated");
		}
	}
	
	
}
