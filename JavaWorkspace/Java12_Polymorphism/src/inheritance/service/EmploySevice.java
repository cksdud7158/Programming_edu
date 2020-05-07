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
	//이름을 인자값으로 받고 맞는 정보 찾기
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
			Enginner eg = (Enginner)e; //오브젝트 캐스팅
		annualSalary = (int)(eg.getSalary()*12 + eg.getBonus());
		}
		return annualSalary;
	}
	//모든 직원의 연봉을 합한 값
	public int getTotalCoast(Employ[] ea) {
		int total=0;
		for(Employ e : ea) {
			total += getAnnualSalary(e);
		}
		return total;
	}
}
