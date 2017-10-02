package com.aa.aspact;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LoggingAspect implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {

		String name = methodInvocation.getMethod().getName();
		System.out.println(name);
		
		Object[] arguments = methodInvocation.getArguments();
		System.out.println(arguments.length);
		
		AccessibleObject staticPart = methodInvocation.getStaticPart();
		System.out.println(staticPart);
		
		Object this1 = methodInvocation.getThis();
		System.out.println(this1);
		Object proceed = methodInvocation.proceed();
		System.out.println(proceed);
		
		return proceed;
	}

}
