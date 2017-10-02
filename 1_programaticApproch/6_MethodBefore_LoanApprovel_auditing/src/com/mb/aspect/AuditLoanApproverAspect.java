package com.mb.aspect;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class AuditLoanApproverAspect implements MethodBeforeAdvice{


	@Override
	public void before(Method method, Object[] argument, Object target)
			throws Throwable {

		System.out.println(method.getName() +"called by john");
		
	}

}
