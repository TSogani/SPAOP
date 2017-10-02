package com.dpc.aspect;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LoggingAspect implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {

		String methodName = methodInvocation.getMethod().getName();
		Object[] arguments = methodInvocation.getArguments();
		Class<?> returnType = methodInvocation.getMethod().getReturnType();

		String keyMaker = keyMaker(arguments);

		System.out.println("Enter into " + methodName + " " + returnType + " "
				+ keyMaker);

		Object proceed = methodInvocation.proceed();

		System.out.println("Exit from " + methodName);

		return proceed;
	}

	public String keyMaker(Object[] argument) {
		String key = "{";

		for (int i = 0; i < argument.length; i++) {
			if (i == 0) {
				key += argument[i] + "";
			} else {
				key += "," + argument[i];

			}
		}
		key += "}";
		return key;
	}

}
