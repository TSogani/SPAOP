package com.beans;

import java.util.Calendar;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class CheckingPerformanceAspects implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		String methodName = methodInvocation.getMethod().getName();
		Object[] arguments = methodInvocation.getArguments();

		// System.out.println(millisecond);
		
		  long currentTimeMillis = System.currentTimeMillis();
		  System.out.println(currentTimeMillis); Object returnValue =
		  methodInvocation.proceed(); 
		  long currentTimeMillis2 =System.currentTimeMillis(); 
		  System.out.println(currentTimeMillis2);
		  
		  System.out.println(currentTimeMillis2-currentTimeMillis);
		 

		/*Calendar calendar = Calendar.getInstance();
		long timeInMillis = calendar.getTimeInMillis();
		System.out.println(timeInMillis);
		Object returnValue = methodInvocation.proceed();
		
		Calendar calendar1 = Calendar.getInstance();
		long timeInMillis2 = calendar1.getTimeInMillis();
		System.out.println(timeInMillis2);
		System.out.println(timeInMillis2 - timeInMillis);*/
		return returnValue;
	}
}
