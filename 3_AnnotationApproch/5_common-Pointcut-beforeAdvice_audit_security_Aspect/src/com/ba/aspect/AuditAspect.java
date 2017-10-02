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
public class AuditAspect extends AbstractCommonPointCut implements ApplicationContextAware {
	AuthManager authManager;

	@Override
	public void setApplicationContext(ApplicationContext context)
			throws BeansException {

		authManager = context.getBean("authManager", AuthManager.class);
	}

	//@Before("execution(* com.ba.beans.*.*(..))")
	
	@Before("commonPointCut()")
	public void doAudit(JoinPoint jp) {

		// authManager = new AuthManager(); // dont do in this way
		System.out.println("user name is : " + authManager.getLoggedUser());

	}
}
