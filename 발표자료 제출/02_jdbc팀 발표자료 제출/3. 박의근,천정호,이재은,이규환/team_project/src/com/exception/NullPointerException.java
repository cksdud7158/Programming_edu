package com.exception;

public class NullPointerException extends Exception{
	
	public NullPointerException(){
		this("This is DuplicateSSNException...");
	}	
	public NullPointerException(String message){
		super(message);
	}
}
