import java.util.ArrayList;

public interface Service {
	public static Date today;
	public void AddStudent(Student s);
	public void UpdateStudent(String id, Student s);
	public Student SearchStudent(String id);
	public ArrayList<Student> SearchStudent(String name);
	public void DeleteStudent(String id);
	public double getThisMonthAttendance(String id);	//get the attendance of this month
	public double getTotalAttendance(String id);
	public double getThisMonthBenefit(String id);
	public int getThisMonthAbscent(String id);
	public int getThisMonthAvailableAbscent(String id);
	public int getTotalAvailableAbscent(String id);
	public ArrayList<Student> ShowAllStudentInfo();
	public int getRemainVacation(String id);
	

}
