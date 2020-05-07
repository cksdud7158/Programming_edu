package oop.encapsulation.test;

import oop.encapsulation.MyDate;
/*
 * Encapsulation 작성 패턴
 * 1. 필드 앞 --> private
 * 2. setter()/ getter() --> public
 * 3. setter()의 첫 라인(필드 초기화 직전)에서 값의 타당성을 검사하는 제어문을 통해서 valid한 값만 필드에 할당되도록 한다. 
 */
public class MyDateTest1 {

	public static void main(String[] args) {
		MyDate md = new MyDate();
		
		/*md.month =13;
		md.day =33;
*/
		md.setMonth(13);
		System.out.println(md.getMonth());
	}

}
