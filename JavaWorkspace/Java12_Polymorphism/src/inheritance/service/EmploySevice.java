package inheritance.service;

import inheritance.child.Enginner;
import inheritance.parent.Employ;

public class EmploySevice {
	public void printInfo(Employ e) {
		System.out.println(e.getDetails());
	}
	public void printAllInfo(Employ[] ea) {
		for(Employ e :ea) {
			System.out.println(e.getDetails());
		}
	}
	//�̸��� ���ڰ����� �ް� �´� ���� ã��
	public Employ findEmployByName(Employ[] ea, String name) {
		Employ emp =null;
		for(Employ e :ea) {
			if(e.getName().equals(name)) {
				emp= e;
			}
		}
		return emp;
	}
	public int getAnnualSalary(Employ e) {
		int annualSalary =0;
		annualSalary = (int)(e.getSalary()*12);
		if(e instanceof Enginner) { //instance of
			Enginner eg = (Enginner)e; //������Ʈ ĳ����
		annualSalary = (int)(eg.getSalary()*12 + eg.getBonus());
		}
		return annualSalary;
	}
	//��� ������ ������ ���� ��
	public int getTotalCoast(Employ[] ea) {
		int total=0;
		for(Employ e : ea) {
			total += getAnnualSalary(e);
		}
		return total;
	}
}
