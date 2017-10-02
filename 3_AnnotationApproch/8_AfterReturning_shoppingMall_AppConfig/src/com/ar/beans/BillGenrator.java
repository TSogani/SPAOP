package com.ar.beans;

import java.util.List;

import org.springframework.stereotype.Component;

public class BillGenrator {
	public BillGenrator() {
		// TODO Auto-generated constructor stub
	System.out.println("bille genrator "+Thread.currentThread());
	}
	public double genrate(MememberShip mememberShip,List<String> productCode){
	
		return 3400;
		
	}
}
