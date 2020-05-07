package inheritance.child;

import inheritance.parent.Employee;
import inheritance.util.MyDate;

//자식, Child, Sub 클래스..
public class Secretary extends Employee{
	private String nameOfBoss;
	
	public Secretary(String name, double salary, MyDate birthDate,String nameOfBoss) {
		super(name,salary,birthDate);
		this.nameOfBoss = nameOfBoss;
	}
	//method....1.그대로 물려받는다 2. 고친다
	public String getDetails() {
		return super.getDetails()+","+nameOfBoss;//Employee의 getDetails()호출
	}
}






