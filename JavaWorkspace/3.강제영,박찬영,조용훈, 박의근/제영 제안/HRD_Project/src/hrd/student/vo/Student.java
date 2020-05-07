package hrd.student.vo;
import hrd.vo.*;
public class Student {
	private String id;
	private String name;
	private	Attendance attendance;
	private Benefit benefit;
	
	public Student(String id, String name, Attendance attendance, Benefit benefit) {
		super();
		this.id = id;
		this.name = name;
		this.attendance = attendance;
		this.benefit = benefit;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Attendance getAttendance() {
		return attendance;
	}
	public void setAttendance(Attendance attendance) {
		this.attendance = attendance;
	}
	public Benefit getBenefit() {
		return benefit;
	}
	public void setBenefit(Benefit benefit) {
		this.benefit = benefit;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", attendance=" + attendance + ", benefit=" + benefit + "]";
	}
	
	
}
