package com.ba.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import com.ba.beans.LoanApprovar;

@ComponentScan(value={"com.ba.beans"})


@Configuration
//@Component
@Aspect
// jar problem add new jars 4.1
@EnableAspectJAutoProxy
public class AuditAspect {
	// any name but return type is void. 
	
	// carefully import correct package. 
	@Before("execution(* com.ba.beans.*.*(..))")
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