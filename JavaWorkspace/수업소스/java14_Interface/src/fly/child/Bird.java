package fly.child;

import fly.Flyer;

/*
 * Flyer(�������̽�)�� ��ӹ��� �ڽ� Ŭ����..
 * �������̽��� �θ�� �� �ڽ��� (Bird) �ݵ�� �θ� ���� ��� �߻�޼ҵ带 �� �����ؾ߸� �Ѵ�
 */
public class Bird implements Flyer{
	@Override
	public void fly() {		
		System.out.println("���� ����..");
	}
	@Override
	public void land() {		
		System.out.println("���� �����Ѵ�..");
	}
	@Override
	public void take_off() {		
		System.out.println("���� �̷��Ѵ�..");
	}	
	
	public String layEggs() {
		return "���� ���";
	}
}









