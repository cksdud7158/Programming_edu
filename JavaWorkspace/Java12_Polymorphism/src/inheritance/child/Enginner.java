package inheritance.child;

import inheritance.parent.Employ;
import inheritance.util.MyDate;

// 자식, child, sub 클래스
public class Enginner extends Employ{
	private String tech;//Field
	private double bonus;
	
	//생성자
	public Enginner(String name, double salary, MyDate birthDate, String tech, double bonus) { //자식 객체 생성 , 자식 객체가 생성되려면 반드시 부모 생성자 호출이 필수적, 이때 호출은 프로그램이 부모 기본 생성자를 호출함
		super(name, salary, birthDate); // 부모 생성자 호출
		this.tech = tech;
		this.bonus = bonus;
	}
	
	public void changeTech(String tech) {
		this.tech = tech;
	}



	public String getTech() {
		return tech;
	}

	public void setTech(String tech) {
		this.tech = tech;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	//getter
	public String getDetails() {
		return super.getDetails()+","+tech+","+bonus;
	}
	/*	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}*/
}
