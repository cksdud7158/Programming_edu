package fly.test;

import java.nio.charset.MalformedInputException;

import fly.Flyer;
import fly.child.AirPlane;
import fly.child.Bird;
import fly.child.SuperMan;
/*
 * �߻�ȭ�� �������� ��ü ������ �ȵ� 
 * ��ü ������ �ɷ��� class���� �����Ǿ��� 
 * ��ſ� Ÿ�����ν�� ���� 
 */
public class FlyAllTest {
	public static void main(String[] args) {
		//Flyer f1 = new Flyer(); // ���� �߻�, �߻�ȭ�� �ֱ⶧��
		//Flyer bird = new Bird(); // Polymorphism / ���� bird�� �߻�ȭ�� �� ���� ����
		Flyer sp = new SuperMan();
		Flyer ap = new AirPlane();
		
		//String ret = ((Bird)bird).layEgg();
	//	System.out.println(ret);
		
	}
}
