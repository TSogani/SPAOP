package com.aa.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingAspect {
	public Object log(ProceedingJoinPoint pjp,int x,int y) throws Throwable{
		String methodName = null;
		Object []args = null;
		String methodArgs = null;
		
		methodName = pjp.getSignature().getName();
		args = pjp.getArgs();
		
		methodArgs = makeArgsAsString(args);
		
		//Enterting into target class log message
		System.out.println("Entering into "+methodName+methodArgs);
		
		//proceeding control into target class
		Object ret = pjp.proceed();
		
		//Exiting from target class log message
		System.out.println("Exiting from "+methodName+" with return value "+ret);
		
		return ret;
	}
	
		private String makeArgsAsString(Object []args){
			String methodArgs = null;
			
			methodArgs = "(";
			for(int i = 0;i<args.length;i++){
				if(i==0){
					methodArgs += args[i];
				}else{
					methodArgs += ","+args[i];
				}	
			}
			methodArgs += ")";
			
			return methodArgs;
		}
}
