package inheritance.test;

import inheritance.child.Enginner;
import inheritance.child.Manager;
import inheritance.child.Secretary;
import inheritance.parent.Employ;
import inheritance.service.PolymorphismService;
import inheritance.util.MyDate;

public class PolymorphismTest2 {
	public static void main(String[] args) {
		/////////////////////////////////////////////////////////////////////////////////////////////////
		//폴리몰피즘 방식으로 객체 생성
		Employ e2 = new Manager("강호동2", 23000.0, new MyDate(1988, 4, 7),"체육부"); //e2의 타입은 Employ이다. 
		Employ e3 = new Enginner("박나래2", 5000.0, new MyDate(1991, 1, 1),"R", 200.0);
		Employ e4 = new Secretary("박보검2", 34000.0, new MyDate(1990, 9, 10), "강호동");
		Employ e5 = new Manager("강호동3", 23000.0, new MyDate(1988, 4, 7),"체육부");
		
		//Heterogeneous Collection
		Employ [ ] emps = {e2, e3, e4, e5};
		
		PolymorphismService service =new PolymorphismService(); // 생성자 초기화
		service.handleEmpoly(emps); // 메서드 호출
		
		for(Employ e :emps) {
			System.out.println(e.getDetails());
		}
	}
}



