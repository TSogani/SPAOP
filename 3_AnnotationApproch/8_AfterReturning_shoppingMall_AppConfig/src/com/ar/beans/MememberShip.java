package com.ar.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public class MememberShip {
	private String cardNumber;
	private String type;

	
	public String getCardNumber() {
		return cardNumber;
	}

	@Value("12345")
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getType() {
		return type;
	}

	@Value("gold")
	public void setType(String type) {
		this.type = type;
	}

}
