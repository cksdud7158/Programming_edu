package oop.programmer;

public class EncoreProg {
	public String name;
	public int age;
	public float salary;
	public int bonus;
	
	public void setProg(String n, int a, float s, int b) {
		name = n;
		age = a;
		salary =s;
		bonus = b;
	}
	public String getProg() {
		return name +"\t"+ age +"\t"+ salary +"\t"+bonus;
	}
	public float getAnnualSalary() {
		return 12*salary+bonus;
	}
}
