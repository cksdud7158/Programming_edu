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
			System.out.println("�����ϴ�.");
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

		// �ش� ���¿��� ���� ����: subjects
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

		// ������ ��ǻ�� ���
		ArrayList<String> languages = new ArrayList<String>();
		languages.add("Java");
		languages.add("C++");
		languages.add("Python");
		languages.add("HTML");

		// ����
		Course course1 = new Course(1, "�� ������ �÷���", new Teacher(1, "Kim", languages), new Manager(1, "Manager_1"),
				subjects1);
		Course course2 = new Course(2, "������ ���̾�Ƽ��Ʈ", new Teacher(2, "Lee", languages), new Manager(2, "Manager_2"),
				subjects2);
		Course course3 = new Course(3, "�� ��ġ�� ���� ������ �м�", new Teacher(3, "Park", languages),
				new Manager(3, "Manager_1"), subjects3);
		Course course4 = new Course(4, "AI�� �̿��� �ð� ������ �м�", new Teacher(4, "Choi", languages),
				new Manager(4, "Manager_2"), subjects4);

		// ���¸� ��� �ִ� ArrayList
		ArrayList<Course> courses = new ArrayList<Course>();
		courses.add(course1);
		courses.add(course2);
		courses.add(course3);
		courses.add(course4);

		// �̱��� ���� ���
		System.out.println("** �̱��� ���� ��ü���� **");
		EnrollServiceImpl enrollservice = EnrollServiceImpl.getInstance(courses, new Student(1, "Test Student"));
		System.out.println("** �̱��� ���� ��ü���� �Ϸ� **");

		System.out.println("==================== 1.������û�ϱ�(enrollCourse(���Ǹ�)====================");
		try {
			enrollservice.enrollCourse("�� ������ �÷���");
			EnrollTest.printInfo(enrollservice.getStudent().getCourses());
			enrollservice.enrollCourse("������ ���̾�Ƽ��Ʈ");
			enrollservice.enrollCourse("�� ��ġ�� ���� ������ �м�");
			enrollservice.enrollCourse("���� ������ �÷���");
			System.out.println("\n");

		} catch (CourseNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println("==================== 2_1.���� �� ��� ���� �Ѳ����� ����(searchCourse()====================");
		EnrollTest.printInfo(enrollservice.searchCourse());

		System.out.println("==================== 2_2.���� �� ���� ���Ǹ����� ã��(searchCourse(���Ǹ�)====================");
		try {
			EnrollTest.printInfo(enrollservice.searchCourse("������ ���̾�Ƽ��Ʈ"));
		} catch (CourseNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("==================== 2_3.���� �� ����  ���� ��ȣ�� ã��(searchCourse(���ǹ�ȣ)====================");
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

		System.out.println("==================== 3_1���� ��û�� ��系������(searchCourse()====================");
		EnrollTest.printInfo(enrollservice.searchEnrolledCourse());

		System.out.println("==================== 3_2.���� ��û�� ������ ���Ǹ����� ã��(searchCourse(���Ǹ�)====================");
		try {
			EnrollTest.printInfo(enrollservice.searchEnrolledCourse("������ ���̾�Ƽ��Ʈ"));
		} catch (CourseNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			enrollservice.searchCourse("������ ���̿ø��Ͻ�Ʈ");
		} catch (CourseNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("==================== 3_3.���� ��û�� ������ ���� ��ȣ�� ã��(searchCourse(���� ��ȣ)====================");
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

		System.out.println("==================== 4_1.���� ���� ���Ǹ����� ���(deleteCourse(���Ǹ�))====================");
		EnrollTest.printInfo(enrollservice.searchEnrolledCourse());
		System.out.println("");
		try {
			enrollservice.deleteCourse("������ ���̾�Ƽ��Ʈ");
		} catch (CourseNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		EnrollTest.printInfo(enrollservice.searchEnrolledCourse());
		try {
			enrollservice.deleteCourse("������ ���̿ø��Ͻ�Ʈ");
		} catch (CourseNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("\n");

		System.out.println("==================== 4_2.���� ���� ���� ��ȣ�� ���(deleteCourse(���� ��ȣ))====================");
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

		System.out.println("==================== 4_3.��� ���� ���� ���(deleteCourse())====================");
		enrollservice.deleteCourse();
		EnrollTest.printInfo(enrollservice.searchEnrolledCourse());
		System.out.println("\n");

	}

}
