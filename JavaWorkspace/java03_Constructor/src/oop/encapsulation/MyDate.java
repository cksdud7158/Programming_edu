package oop.encapsulation;

public class MyDate {
	private int month;
	private int day;
	
	//변수명은 변수안에 어떤 값이 들어가는지 변수명만 보고도 알아야함. 
	public int getMonth() {
		return month;
	}
	// 로컬 변수와 필드의 이름이 같을 때 이를 구분하기위해 필드 앞에 this 를 붙인다.
	// this는 해당 클래스 자기 자신을 가리킨다. -> 해당 클래스 주소를 참조하는 역할 
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	
	
}
