package inheritance.child;

import inheritance.parent.Employ;
import inheritance.util.MyDate;

// �ڽ�, child, sub Ŭ����
public class Enginner extends Employ{
	private String tech;//Field
	private double bonus;
	
	//������
	public Enginner(String name, double salary, MyDate birthDate, String tech, double bonus) { //�ڽ� ��ü ���� , �ڽ� ��ü�� �����Ƿ��� �ݵ�� �θ� ������ ȣ���� �ʼ���, �̶� ȣ���� ���α׷��� �θ� �⺻ �����ڸ� ȣ����
		super(name, salary, birthDate); // �θ� ������ ȣ��
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
