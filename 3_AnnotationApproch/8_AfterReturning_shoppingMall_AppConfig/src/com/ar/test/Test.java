package com.ar.test;

import java.nio.channels.MembershipKey;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ar.appconfig.AppConfig;
import com.ar.beans.BillGenrator;
import com.ar.beans.MememberShip;

public class Test {

	public static void main(String[] args) {

		//ApplicationContext context = new ClassPathXmlApplicationContext("com/ar/common/applicationContext.xml");
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		MememberShip mememberShip = context.getBean("mememberShip",
				MememberShip.class);
		
		
		List<String> productList = new ArrayList<String>();
		productList.add("132");

		BillGenrator billGenrator = context.getBean("billGenrator",
				BillGenrator.class);
		
		double genrate = billGenrator.genrate(mememberShip, productList);
		System.out.println(genrate);

	}

}
