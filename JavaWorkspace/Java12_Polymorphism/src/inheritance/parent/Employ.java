package inheritance.parent;

import inheritance.util.MyDate;

public class Employ {
	public static final double BASE_SALARY = 100.0; //상수값, 리턴 타입 앞에 무조건 static final 를 붙여야함
	private String name;
	private double salary;
	private MyDate birthDate;
	
	/*
	 * 생성자 Overloading
	 * - 객체의 인자값이 부족할 때 사용
	 */
	
	public Employ() {}// 기본 생성자
	
	//명시적 생성자 , 인자의 모든 값을 가지고있을 때 사용
	public Employ(String name, double salary, MyDate birthDate) {
		super();
		this.name = name;
		this.salary = salary;
		this.birthDate = birthDate;
	}
	//오버로딩 생성자
	public Employ(String name) {
		this(name, BASE_SALARY, new MyDate(1980,1,1));
	}
	
	//getter
	public String getDetails() {
		return name+","+salary+","+birthDate;
	}
/*
 *  this 
 *  1) 변수 앞에 붙이는 this 
 *  로컬 변수와 필드의 이름이 값을 때 둘을 구분하기 위해서 필드 아에 붙인다.
 *  2) 생성자 앞에 붙이는 this
 *  하나의 클래스에서 서로다른 생성자를 호출할 때 사용  
 */

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public MyDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(MyDate birthDate) {
		this.birthDate = birthDate;
	}

	public static double getBaseSalary() {
		return BASE_SALARY;
	}

	
}
