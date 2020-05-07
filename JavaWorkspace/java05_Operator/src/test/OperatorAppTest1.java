package test;
/*
 * Local Variable 와 Field Variable 기준은 
 * 선언된 위치에 따라 나뉘어진다. 
 * Field Variable  
 * 1.클래스 바로 밑, 메소드 바깥, 
 * 2.기본값이 있다. 
 * 3.Heap에 자리
 * 4.Member Variable 인스턴스 변수, 객체 변수
 * 
 * Local Variable 
 * 1.메소드 안, 
 * 2.기본값이 없다. 따라서 반드시 초기화하고 사용해야함. 
 * 3.Stack 에 자리
 * 4.지역 변수 
 */

public class OperatorAppTest1 {

	public static void main(String[] args) {
		//local Variable 선언
		int i=5;
		int j=3;
		
		Operator o1 = new Operator();
		Operator o2 = new Operator();
		
		o1=o2; // 주소값이 o2로 동일해진다. 
		
		System.out.println("o1 주소값:"+o1);
		System.out.println("o1 주소값:"+o2);
		System.out.println(o1==o2); 
		
		System.out.println("연산자 % ::"+i %j  );
		System.out.println(i==j); //false
		System.out.println(i!=j); // true
		
		boolean flag = false;
		System.out.println(flag); //false
		System.out.println(!flag); //true
		
		int k=10;
		System.out.println(k++); //나중에 1씩 증가
		System.out.println(k);
		
		int m=10;
		System.out.println(++m); //먼저 1씩 증가 
		System.out.println(m);
		
		System.out.println(o1.test1()||o1.test2());
		
		
	}

}


// 클래스를 여러개 달아서 만들 때 public 의 경우 하나만 붙는다.
// 메인 메소드 앞에 붙여둔다.
// 또한 public 이 붙여진 이름의 class의 이름으로 저장되야함  
class Operator{
	public boolean test1() {
		System.out.println("test1() call....");
		return true;
	}
	
	public boolean test2() {
		System.out.println("test2() call....");
		return false;
	}
}

