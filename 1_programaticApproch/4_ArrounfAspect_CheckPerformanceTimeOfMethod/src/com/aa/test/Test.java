package com.aa.test;

import org.springframework.aop.framework.ProxyFactory;

import com.aa.aspect.CheckPerformanceAcpect;
import com.aa.beans.Calculator;

public class Test {
	public static void main(String[] args) {

		ProxyFactory factory = new ProxyFactory();
		factory.setTarget(new Calculator());
		factory.addAdvice(new CheckPerformanceAcpect());
		
		Calculator proxyCal = (Calculator)factory.getProxy();
		
		proxyCal.add(10, 20);
	}

}
