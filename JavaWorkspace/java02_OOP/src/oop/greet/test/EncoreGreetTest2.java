package oop.greet.test;

import oop.greet.EncoreGreet;

/*
 * EncoreTest1 에서는 Field에 값을 직접적으로 입력했다.
 * 그런데 Field의 갯수가 늘어난다면 ? 필드가 20개를 초과한다면?
 * 이럴 경우 일일이 필드에 값을 입력하는 방식은 비효율적임 
 * 
 * 해결책 
 * : 모든 Field의 값을 한번에 받아서 할당해주는 Method를 새로 정의
 * EncoreTest2에서는 그 함수를 호출하는 방식을 사용해본다.  
 */
public class EncoreGreetTest2 {

	public static void main(String[] args) { //실행 메소드
		EncoreGreet en; //local 변수, Temporary 변수, Stack 에 쌓임, 기본값이 없음 
		en = new EncoreGreet(); // 객체를 생성 = 메모리에 올려 -> 객체의 구성 요소를 메모리에 올림(field, method)-> 주소값 할당
		//EncoreGreet en = new EncoreGreet();
		
		en.setEncore("박찬영", "하이", 4,"java" );//Method Calling
		System.out.println(en.getEncore());
		en.sayHello();
	}

}
