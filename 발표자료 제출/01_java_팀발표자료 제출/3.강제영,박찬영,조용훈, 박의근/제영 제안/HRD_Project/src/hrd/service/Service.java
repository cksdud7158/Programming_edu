package hrd.service;
import java.util.ArrayList;
import hrd.student.vo.*;

public interface Service {
	
//======================1============================
	public void AddStudent(Student s);
//	public void UpdateStudent(String id, Student s);
	public void updateLate(String id, int month, int late);
	public void updateAbscent(String id, int month, int abscent);
//	=======================2=======================
	public ArrayList<Student> SearchStudent(String id);
//	public ArrayList<Student> SearchStudent(String name);
	public void DeleteStudent(String id);
	public ArrayList<Student> ShowAllStudentInfo();
	public int getRemainVacation(String id);
///=====================2========================
	public ArrayList<Double> getThisMonthAttendanceRate(String id, int thismonth);
	public ArrayList<Double> getTotalAttendanceRate(String id, int thismonth);
	public double getThisMonthBenefit(String id);
	public int getThisMonthAttendance(String id);
	public int getThisMonthAbscence(String id);
	public int getThisMonthAvailableAbscence(String id);	//�Ѵ޿� 80% �̻� �⼮�ؾ� ������ ����
	public int getTotalAvailableAbscence(String id);		//�� 80%�̻� �⼮�ؾ� ����
	
	
	
	

	
	

}
