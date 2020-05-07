package fly.child;

import fly.Flyer;

public class SuperMan implements Flyer{
	
	@Override
	public void fly() {
		System.out.println("수퍼맨이 난다.");
		System.out.println("시속 "+SIZE+ "km");
	}

	@Override
	public void land() {
		System.out.println("수퍼맨이 착륙한다.");
	}

	@Override
	public void take_off() {
		System.out.println("수퍼맨이 이륙한다.");
	}
	
	public String stopBullet() {
		return "총알을 멈추다";
	}

}
