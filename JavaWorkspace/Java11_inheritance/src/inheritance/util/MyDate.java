package inheritance.util;

public class MyDate {
	private int year;
	private int month;
	private int day;
	
	public MyDate(int year, int month, int day) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	/*
	 * Method Overriding
	 * 1. Object의 기능을 그대로 받아서
	 * 2. 그 기능을 자식 본인에게 맞도록 고쳐 쓴다.
	 */
	@Override   
	public String toString() {
		return year+","+month+","+day;  //super 는 부모를 의미, 여기서는 Object 
		//이것이 오버라이딩
	}
}
