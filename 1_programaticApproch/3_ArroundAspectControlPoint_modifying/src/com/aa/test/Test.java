package com.aa.test;

import java.util.Calendar;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aa.aspact.LoggingAspect;
import com.aa.beans.Calculator;

public class Test {
	public static void main(String[] args) {

		
		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setTarget(new Calculator());
		proxyFactory.addAdvice(new LoggingAspect());
		Calculator proxy =(Calculator) proxyFactory.getProxy();
		
		int add = proxy.add(10, 20);
		System.out.println(add);
		
	}

}
