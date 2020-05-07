package exam.test;
/*
 * Singletone Pattern
 * ::
 * 클래스로부터 오직 단 한개의 인스턴스만 생성하고 
 * 외부로부터 객체 생성을 하지 못하도록 막아두는 패턴
 *  싱글톤 패턴 -> 객체를 만들때 class 는 필수 
 *  이때 싱글톤 타입으로 만들시 해당 인스턴스를 두개 이상 못 만듬
 *  
 *  코드 작성 방법
 *  	1. 클래스에서 일단 하나의 객체를 생성 --> private static 으로 지정해서 생성
 *  	2. 외부에서 객체 생성을 못하도록 막는다. ----> private 생성자()
 *  	3. 하나 만들어 놓은 객체를 외부에서 사용할 수 있도록 열어둔다. ---> public static 지정
 */

class Factory{
	private static Factory factory = new Factory(); //1번 과정
	private Factory() { // 2번 과정
		System.out.println("Car Factory..Creating");
	}
	
	public static Factory getInstance() { // 3번 과정 static을 꼭 써줘야 객체 생성이 안된 상태에서 접근 가능 
		return factory;
	}
}
public class StaticExamTest5 {	
	public static void main(String[] args) {
		// Factory f = new Factory(); // 생성자 호출이 안됨
		Factory factory1= Factory.getInstance();
		Factory factory2= Factory.getInstance();
		Factory factory3= Factory.getInstance();
		System.out.println(factory1);
		System.out.println(factory2);
		System.out.println(factory3);
	}
}
