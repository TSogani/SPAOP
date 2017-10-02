package com.aa.aspect;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class CheckPerformanceAcpect implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		String methodName = null;
		Object[] arguments = null;
		Class target = null;
		Class returnType = null;
		
		methodName = methodInvocation.getMethod().getName();
		arguments = methodInvocation.getArguments();
		target = methodInvocation.getMethod().getDeclaringClass();
		
		returnType = methodInvocation.getMethod().getReturnType();
		
		// key of arguments
		String keyOfArguments = getKeyOfArguments(arguments);
		//System.out.println(keyOfArguments);
		System.out.println("Enter into "+target+" "+returnType+" "+methodName+" "+keyOfArguments);
	
		// geting the entery Time 
		long entryTime = System.currentTimeMillis();
	
		// proceed 
		Object proceed = methodInvocation.proceed();
		
		// getting the exit time
		long exitTime = System.currentTimeMillis();
		System.out.println("method executionTime : "+(exitTime-entryTime));
		System.out.println("Exit from" + this.getClass() + " " + returnType
				+ " " + methodName + " " + keyOfArguments);
	
		return proceed;
		
	}

	public String getKeyOfArguments(Object[] arg){
		
		String key = "(";
		for (int i = 0; i < arg.length; i++) {
			if(i == 0){
				key += arg[i]+",";
			}
			else{
				key += arg[i];
			}
		}
		key+=")";
		return key;
	}
}
