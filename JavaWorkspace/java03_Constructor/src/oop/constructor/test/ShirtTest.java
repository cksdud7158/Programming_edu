package oop.constructor.test;
/*
 * 서로다른 셔츠 객체 3개를 만들었다.
 * 그래서 서로 다른 주소값을 나타내지만
 * 객체가 생성될 때 생성자 안에 인자값을 넣어주지 않았기 때문에 
 * 명시적인 값을 가지지않는 디폴트 객체로 생성되었다. 
 * 
 * 따라서 생서자를 통해서 값을 입력하고 객체가 생성됨과 동시에 값을 가지도록 수정 
 */
import oop.constructor.Shirt;

public class ShirtTest {

	public static void main(String[] args) {
		/*Shirt roundT = new Shirt();
		Shirt jumpa = new Shirt();
		Shirt shortShirt = new Shirt();*/
		
		//메모리에 올라가서 우리가 사용할 수 있는 객체, Instance, 명시적값으로 할당 
		Shirt roundT = new Shirt("유니클로", true, 'B');
		Shirt jumpa = new Shirt("베네똥",true, 'B');
		Shirt shortShirt = new Shirt("aaa", true, 'W');
		//서로 다른 셔츠 객체가 만들어졌다면 Heap 영역에 객체 3개가 로드되어 있을 것이고
		//각각의 주소는 서로 다르기 때문에 참조 변수의 주소값들은 서로 다르게 나와야한다. 
		System.out.println(roundT);
		System.out.println(jumpa);
		System.out.println(shortShirt);
		
		System.out.println("+++++++++++++++++++++++");
		
		System.out.println(roundT.getDetails());
		System.out.println(jumpa.getDetails());
		System.out.println(shortShirt.getDetails());
	}

}
