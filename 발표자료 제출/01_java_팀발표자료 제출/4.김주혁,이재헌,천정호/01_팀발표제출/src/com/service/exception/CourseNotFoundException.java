package com.service.exception;

public class CourseNotFoundException extends Exception {

	public CourseNotFoundException() {
		this("코스를 찾을수 없습니다.");
		
	}

	public CourseNotFoundException(String message) {
		super(message);
	}
	
}
