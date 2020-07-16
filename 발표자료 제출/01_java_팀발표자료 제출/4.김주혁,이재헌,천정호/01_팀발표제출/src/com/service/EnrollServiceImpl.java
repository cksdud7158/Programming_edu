package com.service;

import java.util.ArrayList;

import com.service.exception.CourseNotFoundException;
import com.vo.Course;
import com.vo.Student;

public class EnrollServiceImpl implements EnrollService {

	private Student student;
	private ArrayList<Course> courses;
	private static EnrollServiceImpl enrollservice;

	private EnrollServiceImpl(ArrayList<Course> courses, Student student) {
		this.student = student;
		this.courses = courses;
	}

	public static EnrollServiceImpl getInstance(ArrayList<Course> courses, Student student) {
		if (enrollservice == null) {
			enrollservice = new EnrollServiceImpl(courses, student);
		}
		return enrollservice;
	}

	public Student getStudent() {
		return student;
	}

	public ArrayList<Course> getCourses() {
		return courses;
	}

	@Override
	public void enrollCourse(String courseName) throws CourseNotFoundException {
		Course ck = null;
		for (Course course : courses) {
			if (course == null)
				continue;
			if (course.getName().equals(courseName)) {
				student.addCourse(course);
				ck = course;

			}
		}
		if (ck == null) {
			throw new CourseNotFoundException();
		}
		System.out.println(courseName + "의 강좌가 없습니다.");
	}

	@Override
	public ArrayList<Course> searchCourse() {
		return courses;
	}

	@Override
	public ArrayList<Course> searchCourse(String courseName) throws CourseNotFoundException {
		ArrayList<Course> result = new ArrayList<>();

		for (Course course : courses) {
			if (course == null)
				continue;
			if (course.getName().equals(courseName)) {
				result.add(course);
			}
		}
		if (result.size() == 0) {
			throw new CourseNotFoundException();
		}

		return result;
	}

	@Override
	public ArrayList<Course> searchCourse(int courseNumber) throws CourseNotFoundException {
		ArrayList<Course> result = new ArrayList<>();

		for (Course course : courses) {
			if (course == null)
				continue;
			if (course.getCoursenum() == courseNumber) {
				result.add(course);
			}
		}
		if (result.size() == 0) {
			throw new CourseNotFoundException();
		}

		return result;
	}

	@Override
	public ArrayList<Course> searchEnrolledCourse() {

		return student.getCourses();
	}

	@Override
	public ArrayList<Course> searchEnrolledCourse(String courseName) throws CourseNotFoundException {
		ArrayList<Course> result = new ArrayList<>();

		for (Course course : student.getCourses()) {
			if (course == null)
				continue;
			if (course.getName().equals(courseName)) {
				result.add(course);
			}
		}
		if (result.size() == 0) {
			throw new CourseNotFoundException();
		}

		return result;
	}

	@Override
	public ArrayList<Course> searchEnrolledCourse(int courseNumber) throws CourseNotFoundException {
		ArrayList<Course> result = new ArrayList<>();

		for (Course course : student.getCourses()) {
			if (course == null)
				continue;
			if (course.getCoursenum() == courseNumber) {
				result.add(course);
				return result;
			}
		}
		if (result.size() == 0) {
			throw new CourseNotFoundException();
		}

		return result;
	}

	@Override
	public void deleteCourse() {
		student.getCourses().clear();
	}

	@Override
	public void deleteCourse(String courseName) throws CourseNotFoundException {

		for (Course course : student.getCourses()) {
			if (course == null)
				continue;
			if (course.getName().equals(courseName)) {
				student.getCourses().remove(course);
				return;
			}
		}

		throw new CourseNotFoundException();

	}

	@Override
	public void deleteCourse(int courseNumber) throws CourseNotFoundException {

		for (Course course : student.getCourses()) {
			if (course == null)
				continue;
			if (course.getCoursenum() == courseNumber) {
				student.getCourses().remove(course);
				return;
			}
		}
		throw new CourseNotFoundException();

	}

}
