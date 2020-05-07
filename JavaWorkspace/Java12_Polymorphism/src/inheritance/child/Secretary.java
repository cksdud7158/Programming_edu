package inheritance.child;

import inheritance.parent.Employ;
import inheritance.util.MyDate;

// 자식, child, sub 클래스
public class Secretary extends Employ{
	private String nameOfBoss;//Field
	
	//생성자
	public Secretary(String name, double salary, MyDate birthDate, String nameOfBoss) { //자식 객체 생성 , 자식 객체가 생성되려면 반드시 부모 생성자 호출이 필수적, 이때 호출은 프로그램이 부모 기본 생성자를 호출함
		super(name, salary, birthDate); // 부모 생성자 호출
		this.nameOfBoss = nameOfBoss; 
	}
	
	//getter
	public String getDetails() {
		return super.getDetails()+","+nameOfBoss;
	}
	/*	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}*/
}
