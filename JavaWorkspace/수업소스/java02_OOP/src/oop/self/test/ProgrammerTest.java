package oop.self.test;

import oop.self.Programmer;

public class ProgrammerTest {

	public static void main(String[] args) {
		Programmer pro = new Programmer();
		System.out.println("======������ ����մϴ�.=======\n");
		pro.setProgrammer("Peter", 44, 30000.0F, 100);
		
		System.out.println(pro.getProgrammer());
		
		System.out.println("======����� ������....=======\n");
		System.out.println(pro.getAnnualSalary()+" ����");
	}
}
