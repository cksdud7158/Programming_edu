package fly.child;

import fly.Flyer;

//
public class AirPlane implements Flyer{
	@Override
	public void fly() {
		System.out.println("����� ����.");		
	}
	@Override
	public void land() {
		System.out.println("����� land.");		
	}
	@Override
	public void take_off() {
		System.out.println("����� take_off.");		
	}
}
