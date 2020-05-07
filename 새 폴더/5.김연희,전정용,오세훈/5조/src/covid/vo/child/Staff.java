package covid.vo.child;

import covid.util.Fever;
import covid.vo.parent.Visitor;

public class Staff extends Visitor {
	private double salary;
	private String dept;
	
	public Staff() {}
	public Staff(String name, boolean mask, Fever fever , double salary, String dept) {
		super(name, mask, fever);
		this.salary = salary;
		this.dept = dept;
	}
	public Staff(String name, boolean mask, Fever fever, String symptom, double salary, String dept) {
		super(name, mask, fever, symptom);
		this.salary = salary;
		this.dept = dept;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	@Override
	public String toString() {
		return super.toString() + "\n상태 : 직원" + "\n월급 : " + salary + "만원" + "\n직무 : " + dept;
	}
}
