package inheritance.test;

import inheritance.child.Enginner;
import inheritance.child.Manager;
import inheritance.child.Secretary;
import inheritance.parent.Employ;
import inheritance.util.MyDate;

/*
 * 폴리몰피즘
 * ::
 * 하나의 객체 변수가 여러가지 모양과 모습을 가지는 능력 
 * ::
 * 부모타입으로 자식 객체 생성하는 것
 * 
 * Virtual Method(가상의 메소드,자식) Invocation 원리
 * 상속 + 오버라이딩된 메소드에서만 나타나는 성질 
 * 1) Compile 시점 메소드 -- 부모의 시점에서 호출/ Employ의 getDetail() 호출
 * 2) 실행 시점 메소드 -- 실행 시 자식의 시점에서 호출 진행 / 자식.getDetail() 호출
 * 
 * Object Casting
 */
public class PolymorphismTest1 {
	public static void main(String[] args) {
		Employ e1 = new Employ("이수근", 12000.0, new MyDate(1994, 3, 5));
		Manager m1 = new Manager("강호동", 23000.0, new MyDate(1988, 4, 7),"체육부");
		Enginner eg1 = new Enginner("박나래", 5000.0, new MyDate(1991, 1, 1),"R", 200.0);
		Secretary s1 = new Secretary("박보검", 34000.0, new MyDate(1990, 9, 10), "강호동");
		
		m1.changeDept("기획부");
		
		System.out.println("==============정보를 출력합니다.========");
		System.out.println(e1.getDetails());
		System.out.println(m1.getDetails());
		System.out.println(eg1.getDetails());
		System.out.println(s1.getDetails());
		/////////////////////////////////////////////////////////////////////////////////////////////////
		//폴리몰피즘 방식으로 객체 생성
		Employ e2 = new Manager("강호동2", 23000.0, new MyDate(1988, 4, 7),"체육부"); //e2의 타입은 Employ이다. 
		Employ e3 = new Enginner("박나래2", 5000.0, new MyDate(1991, 1, 1),"R", 200.0);
		Employ e4 = new Secretary("박보검2", 34000.0, new MyDate(1990, 9, 10), "강호동");
		
		//e3.changeTech("자바");// 추가, 자식만의 메서드, 부모 메서드엔 없음 이를 해결하기 위해선 자식 메서드로 캐스팅 해야함
		((Enginner) e3).changeTech("자바"); //Object Casting
		/*Enginner eg3 = (Enginner)e3; //Object Casting
		eg3.changeTech("Java");*/
		
		System.out.println("==============정보를 출력합니다.========");
		System.out.println(e2.getDetails());
		System.out.println(e3.getDetails());
		System.out.println(e4.getDetails());
		
	}
}



