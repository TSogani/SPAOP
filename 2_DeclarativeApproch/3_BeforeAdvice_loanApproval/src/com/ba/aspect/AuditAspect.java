package com.ba.aspect;

import org.aspectj.lang.JoinPoint;


public class AuditAspect {
	// any name but return type is void. 
	
	// carefully import correct package. 
	
	public void doAudit(JoinPoint jp) throws Throwable{
		
		// two control point :- 
		// we control the argument 
		// we control the floe mean we stop the execution by throwing the exception 
		
		System.out.println("heare we are calling auditing logic. and write database logic. and sotre every entry in database. for audit we use different database : becausa audit data are huge, so if memory problem come then no impect our application. ");
		System.out.println("proceed : loan is approval");
		
		Object[] args = jp.getArgs();
		for (int i = 0; i < args.length; i++) {
			args[i]=(Integer)args[i]+2;
		}
		String methodName = jp.getSignature().getName();
		
		System.out.println("from AfterAspect "+methodName );
		
	}
}
