package inheritance.child;

import inheritance.parent.Employee;
import inheritance.util.MyDate;

//자식, Child, Sub 클래스..
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

	//method....1.그대로 물려받는다 2. 고친다
	public String getDetails() {
		return super.getDetails()+","+tech+","+bonus;//Employee의 getDetails()호출
	}


	public String getTech() {
		return tech;
	}


	public double getBonus() {
		return bonus;
	}
	
	
}









