package oop.constructor;
/*
 * Default Constructor
 * 1. 인자값이 없는 생성자
 * 2. 구현부에서 아무런 일도 하지않는 생성자 
 * 3. field에 아무 값도 할당하지 않음 
 */
public class Shirt {
	public String maker;
	public boolean longSleeved; 
	
	
	public char color;
	
	
	public Shirt(){// Default Constructor(기본 생성자)/ 하나의 클래스에는 반드시 하나 이상의 생성자가 존재한다. 
		
	}
	public Shirt(String m , boolean longs, char c){ 
		// 필드 초기화 
		maker = m;
		longSleeved = longs;
		color = c;
	}
	public String getDetails() { //worker method = 구현부가 있는 메소드
		return maker+","+longSleeved+","+color;
	}
}
