package inheritance.test;

import inheritance.child.Engineer;
import inheritance.child.Manager;
import inheritance.child.Secretary;
import inheritance.parent.Employee;
import inheritance.util.MyDate;

/*
 * ����������
 * ::
 * poly + morphism
 * ::
 * �ϳ��� ��ü������ �������� ���� ����� ������ �ɷ�
 * ::
 * �θ�Ÿ������ �ڽİ�ü �����ϴ� ��
 * 
 * Virtual Methods(�ڽ��� �޼ҵ�) Invocation ����
 * : ��� + �������̵��� �޼ҵ忡���� ��Ÿ���� ����
 * 1) ������ ���� �޼ҵ� -- Employee�� getDetails()�� ȣ��
 * 2) ���� ���� �޼ҵ� -- �ڽ��� getDetails()�� ȣ��
 * 
 * Object Casing
 */
public class PolymorphismTest1 {
	public static void main(String[] args) {
			Employee e1 =new Employee("�̼���", 12000.0, new MyDate(1975, 1, 1));
			Manager m1 = new Manager("��ȣ��", 23000.0, new MyDate(1972, 11, 1), "ü����");
			Engineer eg1 = new Engineer("�ڳ���", 56000.0, new MyDate(1989, 3, 1), "R", 200.0);
			Secretary s1 = new Secretary("�ں���", 34000.0, new MyDate(1990, 3, 1), "��ȣ��");
			
			m1.changeDept("��ȹ��");
			
			System.out.println("=========== ������ ����մϴ�.===============");
			System.out.println(e1.getDetails());
			System.out.println(m1.getDetails());
			System.out.println(eg1.getDetails());
			System.out.println(s1.getDetails());
			
			////////////////////////////////////////////////////////////////////////////
			System.out.println("=========== Polymorphisim ������� ��ü ����===============");
			Employee e2 = new Manager("��ȣ��2", 23000.0, new MyDate(1972, 11, 1), "ü����");
			Employee e3 = new Engineer("�ڳ���2", 56000.0, new MyDate(1989, 3, 1), "R", 200.0);
			Employee e4 = new Secretary("�ں���2", 34000.0, new MyDate(1990, 3, 1), "��ȣ��");
			
			//�߰�
			((Engineer) e3).changeTech("�ڹ�");
			
			//Object Casting
			/*Engineer eg3 = (Engineer)e3;
			eg3.changeTech("Java");*/
			
			System.out.println("=========== ������ ����մϴ�2.===============");
			System.out.println(e2.getDetails());
			System.out.println(e3.getDetails());
			System.out.println(e4.getDetails());
	}
}












