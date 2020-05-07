package fly.child;

import fly.Flyer;

/*
 * Flyer �� ��ӹ��� �ڽ� Ŭ���� 
 * �������̽��� �θ�� �� �ڽ��� (Bird) �ݵ�� �θ� ���� ��� �߻� �޼ҵ带 �� �����ؾ߸� �Ѵ�.
 * Ŭ������ �������̽��� ���� �߻�ȭ
 * 
 * �������̽��� �߻�ȭ�θ� �̷�������Ѵ�. 
 * Ŭ������ ��üȭ �Ǿ��� ���� �߻��� �����ϸ� �ȵ�
 * 
 * �������̽��� ���� ��� ������ -> �������� �������̽��� �θ�� �� �� ����
 * �������̽��� �θ�� �������̽��� ����
 * 
 * �߻� �޼��� -> Ƽ��μ��� �������� �κ��� �θ�μ� ������ and Ÿ���� ������ ���� �ٸ� ����� ������ abstract�� ���
 *  		   ���� �������� sub ����� �ȹ���, �ڽ� Ŭ������ ��� ���� ����� �� �����ؾ��� 
 */
	public abstract class Bird implements Flyer { //abstract -> �κ��� �߻�ȭ
	
/*	@Override
	public void fly() {
		System.out.println("���� ����.");
	}*/

	@Override
	public void land() {
		System.out.println("���� �����Ѵ�.");
	}

	@Override
	public void take_off() {
		System.out.println("���� �̷��Ѵ�.");
	}
	
	public String layEgg() {
		return "���� ���";
	}

}
