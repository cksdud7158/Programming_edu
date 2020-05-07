package hrd.service;
import java.util.ArrayList;
import hrd.student.vo.*;

public interface Service {
	
//======================1============================
	public void AddStudent(Student s);
//	public void UpdateStudent(String id, Student s);
	public void updateLate(String id, int month);
	public void updateAbscent(String id, int month);
//	=======================2=======================
	public Student SearchStudent(String id);
//	public ArrayList<Student> SearchStudent(String name);
	public void DeleteStudent(String id);
	public ArrayList<Student> ShowAllStudentInfo();
	public int getRemainVacation(String id);
///=====================2========================
	public double getThisMonthAttendanceRate(String id);
	public double getTotalAttendanceRate(String id);
	public double getThisMonthBenefit(String id);
	public int getThisMonthAttendance(String id);
	public int getThisMonthAbscence(String id);
	public int getThisMonthAvailableAbscence(String id);	//한달에 80% 이상 출석해야 수당을 받음
	public int getTotalAvailableAbscence(String id);		//총 80%이상 출석해야 수료
	

	
	

}
