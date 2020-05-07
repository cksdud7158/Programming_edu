package oop.encapsulation.test;
import java.util.Scanner;

/*
 * 스캐너 객체를 통해서 월과 날짜를 입력받고 
 * 마지막에 오늘은 *월 *일 입니다. 로 출력
 * 
 * 만약 잘못된 월이나 날짜가 입력된 경우에는 
 * 잘못된 날짜입니다.
 * 출력
 */
import oop.encapsulation.MyDate;

public class MyDateTest1 {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		MyDate md =new MyDate();
		
		System.out.println("월 입력>>");
		int month =sc.nextInt();
		System.out.println("날짜 입력>>");
		int day =sc.nextInt();
		
		md.setMonth(month);
		md.setDay(day);
		
		System.out.println("오늘은"+md.getMonth()+"월"+md.getDay()+"일 입니다.");
		
	}

}
