package oop.greet.test;

import java.util.Scanner;

import oop.greet.EncoreGreet;

public class EncoreGreetTest {
	public static void main(String[] args) {//실행메소드
		EncoreGreet en = new EncoreGreet();
		
		//지금처럼 소스코드에 값을 직접 하드코딩 하지 않고
		// 실행시에 키보드로 입력받은 값을 처리하도록...Scanner 사용
		
		Scanner sc = new Scanner(System.in);
		System.out.println("이름을 입력하세요>>>>");//임채은
		String scName=sc.nextLine();
		en.name=scName;
		
		System.out.println("메세지를 입력하세요>>>>");//임채은
		String scMsg=sc.nextLine();
		en.message = scMsg;
		en.sayHello();
	}
}





