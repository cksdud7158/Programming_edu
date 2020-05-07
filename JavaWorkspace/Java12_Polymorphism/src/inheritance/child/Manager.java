package inheritance.child;

import inheritance.parent.Employ;
import inheritance.util.MyDate;

// �ڽ�, child, sub Ŭ����
public class Manager extends Employ{
	private String dept;//Field
	/*
	 * �ڽ� ��ü�� ������ �� �θ� ���� �����ؾ߸��Ѵ�.
	 * �ڽ� ������ {} ù ���ο��� �θ� ������ ȣ���� �ݵ�� �Ͼ���Ѵ�.(���� ������) 
	 */
	//������
	public Manager(String name, double salary, MyDate birthDate, String dept) { //�ڽ� ��ü ���� , �ڽ� ��ü�� �����Ƿ��� �ݵ�� �θ� ������ ȣ���� �ʼ���, �̶� ȣ���� ���α׷��� �θ� �⺻ �����ڸ� ȣ����
		super(name, salary, birthDate); // �θ� ������ ȣ��
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
