package oop.encapsulation.test;
/*
 * Encapsulation 작성 패턴
 * 1. 필드앞 ---> private
 * 2. setter() /getter() ---> public
 * 3. setter(){
 *    첫라인에서(필드 초기화 하기 직전에) 값을 타당성을 검사하는 제어문을 통해서 
 *    valid한 값만 필드에 할당되도록 한다
 */
import oop.encapsulation.MyDate;

public class MyDateTest1 {

	public static void main(String[] args) {
		MyDate md = new MyDate();
		//필드에 직접적으로 값을 할당
		md.month = 13;
		md.day = 33;
	}
}
