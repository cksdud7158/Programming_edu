package inheritance.test;

import inheritance.child.Manager;
import inheritance.parent.Employ;
import inheritance.util.MyDate;

public class EmployTest {

	public static void main(String[] args) {
		//부모 객체를 생성
		Employ e1 = new Employ("이수근");
		Employ e2 = new Employ("강호동",11000.0, new MyDate(1993,4,6));
		
		//자식 객체를 생성
		Manager m = new Manager("James",23000.0,new MyDate(1992, 2, 1),"개발부");
		
		System.out.println(m.getDetails());
		System.out.println(m.getDetails());
		System.out.println(m.getDetails());
	}
}
