package com.vo;


import java.util.ArrayList;

public class Course {
	private int num;
	private String name;
	private Teacher teacher;
	private Manager manager;
	private ArrayList<String> subjects;

	public Course(int coursenum, String coursename, Teacher teacher, Manager manager, ArrayList<String> subjects) {
		this.num = coursenum;
		this.name = coursename;
		this.teacher = teacher;
		this.manager = manager;
		this.subjects = subjects;

	}

	public int getCoursenum() {
		return num;
	}

	public void setCoursenum(int coursenum) {
		this.num = coursenum;
	}

	public String getName() {
		return name;
	}

	public void setCoursename(String name) {
		this.name = name;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public ArrayList<String> getSubjects() {
		return subjects;
	}

	public void setSubjects(ArrayList<String> subjects) {
		this.subjects = subjects;
	}

	@Override
	public String toString() {
		return "Course [num=" + num + ", name=" + name + ", teacher=" + teacher + ", manager=" + manager + ", subjects="
				+ subjects + "]";
	}

}
