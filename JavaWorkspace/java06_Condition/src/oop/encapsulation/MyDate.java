package oop.encapsulation;
/*
 * 월을 먼저 입력 : 1~12 사이의 값만 받고 그 이외의 값이 들어오면 필드에 할당되지 않도록 로직을 작성 
 * 
 * 날짜 입력 : 
 * 1,3,5,7,8,10,12 : 1~31일
 * 2월  : 28일
 * 4,6,9,11 : 1~30일 가지의 값만 허용되도록 그 외의 값이 들어오면 필드에 할당되지않도록 로직을 작성 
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
			System.out.println("1~12 사이의 월을 입력해주세요");
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
				System.out.println("잘못된 날짜입니다.");
				System.exit(0);
			}
			break;
		case 4:
			if(day>=1 && day<30) {
				this.day = day;
			}
			else {
				System.out.println("잘못된 날짜입니다.");
				System.exit(0);
			}
			break;
		case 6:
			if(day>=1 && day<30) {
				this.day = day;
			}
			else {
				System.out.println("잘못된 날짜입니다.");
				System.exit(0);
			}
			break;
		case 9:
			if(day>=1 && day<30) {
				this.day = day;
			}
			else {
				System.out.println("잘못된 날짜입니다.");
				System.exit(0);
			}
			break;
		case 11:
			if(day>=1 && day<30) {
				this.day = day;
			}
			else {
				System.out.println("잘못된 날짜입니다.");
				System.exit(0);
			}
			break;
		default :
			if(day>=1 && day<31) {
				this.day = day;
			}
			else {
				System.out.println("잘못된 날짜입니다.");
				System.exit(0);
			}
			break;
		
		}
		
	}
	
	
	}
