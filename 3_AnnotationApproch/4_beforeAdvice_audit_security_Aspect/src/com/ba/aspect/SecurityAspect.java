package com.ba.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.annotation.Order;

import com.ba.util.AuthManager;

@ComponentScan(value={"com.ba.aspect","com.ba.beans","com.ba.util"})

@Configuration
@Aspect
@EnableAspectJAutoProxy
@Order(2)
public class SecurityAspect  implements ApplicationContextAware{
	AuthManager authManager ;
	

	
	@Override
	public void setApplicationContext(ApplicationContext context)
			throws BeansException {

		authManager = context.getBean("authManager",AuthManager.class);
	}



	@Before("execution(* com.ba.beans.*.*(..))")
	// here in auditAspect or SecurityAspect hace common pointcut so
	// duplicate code wrote in multiple class in future want to changes it tipical job to chnges in every class so 
	// we need to write commmon pointcut. 
	
	// see in next project common point cut how to manage 
	// by writing a one class and write one method and apply pointcut and extends in which class where you want same pointcut
	
	
	public void doAuthanticate(JoinPoint jp) throws IllegalAccessException{
		
	//	authManager = new AuthManager(); // dont do in this way 
		if(authManager.authantication() == false){
			throw new IllegalAccessException("Enter valid username / password");
		}
	}
}
