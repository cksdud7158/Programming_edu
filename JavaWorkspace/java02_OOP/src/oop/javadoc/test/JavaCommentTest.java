package oop.javadoc.test;
/*
 * main() 가지고 실행하는 실행 클래스
 * JavaComment 객체 실행한다 = 객체를 생성 = 메모리에 올린다. = Member(fieldm, method)가 메모리에 올라간다.-> JVM 아래 Heap에 주소 배정
 * -> new 를 통해 생성되는 Member만 Heap에 올라감
 * 객체 생성의 결론 -> 주소 할당 ( 저장된 객체의 위치값이 지정됨)
 *  */
import oop.javadoc.JavaComment;

public class JavaCommentTest {

	public static void main(String[] args) {
		JavaComment jc = new JavaComment();
		// jc를 참조 변수(Reference Variable)라 부름(주소값을 참조함)
		System.out.println(jc);
		
		//jc 라는 이름의 객체를 생성한 이유 -> 사용하기 위해 
		// 필드 사용 -> 값 할당
		// 메소드 사용 -> 호출(호출해야지만 기능이 동작한다.)
		
		jc.name = "Ryan"; //값 할당
		System.out.println(jc.scoreSum(100, 100));   //Method Calling
		
	}

}
