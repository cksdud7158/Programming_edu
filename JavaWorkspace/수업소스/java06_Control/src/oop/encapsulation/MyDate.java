package oop.encapsulation;
/*
 * 월을 먼저 입력 : 1~12사이의 값만 받고..그 이외의 값이 들어오면 필드에 할당되지 않도록 로직을 작성
 * 날짜 입력 : 
 *  1,3,5,7,8,10,12월 : 1~31일
 *  2월 : 1~28일
 *  4,6,9,11월 : 1~30일 까지의 값만 허용하도록 그 외의 날짜가 입력되면 필드에 할당되지 않도록 로직을 작성
 */
public class MyDate {
	public int month;//0
	public int day;//0
	
	public int getMonth() {
		return month;
	}
	//로컬변수와 필드의 이름이 같을때 구분하기 위해서 필드앞에 this를 지정한다.
	public void setMonth(int month) {
		if(month>=1 && month<=12) {
			this.month = month;
		}else {
			System.out.println("잘못된 월!!");
			System.exit(0);
		}		
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		switch(month) {
		case 2:
			if(day>=1 && day<=28) {
				this.day = day;
			}else {
				//필드 초기화를 못함
				System.out.println("잘못된 날짜!!");
				System.exit(0);
			}
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			if(day>=1 && day<=30) {
				this.day = day;
			}else {
				System.out.println("잘못된 날짜!!");
				System.exit(0);
			}
			break;
		default:
			if(day>=1 && day<=31) {
				this.day = day;
			}else {
				System.out.println("잘못된 날짜!!");
				System.exit(0);
			}
		}		
	}	
}




