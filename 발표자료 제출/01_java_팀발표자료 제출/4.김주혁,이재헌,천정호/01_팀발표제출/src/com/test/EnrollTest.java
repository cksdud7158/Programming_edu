package com.test;

import java.util.ArrayList;

import com.service.EnrollServiceImpl;
import com.service.exception.CourseNotFoundException;
import com.vo.Course;
import com.vo.Manager;
import com.vo.Student;
import com.vo.Teacher;

public class EnrollTest {
	public static void printInfo(ArrayList<Course> courses) {
		if (courses.size() == 0) {
			System.out.println("없습니다.");
		} else {
			for (Course c : courses) {
				if (c == null) {
					continue;
				}
				System.out.println(c.toString());
			}
		}

	}

	public static void main(String[] args) {

		// 해당 강좌에서 배우는 과목: subjects
		ArrayList<String> subjects1 = new ArrayList<String>();
		ArrayList<String> subjects2 = new ArrayList<String>();
		ArrayList<String> subjects3 = new ArrayList<String>();
		ArrayList<String> subjects4 = new ArrayList<String>();

		subjects1.add("JAVA1");
		subjects1.add("JAVA2");
		subjects1.add("JAVA3");
		subjects1.add("JAVA4");

		subjects2.add("Python1");
		subjects2.add("Python2");
		subjects2.add("Python3");
		subjects2.add("Python4");

		subjects3.add("JAVA1");
		subjects3.add("JAVA2");
		subjects3.add("JAVA3");
		subjects3.add("JAVA4");

		subjects4.add("Python1");
		subjects4.add("Python2");
		subjects4.add("Python3");
		subjects4.add("Python4");

		// 강사의 컴퓨터 언어
		ArrayList<String> languages = new ArrayList<String>();
		languages.add("Java");
		languages.add("C++");
		languages.add("Python");
		languages.add("HTML");

		// 강좌
		Course course1 = new Course(1, "빅 데이터 플렛폼", new Teacher(1, "Kim", languages), new Manager(1, "Manager_1"),
				subjects1);
		Course course2 = new Course(2, "데이터 사이언티스트", new Teacher(2, "Lee", languages), new Manager(2, "Manager_2"),
				subjects2);
		Course course3 = new Course(3, "고객 유치를 위한 데이터 분석", new Teacher(3, "Park", languages),
				new Manager(3, "Manager_1"), subjects3);
		Course course4 = new Course(4, "AI를 이용한 시각 데이터 분석", new Teacher(4, "Choi", languages),
				new Manager(4, "Manager_2"), subjects4);

		// 강좌를 담고 있는 ArrayList
		ArrayList<Course> courses = new ArrayList<Course>();
		courses.add(course1);
		courses.add(course2);
		courses.add(course3);
		courses.add(course4);

		// 싱글톤 패턴 사용
		System.out.println("** 싱글톤 패턴 객체생성 **");
		EnrollServiceImpl enrollservice = EnrollServiceImpl.getInstance(courses, new Student(1, "Test Student"));
		System.out.println("** 싱글톤 패턴 객체생성 완료 **");

		System.out.println("==================== 1.수강신청하기(enrollCourse(강의명)====================");
		try {
			enrollservice.enrollCourse("빅 데이터 플렛폼");
			EnrollTest.printInfo(enrollservice.getStudent().getCourses());
			enrollservice.enrollCourse("데이터 사이언티스트");
			enrollservice.enrollCourse("고객 유치를 위한 데이터 분석");
			enrollservice.enrollCourse("스몰 데이터 플렛폼");
			System.out.println("\n");

		} catch (CourseNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println("==================== 2_1.개설 된 모든 강의 한꺼번에 보기(searchCourse()====================");
		EnrollTest.printInfo(enrollservice.searchCourse());

		System.out.println("==================== 2_2.개설 된 강의 강의명으로 찾기(searchCourse(강의명)====================");
		try {
			EnrollTest.printInfo(enrollservice.searchCourse("데이터 사이언티스트"));
		} catch (CourseNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("==================== 2_3.개설 된 강의  강의 번호로 찾기(searchCourse(강의번호)====================");
		try {
			EnrollTest.printInfo(enrollservice.searchCourse(1));
		} catch (CourseNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			enrollservice.searchCourse(300);
		} catch (CourseNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("\n");

		System.out.println("==================== 3_1수강 신청한 모든내역보기(searchCourse()====================");
		EnrollTest.printInfo(enrollservice.searchEnrolledCourse());

		System.out.println("==================== 3_2.수강 신청한 강의중 강의명으로 찾기(searchCourse(강의명)====================");
		try {
			EnrollTest.printInfo(enrollservice.searchEnrolledCourse("데이터 사이언티스트"));
		} catch (CourseNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			enrollservice.searchCourse("데이터 바이올리니스트");
		} catch (CourseNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("==================== 3_3.수강 신청한 강의중 강의 번호로 찾기(searchCourse(강의 번호)====================");
		try {
			EnrollTest.printInfo(enrollservice.searchEnrolledCourse(1));
		} catch (CourseNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			enrollservice.searchCourse(300);
		} catch (CourseNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("\n");

		System.out.println("==================== 4_1.수강 과목 강의명으로 취소(deleteCourse(강의명))====================");
		EnrollTest.printInfo(enrollservice.searchEnrolledCourse());
		System.out.println("");
		try {
			enrollservice.deleteCourse("데이터 사이언티스트");
		} catch (CourseNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		EnrollTest.printInfo(enrollservice.searchEnrolledCourse());
		try {
			enrollservice.deleteCourse("데이터 바이올리니스트");
		} catch (CourseNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("\n");

		System.out.println("==================== 4_2.수강 과목 강의 번호로 취소(deleteCourse(강의 번호))====================");
		EnrollTest.printInfo(enrollservice.searchEnrolledCourse());
		System.out.println("");
		try {
			enrollservice.deleteCourse(3);
		} catch (CourseNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		EnrollTest.printInfo(enrollservice.searchEnrolledCourse());
		try {
			enrollservice.deleteCourse(400);
		} catch (CourseNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("\n");

		System.out.println("==================== 4_3.모든 수강 과목 취소(deleteCourse())====================");
		enrollservice.deleteCourse();
		EnrollTest.printInfo(enrollservice.searchEnrolledCourse());
		System.out.println("\n");

	}

}
