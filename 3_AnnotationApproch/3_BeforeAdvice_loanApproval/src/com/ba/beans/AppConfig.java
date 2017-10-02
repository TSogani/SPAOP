package com.ba.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.ba.aspect.AuditAspect;

@ComponentScan(value={"com.ba.beans"})
@Configuration
public class AppConfig {
	@Bean(name="aspect")
	public Object log(){
		AuditAspect aspect = new  AuditAspect();
		return aspect;
	}
}
