package inheritance.child;

import inheritance.parent.Employee;
import inheritance.util.MyDate;

//�ڽ�, Child, Sub Ŭ����..
public class Secretary extends Employee{
	private String nameOfBoss;
	
	public Secretary(String name, double salary, MyDate birthDate,String nameOfBoss) {
		super(name,salary,birthDate);
		this.nameOfBoss = nameOfBoss;
	}
	//method....1.�״�� �����޴´� 2. ��ģ��
	public String getDetails() {
		return super.getDetails()+","+nameOfBoss;//Employee�� getDetails()ȣ��
	}
}






