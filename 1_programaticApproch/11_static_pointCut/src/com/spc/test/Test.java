package com.spc.test;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

import com.spc.aspect.LoggingAspect;
import com.spc.beans.Calculator;
import com.spc.pointcut.StaticPointCut;


public class Test {

	public static void main(String[] args) {

		ProxyFactory pFactory = new ProxyFactory();
		pFactory.setTarget(new Calculator());
		pFactory.addAdvisor(new DefaultPointcutAdvisor(new StaticPointCut(), new LoggingAspect()) );
//	pFactory.addAdvice(new LoggingAspect());
		
		Calculator proxy =(Calculator) pFactory.getProxy();
		int add = proxy.add(10, 20);
		System.out.println(add);
		
		int mul = proxy.mul(10, 20);
		System.out.println(mul);
	}

}
