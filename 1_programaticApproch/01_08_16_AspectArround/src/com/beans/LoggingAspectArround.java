package com.beans;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LoggingAspectArround implements MethodInterceptor{

	
	@Override
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {

		// in arround we have 3 control point. 
		
		String methods = methodInvocation.getMethod().getName(); 
	 	Object[] arguments = methodInvocation.getArguments();
	 	
	 	// control point
	 	// we can change or modigy argument value. 
	 	arguments[0] = (Integer)arguments[0] + 1;
	 	
	 	
		// entery msg
		this.getArgs(methods,arguments);
		
		//	System.out.println("enter into "+methods+"("+ arguments[0]  +","+arguments[1]+")");
		
		// control point
		// we can also modify output of target class method. 
		
		
		Object returnValueForTarget = methodInvocation.proceed();
		
		// modify output.
		returnValueForTarget = (Integer)returnValueForTarget+2;
		System.out.println("end of "+methods);
		return returnValueForTarget;
		
	}

	
	public void getArgs(String methodName,Object[] arguments){
		Object obj = null;
		System.out.print("entered into "+ methodName +"(");
		for(int i = 0 ;i<arguments.length;i++){
			if(i == 0){
				System.out.print(arguments[0]);
				continue;
			}
			System.out.print(","+arguments[i]);
		}
		System.out.println(")");
	}
}
