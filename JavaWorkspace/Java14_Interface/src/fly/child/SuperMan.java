package fly.child;

import fly.Flyer;

public class SuperMan implements Flyer{
	
	@Override
	public void fly() {
		System.out.println("���۸��� ����.");
		System.out.println("�ü� "+SIZE+ "km");
	}

	@Override
	public void land() {
		System.out.println("���۸��� �����Ѵ�.");
	}

	@Override
	public void take_off() {
		System.out.println("���۸��� �̷��Ѵ�.");
	}
	
	public String stopBullet() {
		return "�Ѿ��� ���ߴ�";
	}

}
