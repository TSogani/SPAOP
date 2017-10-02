package com.ta.beans;

public class Thrower {
	public int willThrow(int flag){
		
		if (flag==1) {
			throw new IllegalArgumentException("flag invalid");
		}
	return flag	;
	}
}
