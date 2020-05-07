package com.service;

import java.util.ArrayList;

import com.service.exception.CourseNotFoundException;
import com.vo.Course;

public interface EnrollService {
	
	void enrollCourse(String courseName) throws CourseNotFoundException;
	
	ArrayList<Course> searchCourse();
	ArrayList<Course> searchCourse(String courseName) throws CourseNotFoundException;
	ArrayList<Course> searchCourse(int courseNumber) throws CourseNotFoundException;
	
	ArrayList<Course> searchEnrolledCourse();
	ArrayList<Course> searchEnrolledCourse(String courseName) throws CourseNotFoundException;
	ArrayList<Course> searchEnrolledCourse(int courseNumber) throws CourseNotFoundException;
	
	void deleteCourse();
	void deleteCourse(String courseName) throws CourseNotFoundException;
	void deleteCourse(int courseNumber) throws CourseNotFoundException;
	
}