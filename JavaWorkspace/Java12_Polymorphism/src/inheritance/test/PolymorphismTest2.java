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
		//���������� ������� ��ü ����
		Employ e2 = new Manager("��ȣ��2", 23000.0, new MyDate(1988, 4, 7),"ü����"); //e2�� Ÿ���� Employ�̴�. 
		Employ e3 = new Enginner("�ڳ���2", 5000.0, new MyDate(1991, 1, 1),"R", 200.0);
		Employ e4 = new Secretary("�ں���2", 34000.0, new MyDate(1990, 9, 10), "��ȣ��");
		Employ e5 = new Manager("��ȣ��3", 23000.0, new MyDate(1988, 4, 7),"ü����");
		
		//Heterogeneous Collection
		Employ [ ] emps = {e2, e3, e4, e5};
		
		PolymorphismService service =new PolymorphismService(); // ������ �ʱ�ȭ
		service.handleEmpoly(emps); // �޼��� ȣ��
		
		for(Employ e :emps) {
			System.out.println(e.getDetails());
		}
	}
}



