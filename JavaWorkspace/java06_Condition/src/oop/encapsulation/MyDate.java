package oop.encapsulation;
/*
 * ���� ���� �Է� : 1~12 ������ ���� �ް� �� �̿��� ���� ������ �ʵ忡 �Ҵ���� �ʵ��� ������ �ۼ� 
 * 
 * ��¥ �Է� : 
 * 1,3,5,7,8,10,12 : 1~31��
 * 2��  : 28��
 * 4,6,9,11 : 1~30�� ������ ���� ���ǵ��� �� ���� ���� ������ �ʵ忡 �Ҵ�����ʵ��� ������ �ۼ� 
 */
public class MyDate {
	private int month;
	private int day;
	
	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		if(month>=1 && month <= 12) {
			this.month = month;
		}
		else {
			System.out.println("1~12 ������ ���� �Է����ּ���");
			System.exit(0);
		}
	}
	
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		switch(month) {
		case 2:
			if(day>=1 && day<28) {
				this.day = day;
			}
			else {
				System.out.println("�߸��� ��¥�Դϴ�.");
				System.exit(0);
			}
			break;
		case 4:
			if(day>=1 && day<30) {
				this.day = day;
			}
			else {
				System.out.println("�߸��� ��¥�Դϴ�.");
				System.exit(0);
			}
			break;
		case 6:
			if(day>=1 && day<30) {
				this.day = day;
			}
			else {
				System.out.println("�߸��� ��¥�Դϴ�.");
				System.exit(0);
			}
			break;
		case 9:
			if(day>=1 && day<30) {
				this.day = day;
			}
			else {
				System.out.println("�߸��� ��¥�Դϴ�.");
				System.exit(0);
			}
			break;
		case 11:
			if(day>=1 && day<30) {
				this.day = day;
			}
			else {
				System.out.println("�߸��� ��¥�Դϴ�.");
				System.exit(0);
			}
			break;
		default :
			if(day>=1 && day<31) {
				this.day = day;
			}
			else {
				System.out.println("�߸��� ��¥�Դϴ�.");
				System.exit(0);
			}
			break;
		
		}
		
	}
	
	
	}
