package oop.encapsulation;

public class MyDate {
	private int month;
	private int day;
	
	//�������� �����ȿ� � ���� ������ ������ ���� �˾ƾ���. 
	public int getMonth() {
		return month;
	}
	// ���� ������ �ʵ��� �̸��� ���� �� �̸� �����ϱ����� �ʵ� �տ� this �� ���δ�.
	// this�� �ش� Ŭ���� �ڱ� �ڽ��� ����Ų��. -> �ش� Ŭ���� �ּҸ� �����ϴ� ���� 
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
