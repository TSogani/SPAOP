package com.ar.appconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import com.ar.aspect.AfterReturningAspect;
import com.ar.beans.BillGenrator;
import com.ar.beans.MememberShip;

@ComponentScan(value={"com.ar.beans,com.ar.aspect"})

@Component

@EnableAspectJAutoProxy(proxyTargetClass=true)
public class AppConfig {
	
	@Bean(name={"billGenrator","billGenrator1"})
	public BillGenrator newBillGenrator(){
		return new BillGenrator();
	}
	
	@Bean(name="mememberShip")
	public MememberShip newMememberShip(){
		return new MememberShip();
	}
	
	//@Bean(name="afterReturningAspect")
	public AfterReturningAspect newAfterReturningAspect(){
		return new AfterReturningAspect();
	}
}
