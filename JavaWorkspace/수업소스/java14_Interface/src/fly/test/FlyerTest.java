package fly.test;

import fly.Flyer;
import fly.child.AirPlane;
import fly.child.Bird;
import fly.child.SuperMan;

public class FlyerTest {
	public static void main(String[] args) {
		//Flyer f1 = new Flyer();
		//폴리몰피즘.
		Flyer bird = new Bird();
		Flyer ap = new AirPlane();
		Flyer sp = new SuperMan();
		
		//1.
		bird.fly(); //Virtual Mehtod Invocation원리..오버라이딩된 메소드에서만 나타남
		
		//2.
		String ret=((Bird) bird).layEggs();
		System.out.println(ret);

		
	}
}











