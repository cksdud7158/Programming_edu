package inheritance.parent;

import inheritance.util.MyDate;

public class Employ {
	public static final double BASE_SALARY = 100.0; //�����, ���� Ÿ�� �տ� ������ static final �� �ٿ�����
	private String name;
	private double salary;
	private MyDate birthDate;
	
	/*
	 * ������ Overloading
	 * - ��ü�� ���ڰ��� ������ �� ���
	 */
	
	public Employ() {}// �⺻ ������
	
	//����� ������ , ������ ��� ���� ���������� �� ���
	public Employ(String name, double salary, MyDate birthDate) {
		super();
		this.name = name;
		this.salary = salary;
		this.birthDate = birthDate;
	}
	//�����ε� ������
	public Employ(String name) {
		this(name, BASE_SALARY, new MyDate(1980,1,1));
	}
	
	//getter
	public String getDetails() {
		return name+","+salary+","+birthDate;
	}
/*
 *  this 
 *  1) ���� �տ� ���̴� this 
 *  ���� ������ �ʵ��� �̸��� ���� �� ���� �����ϱ� ���ؼ� �ʵ� �ƿ� ���δ�.
 *  2) ������ �տ� ���̴� this
 *  �ϳ��� Ŭ�������� ���δٸ� �����ڸ� ȣ���� �� ���  
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
