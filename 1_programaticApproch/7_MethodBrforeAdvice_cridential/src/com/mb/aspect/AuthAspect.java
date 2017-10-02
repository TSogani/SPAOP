package com.mb.aspect;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

import com.mb.util.AuthManager;
import com.mb.util.InvalidUserException;

public class AuthAspect implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] argument, Object target)
			throws Throwable {
		System.out.println("authantication aspect ");
		AuthManager manager = AuthManager.getinstance();
		if (manager.authantication() == false) {
			System.out.println("authantication denide");
			//throw new IllegalAccessException("invalid username Password");
			throw new  InvalidUserException("invalid username password");
		}

	}

}
