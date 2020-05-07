package inheritance.parent;

import inheritance.util.MyDate;

//�θ�, Parent, Super Ŭ����...
public class Employee {
	public static final double BASE_SALARY = 100.0; //�����	
	private String name;
	private double salary;
	private MyDate birthDate;
	
	public Employee() {}
	public Employee(String name, double salary, MyDate birthDate) {
		super();
		this.name = name;
		this.salary = salary;
		this.birthDate = birthDate;
	}
	public Employee(String name) {
		this(name, BASE_SALARY, new MyDate(1980, 1, 1))	;
	}
	public String getDetails() {
		return name+","+salary+","+birthDate;
	}
	public static double getBaseSalary() {
		return BASE_SALARY;
	}
	public String getName() {
		return name;
	}
	public double getSalary() {
		return salary;
	}
	public MyDate getBirthDate() {
		return birthDate;
	}		
}

/*
this
1)�����տ� ���̴� this
   ���ú����� �ʵ��� �̸��� ������ ���� �����ϱ� ���ؼ� �ʵ�տ� ���δ�.
2)�����ھտ� ���̴� this
  �ϳ��� Ŭ�������� ���δٸ� �����ڸ� ȣ���Ҷ� ����
 */












