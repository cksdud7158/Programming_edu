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
	 * 1. Object�� ����� �״�� �޾Ƽ�
	 * 2. �� ����� �ڽ� ���ο��� �µ��� ���� ����.
	 */
	@Override   
	public String toString() {
		return year+","+month+","+day;  //super �� �θ� �ǹ�, ���⼭�� Object 
		//�̰��� �������̵�
	}
}
