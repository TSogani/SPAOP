package com.mb.aspect;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

import com.mb.util.AuthManager;

public class AuditAuthanticationAspect implements MethodBeforeAdvice{

	@Override
	public void before(Method method, Object[] arguments, Object target)
			throws Throwable {
		
		AuthManager am = AuthManager.getinstance();
		System.out.println("called : "+method.getName()+" by "+am.getLoggedUser());
		
	}

}
