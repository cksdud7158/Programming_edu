package com.exception;

public class NotEnoughMoneyException extends Exception{

	public NotEnoughMoneyException() {
		this("농장의 돈이 충분하지 않습니다.");
	}
	
	public NotEnoughMoneyException(String msg) {
		super(msg);
	}
}

