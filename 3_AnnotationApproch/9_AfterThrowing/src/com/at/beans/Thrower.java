package com.at.beans;

import org.springframework.stereotype.Component;

@Component
public class Thrower {
	public int willThrow(int flag){
		if(flag==0)
		{
			throw new  IllegalArgumentException("Invalid flag..!!");
		}
		return flag;
	}
}
