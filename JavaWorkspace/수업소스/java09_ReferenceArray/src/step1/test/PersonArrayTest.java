package step1.test;

import vo.Product;

public class PersonArrayTest {
	public static void main(String[] args) {
		//1. Person 타입의 배열을 선언...생성...p..사이즈는 3
		Product[ ] p = new Product[3];
		
		//2. for문을 이용해서 각각의 배열 항목에 들어있는 값을 출력
		for(Product person : p)
			System.out.print(person+" "); //null null null
		
		//3. 배열의 주소값
		System.out.println("====배열의 주소값 =====");
		System.out.println(p);
		
		//4. ClassType 배열의 초기화----객체가 값으로 들어간다.
		//Person 타입의 배열....Person타입으로 만들어진 객체
		p[0] = new Product("HP", 120000, 2);
		p[1] = new Product("SAMSUNG", 230000, 3);
		p[2] = new Product("LG", 500000, 13);
		
		/*
		 * 배열 각각에 들어있는 제품의 정보를 출력
		 */
		for(Product pro : p) {
			System.out.print(pro+" ");
		}
		System.out.println("\n===제품들의 정보입니다======");
		for(Product pro : p) {
			System.out.println(pro.getMaker()+", "+pro.getPrice());
		}		
	}
}







