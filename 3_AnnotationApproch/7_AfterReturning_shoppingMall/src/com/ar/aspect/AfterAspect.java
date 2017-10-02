package com.ar.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.ar.beans.MememberShip;

@ComponentScan("com.ar.beans")
@Component
@Aspect
@EnableAspectJAutoProxy
@Order(1)
public class AfterAspect {

	@AfterReturning(value="execution(* com.ar.beans.*.*(..))",returning="ret")
	public void discount(JoinPoint jp, double ret) {
		Object[] args = null;
		MememberShip mememberShip = null;
		double amount = 0;
		amount = (double) ret;
		args = jp.getArgs();

		System.out.println("aspect Apply");
		
		mememberShip = (MememberShip) args[0];

		if (amount > 20000 && mememberShip.getType().equals("gold")) {
			System.out
					.println("congrtssss..! You are in 30% Discount zone,Lets shopping more");
		} else if (amount > 10000 && mememberShip.getType().equals("platinum")) {
			System.out
					.println("congo! Yor are in 10% dicount zone,Lets shopping more");
		} else {
			System.out.println("thanks for shopping");
		}

}

}
