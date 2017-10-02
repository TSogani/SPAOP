package com.ar.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.aop.framework.ProxyFactory;

import com.ar.aspect.AfterAspect;
import com.ar.beans.BillGenrator;
import com.ar.beans.MememberShip;

public class Test {

	public static void main(String[] args) {

		ProxyFactory factory = new ProxyFactory();
		factory.setTarget(new BillGenrator());
		factory.addAdvice(new AfterAspect());
		
		BillGenrator proxy = (BillGenrator)factory.getProxy();
		
		MememberShip mememberShip = new MememberShip();
		mememberShip.setCardNumber("13456");
		mememberShip.setType("gold");
		
		List<String> productList = new ArrayList<String>();
		productList.add("132");
		double bill = proxy.genrate(mememberShip,productList );
		System.out.println(bill);
		
	}

}
