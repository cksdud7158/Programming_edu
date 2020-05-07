/*
 * 직렬화 
 * OnjectOutStream - sink 쪽으로 객체가 날라간다. 
 * 정확히 표현하면 객체의 필드값이 직렬화 되어져서 객체 스트림을 통과하는 것 
 * 
 * 이렇게 Person 이 객체 스트림을 직렬화로 통과하려면
 * 반드시 Serializable 를 인터페이스화 해야함
 */
package io.object.test_4;

import java.io.Serializable;

public class Person implements Serializable{
	private String name;
	private int i;
	private String string2;

	public Person(String string, int i, String string2) {
		// TODO Auto-generated constructor stub
	} 
	

}
