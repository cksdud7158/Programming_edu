package inheritance.test;

import inheritance.child.Enginner;
import inheritance.child.Manager;
import inheritance.child.Secretary;
import inheritance.parent.Employ;
import inheritance.util.MyDate;

/*
 * ����������
 * ::
 * �ϳ��� ��ü ������ �������� ���� ����� ������ �ɷ� 
 * ::
 * �θ�Ÿ������ �ڽ� ��ü �����ϴ� ��
 * 
 * Virtual Method(������ �޼ҵ�,�ڽ�) Invocation ����
 * ��� + �������̵��� �޼ҵ忡���� ��Ÿ���� ���� 
 * 1) Compile ���� �޼ҵ� -- �θ��� �������� ȣ��/ Employ�� getDetail() ȣ��
 * 2) ���� ���� �޼ҵ� -- ���� �� �ڽ��� �������� ȣ�� ���� / �ڽ�.getDetail() ȣ��
 * 
 * Object Casting
 */
public class PolymorphismTest1 {
	public static void main(String[] args) {
		Employ e1 = new Employ("�̼���", 12000.0, new MyDate(1994, 3, 5));
		Manager m1 = new Manager("��ȣ��", 23000.0, new MyDate(1988, 4, 7),"ü����");
		Enginner eg1 = new Enginner("�ڳ���", 5000.0, new MyDate(1991, 1, 1),"R", 200.0);
		Secretary s1 = new Secretary("�ں���", 34000.0, new MyDate(1990, 9, 10), "��ȣ��");
		
		m1.changeDept("��ȹ��");
		
		System.out.println("==============������ ����մϴ�.========");
		System.out.println(e1.getDetails());
		System.out.println(m1.getDetails());
		System.out.println(eg1.getDetails());
		System.out.println(s1.getDetails());
		/////////////////////////////////////////////////////////////////////////////////////////////////
		//���������� ������� ��ü ����
		Employ e2 = new Manager("��ȣ��2", 23000.0, new MyDate(1988, 4, 7),"ü����"); //e2�� Ÿ���� Employ�̴�. 
		Employ e3 = new Enginner("�ڳ���2", 5000.0, new MyDate(1991, 1, 1),"R", 200.0);
		Employ e4 = new Secretary("�ں���2", 34000.0, new MyDate(1990, 9, 10), "��ȣ��");
		
		//e3.changeTech("�ڹ�");// �߰�, �ڽĸ��� �޼���, �θ� �޼��忣 ���� �̸� �ذ��ϱ� ���ؼ� �ڽ� �޼���� ĳ���� �ؾ���
		((Enginner) e3).changeTech("�ڹ�"); //Object Casting
		/*Enginner eg3 = (Enginner)e3; //Object Casting
		eg3.changeTech("Java");*/
		
		System.out.println("==============������ ����մϴ�.========");
		System.out.println(e2.getDetails());
		System.out.println(e3.getDetails());
		System.out.println(e4.getDetails());
		
	}
}



