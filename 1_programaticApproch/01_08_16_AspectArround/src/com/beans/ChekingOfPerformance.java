package com.beans;

import java.util.Calendar;

public class ChekingOfPerformance {
	
	public void m1(){
		System.out.println("my method m1 "+Calendar.HOUR +" : "+Calendar.MINUTE +" : "+Calendar.SECOND +" : "+Calendar.MILLISECOND);
	}
	
	public int calculate(int a,int b) throws InterruptedException{
			//	Thread.sleep(10000);
		System.out.println(" calculate method ");
		return a+b;
		
	}
}
