package com.test;

import org.aspectj.ajdt.internal.compiler.ast.AddAtAspectJAnnotationsVisitor;
import org.springframework.aop.framework.ProxyFactory;

import com.beans.Calculator;
import com.beans.LoggingAspectArround;

public class TestLogging {
	public static void main(String[] args) {
		
		Calculator calculator = new Calculator();
		
		ProxyFactory pf = new ProxyFactory();
		pf.addAdvice(new LoggingAspectArround());
		pf.setTarget(calculator);
		
		Calculator cal =(Calculator) pf.getProxy();
		System.out.println(cal.getClass());
//		cal.add();
		System.out.println(cal.add(10, 20));
	}
}
