package oop.constructor;
/*
 * Default Constructor:
 * 1. 인자값이 없는 생성자
 * 2. 구현부에서 아무런 일도 하지 않는 생성자
 */
public class Shirt {
	public String maker;//기본값을 가진다...null
	public boolean longSleeved;
	public char color;
	
	public Shirt(){}//Default Constructor
	public Shirt(String m, boolean longs, char c){
		//
		maker = m;
		longSleeved = longs;
		color = c;
	}
	public String getDetails() { //worker method=구현부가 있는 메소드
		return maker+", "+longSleeved+","+color;
	}
}










