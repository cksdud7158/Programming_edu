package fly.test;

import fly.Flyer;
import fly.child.AirPlane;
import fly.child.Bird;
import fly.child.SuperMan;

public class FlyerTest {
	public static void main(String[] args) {
		//Flyer f1 = new Flyer();
		//����������.
		Flyer bird = new Bird();
		Flyer ap = new AirPlane();
		Flyer sp = new SuperMan();
		
		//1.
		bird.fly(); //Virtual Mehtod Invocation����..�������̵��� �޼ҵ忡���� ��Ÿ��
		
		//2.
		String ret=((Bird) bird).layEggs();
		System.out.println(ret);

		
	}
}











