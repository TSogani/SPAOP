package com.ba.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.ba.util.AuthManager;

@Component
@Aspect
@Order(1)
public class AuditAspect implements ApplicationContextAware {
	AuthManager authManager;

	@Override
	public void setApplicationContext(ApplicationContext context)
			throws BeansException {

		authManager = context.getBean("authManager", AuthManager.class);
	}

	@Before("execution(* com.ba.beans.*.*(..))")
	// here in auditAspect or SecurityAspect hace common pointcut so
	// duplicate code wrote in multiple class in future want to changes it
	// tipical job to chnges in every class so
	// we need to write commmon pointcut.
	// see in next project common point cut how to manage
	// by writing a one class and write one method and apply pointcut and
	// extends in which class where you want same pointcut
	public void doAudit(JoinPoint jp) {

		// authManager = new AuthManager(); // dont do in this way
		System.out.println("user name is : " + authManager.getLoggedUser());

	}
}
