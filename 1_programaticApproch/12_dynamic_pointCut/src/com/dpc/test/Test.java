package com.dpc.test;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

import com.dpc.aspect.LoggingAspect;
import com.dpc.beans.Calculator;
import com.dpc.pointcut.DynamicPointCut;


public class Test {

	public static void main(String[] args) {

		ProxyFactory pFactory = new ProxyFactory();
		pFactory.setTarget(new Calculator());
		pFactory.addAdvisor(new DefaultPointcutAdvisor(new DynamicPointCut(), new LoggingAspect()) );
//	pFactory.addAdvice(new LoggingAspect());
		
		Calculator proxy =(Calculator) pFactory.getProxy();
		int add = proxy.add(1, 5);
		System.out.println(add);
		
		int mul = proxy.mul(10, 20);
		System.out.println(mul);
	}

}
