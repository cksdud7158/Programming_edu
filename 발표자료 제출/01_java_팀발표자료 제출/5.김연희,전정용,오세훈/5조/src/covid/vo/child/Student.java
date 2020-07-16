package covid.vo.child;

import covid.util.Fever;
import covid.vo.parent.Visitor;

public class Student extends Visitor {
	
	private int roomNum;
	private String major;
	
	public Student() {}
	public Student(String name, boolean mask, Fever fever , int roomNum, String major) {
		super(name, mask, fever);
		this.roomNum = roomNum;
		this.major = major;
	}
	public Student(String name, boolean mask, Fever fever , String symptom, int roomNum, String major) {
		super(name, mask, fever, symptom);
		this.roomNum = roomNum;
		this.major = major;
	}
	public int getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	@Override
	public String toString() {
		return super.toString() + "\n���� : �л�" + "\n���ǽ� ��ȣ : " + roomNum + "\n���� : " + major;
	}
}
