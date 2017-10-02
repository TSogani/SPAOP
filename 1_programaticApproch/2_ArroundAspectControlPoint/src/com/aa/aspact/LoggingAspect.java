package com.aa.aspact;

import java.lang.reflect.AccessibleObject;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LoggingAspect implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		String method = null;
		Object[] arguments = null;
		String methodReturnType = null;
		
		// getting the method name
		method = methodInvocation.getMethod().getName();
		
		// get the method arguments
		arguments = methodInvocation.getArguments();
		
		// get the return types
		methodReturnType = methodInvocation.getMethod().getReturnType()
				.getName();
		
		// target clss name where we apply aspect.
		Class target = methodInvocation.getMethod().getDeclaringClass();
		// System.out.println(":- "+target);

		// building key
		String key = getArgs(method, arguments);

		System.out.println("Entered into " + target + " " + methodReturnType
				+ " " + method + " " + key);

		// we can change attribute value before procedding the target class
		// method. mean 1st. control point

		// proceed called
		// 2ND Control point. we can proceed and throw the exception mean
		// terminate the execution.
		int proceed = (int) methodInvocation.proceed();
		
		System.out.println(proceed);
		System.out.println("Exit from" + this.getClass() + " " + methodReturnType
				+ " " + method + " " + key);
		// 3rd entry point we can modify the return value.
		return proceed + 15;
	}

	public String getArgs(String method, Object[] argument) {
		String key = "(";
		for (int i = 0; i < argument.length; i++) {
			if (i == 0) {
				key += argument[i];

			} else {
				key += "," + argument[i];
			}
		}
		key += ")";
		return key;
	}
}
