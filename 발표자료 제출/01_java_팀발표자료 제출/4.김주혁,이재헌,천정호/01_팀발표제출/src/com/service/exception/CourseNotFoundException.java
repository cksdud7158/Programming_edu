package com.service.exception;

public class CourseNotFoundException extends Exception {

	public CourseNotFoundException() {
		this("�ڽ��� ã���� �����ϴ�.");
		
	}

	public CourseNotFoundException(String message) {
		super(message);
	}
	
}
