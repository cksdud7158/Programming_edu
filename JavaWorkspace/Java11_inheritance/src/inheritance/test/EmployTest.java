package inheritance.test;

import inheritance.child.Manager;
import inheritance.parent.Employ;
import inheritance.util.MyDate;

public class EmployTest {

	public static void main(String[] args) {
		//�θ� ��ü�� ����
		Employ e1 = new Employ("�̼���");
		Employ e2 = new Employ("��ȣ��",11000.0, new MyDate(1993,4,6));
		
		//�ڽ� ��ü�� ����
		Manager m = new Manager("James",23000.0,new MyDate(1992, 2, 1),"���ߺ�");
		
		System.out.println(m.getDetails());
		System.out.println(m.getDetails());
		System.out.println(m.getDetails());
	}
}
