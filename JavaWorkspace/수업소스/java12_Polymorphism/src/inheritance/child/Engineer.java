package inheritance.child;

import inheritance.parent.Employee;
import inheritance.util.MyDate;

//�ڽ�, Child, Sub Ŭ����..
public class Engineer extends Employee{
	private String tech;
	private double bonus;
	
	public Engineer(String name, double salary, MyDate birthDate,String tech, double bonus) {
		super(name,salary,birthDate);
		this.tech = tech;
		this.bonus = bonus;
	}
	
	
	public void changeTech(String tech) {
		this.tech = tech;
	}

	//method....1.�״�� �����޴´� 2. ��ģ��
	public String getDetails() {
		return super.getDetails()+","+tech+","+bonus;//Employee�� getDetails()ȣ��
	}


	public String getTech() {
		return tech;
	}


	public double getBonus() {
		return bonus;
	}
	
	
}









