package inheritance.child;

import inheritance.parent.Employ;
import inheritance.util.MyDate;

// 자식, child, sub 클래스
public class Manager extends Employ{
	private String dept;//Field
	/*
	 * 자식 객체를 생성할 때 부모가 먼저 존재해야만한다.
	 * 자식 생성자 {} 첫 라인에서 부모 생성자 호출이 반드시 일어나야한다.(위의 이유로) 
	 */
	//생성자
	public Manager(String name, double salary, MyDate birthDate, String dept) { //자식 객체 생성 , 자식 객체가 생성되려면 반드시 부모 생성자 호출이 필수적, 이때 호출은 프로그램이 부모 기본 생성자를 호출함
		super(name, salary, birthDate); // 부모 생성자 호출
		this.dept = dept; 
	}
	
	//getter
	public String getDetails() {
		return super.getDetails()+","+dept;
	}
	/*	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}*/

	public String getDept() {
		return dept;
	}

	public void changeDept(String dept) {
		this.dept = dept;
	}
	
	
}
