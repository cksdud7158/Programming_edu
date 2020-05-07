package hrd.service.test;


import java.util.ArrayList;

import javax.xml.ws.Service;

import hrd.service.ServiceImpl;
import hrd.student.vo.Student;
import hrd.vo.Attendance;
import hrd.vo.Benefit;
import hrd.vo.Date;


public class Test {

	public static void main(String[] args) {
		//싱글톤
		ServiceImpl service = ServiceImpl.getInstance();
		
		//오늘 일자 입력
		Date today = new Date(2020, 4, 25);
		
		//기본 변수
		ArrayList<Integer> days = new ArrayList<Integer>();//14,17,22,20,21,19>
		//for(int i=0; i<Date.days.length;i++) days.add(0);
		for(int i : Date.days) {
			days.add(i)	;
		}
		ArrayList<Integer> abscent = new ArrayList<Integer>();//0,0,0,0,0,0
		for(int i=0; i<Date.days.length;i++) abscent.add(0);
		ArrayList<Integer> late = new ArrayList<Integer>();//0,0,0,0,0,0
		for(int i=0; i<Date.days.length;i++) late.add(0);
		
		//add
		service.AddStudent(new Student("01", "강제영", new Attendance(days, abscent, late), new Benefit(1, 2580)));
		service.AddStudent(new Student("02", "조용훈", new Attendance(days, abscent, late), new Benefit(2, 2580)));
		service.AddStudent(new Student("03", "박찬영", new Attendance(days, abscent, late), new Benefit(1, 2580)));
		
		ArrayList<Student> temp = service.ShowAllStudentInfo();
		for(Student s : temp) System.out.println(s);
		
		//update
		service.updateAbscent("01", 4, 1);
		
		ArrayList<Student> temp2 = service.ShowAllStudentInfo();
		for(Student s : temp2) System.out.println(s);
		
		service.updateLate("01", 7, 7);
		
		ArrayList<Student> temp3 = service.ShowAllStudentInfo();
		for(Student s : temp3) System.out.println(s);
		
		//delete
		service.DeleteStudent("02");
		
		ArrayList<Student> temp4 = service.ShowAllStudentInfo();
		for(Student s : temp4) System.out.println(s);
		
		//
		ArrayList<Double> temp5 = service.getThisMonthAttendanceRate("01", 4);
		for(Double s : temp5) System.out.println(s);
		
		
		
		
		
	}
	

}
