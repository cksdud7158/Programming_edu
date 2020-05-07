package inheritance.child;

import inheritance.parent.Employ;
import inheritance.util.MyDate;

// �ڽ�, child, sub Ŭ����
public class Secretary extends Employ{
	private String nameOfBoss;//Field
	
	//������
	public Secretary(String name, double salary, MyDate birthDate, String nameOfBoss) { //�ڽ� ��ü ���� , �ڽ� ��ü�� �����Ƿ��� �ݵ�� �θ� ������ ȣ���� �ʼ���, �̶� ȣ���� ���α׷��� �θ� �⺻ �����ڸ� ȣ����
		super(name, salary, birthDate); // �θ� ������ ȣ��
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
