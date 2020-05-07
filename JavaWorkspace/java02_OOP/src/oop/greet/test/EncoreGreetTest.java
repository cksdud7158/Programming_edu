package oop.greet.test;

import java.util.Scanner;

import oop.greet.EncoreGreet;

public class EncoreGreetTest {

	public static void main(String[] args) { //실행 메소드
		EncoreGreet en; //local 변수, Temporary 변수, Stack 에 쌓임, 기본값이 없음 
		en = new EncoreGreet(); // 객체를 생성 = 메모리에 올려 -> 객체의 구성 요소를 메모리에 올림(field, method)-> 주소값 할당
		/*
		 * 1. 묵시적인 초기화
		 * 2. 주소값 할당
		 * 3. Stack 영역에 en 변수에 주소값 할당
		 * 4. 참조 발생
		 */
		
		//지금처럼 소스코드에 값을 직접 하드코딩하지 않고
		// 실행시에 화면단에 키보드로 값을 입력받아 처리되도록 Scanner 사용 
		Scanner sc = new Scanner(System.in);
		System.out.println("이름을 입력하세요");
		String scname =  sc.nextLine();
		en.name = scname;
		
		System.out.println("메세지를 입력하세요");
		String scmessage =  sc.nextLine();
		en.message = scmessage;

		en.sayHello();
	}

}
