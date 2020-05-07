package exam.test;
/*
 * Singletone Pattern
 * ::
 * 클래스로부터 오직 단 한개의 인스턴스만 생성하고
 * 외부로부터 객체 생성을 하지 못하도록 막아두는 패턴
 * 
 * 코드 작성 방법
 * 1. 클래스에서 일단 하나의 객체를 생성 --- private static 으로 지정해서 생성
 * 2. 외부에서 객체생성을 못하도록 막는다 ---- private 생성자()
 * 3. 하나 만들어놓은 객체를 외부에서 사용할수 있도록 열어둔다 --- public static지정
 * 
 */

import java.security.GeneralSecurityException;

class Factory{
	private static Factory factory = new Factory();
	private Factory() {
		System.out.println("Car Factory....Creating...");
	}
	public static Factory getInstance() {
		return factory;
	}
}
public class StaticExamTest5 {	
	public static void main(String[] args) {
	//	Factory f = new Factory();
		Factory factory1 = Factory.getInstance();
		Factory factory2= Factory.getInstance();
		Factory factory3 = Factory.getInstance();
	}
}




