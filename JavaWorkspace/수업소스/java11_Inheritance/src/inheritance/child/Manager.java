package inheritance.child;

import inheritance.parent.Employee;
import inheritance.util.MyDate;

//�ڽ�, Child, Sub Ŭ����..
public class Manager extends Employee{
	private String dept;
	
	public Manager(String name, double salary, MyDate birthDate,String dept) {
		super(name,salary,birthDate);
		this.dept = dept;
	}
	//method....1.�״�� �����޴´� 2. ��ģ��
	public String getDetails() {
		return super.getDetails()+","+dept;//Employee�� getDetails()ȣ��
	}
}






