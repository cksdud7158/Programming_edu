package com.vo;

import java.util.ArrayList;

public class Student extends Member{

	ArrayList<Course> courses;
	
	public Student(int ssn, String name) {
		super(ssn, name);
		courses = new ArrayList<>();
	}
	
	public void addCourse(Course course) {
		courses.add(course);
	}
	
	public ArrayList<Course> getCourses() {
		return courses;
	}

}
