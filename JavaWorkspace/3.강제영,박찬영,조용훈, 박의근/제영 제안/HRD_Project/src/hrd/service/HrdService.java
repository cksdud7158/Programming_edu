package hrd.service;

import java.util.ArrayList;
import java.util.List;


import hrd.student.vo.Student;
import hrd.vo.Date;
import hrd.vo.Dates;

public class HrdService {
	ArrayList<Student> Student = new ArrayList<Student>();
	
	
	private static HrdService HrdS = new HrdService();
	
	private HrdService() {
		Student = new ArrayList<>();
		
	}
	//3. 싱글톤 step3
	public static HrdService HrdService() {
		return HrdS;
	};

	

service 
service.AddStudent(new Student )
	@Override
	public void AddStudent(Student s) {
		Student.add(s);
		
	}

	@Override
	public void updateLate(String id, int month) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateAbscent(String id, int month) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Student SearchStudent(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void DeleteStudent(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Student> ShowAllStudentInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getRemainVacation(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Double> getThisMonthAttendanceRate(String id, int thismonth) {
		ArrayList<Double> temp = new ArrayList<Double>(); 
		double thisMonthAttendance = 0.0;
		double thisMonthAttendanceRate = 0.0;
		for(Student s : Student) {
			if(s.getId().equals(id)) {
				thisMonthAttendance = s.getAttendance().getAttendace().get(thismonth-4);
				thisMonthAttendanceRate = thisMonthAttendance/Dates.getThisMonth(); //**** / *100 (이달에 총 수업일수)
				temp.add(thisMonthAttendance); // 출석일수를 0번째 인덱스에
				temp.add(thisMonthAttendanceRate); // 출석율은 1번째 인덱스에
			}
		}
		return temp;
	}

	@Override
	public ArrayList<Double> getTotalAttendanceRate(String id, int thismonth) {
		ArrayList<Double> temp = new ArrayList<Double>(); 
		double totalAttendance = 0.0;
		double totalAttendanceRate = 0.0;
		for(int i=0;i<thismonth-4;i++) {
			double pastTotalAttendance = Date.getAttendace().get(i);
		}
		for(Student s : Student) {
			
			if(s.getId().equals(id)) {
				
				totalAttendance +=  thismont~~;
				
			}
		}
		return temp;
	}

	@Override
	public double getThisMonthBenefit(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getThisMonthAttendance(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getThisMonthAbscence(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getThisMonthAvailableAbscence(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTotalAvailableAbscence(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
