package fly.test;

import java.nio.charset.MalformedInputException;

import fly.Flyer;
import fly.child.AirPlane;
import fly.child.Bird;
import fly.child.SuperMan;
/*
 * 추상화가 들어가있으면 객체 생성이 안됨 
 * 객체 생성이 될려면 class에서 생성되야함 
 * 대신에 타입으로써는 가능 
 */
public class FlyAllTest {
	public static void main(String[] args) {
		//Flyer f1 = new Flyer(); // 오류 발생, 추상화되 있기때문
		//Flyer bird = new Bird(); // Polymorphism / 기존 bird에 추상화가 들어감 따라서 에러
		Flyer sp = new SuperMan();
		Flyer ap = new AirPlane();
		
		//String ret = ((Bird)bird).layEgg();
	//	System.out.println(ret);
		
	}
}
