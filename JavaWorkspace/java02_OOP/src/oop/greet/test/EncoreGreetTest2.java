package oop.greet.test;

import oop.greet.EncoreGreet;

/*
 * EncoreTest1 ������ Field�� ���� ���������� �Է��ߴ�.
 * �׷��� Field�� ������ �þ�ٸ� ? �ʵ尡 20���� �ʰ��Ѵٸ�?
 * �̷� ��� ������ �ʵ忡 ���� �Է��ϴ� ����� ��ȿ������ 
 * 
 * �ذ�å 
 * : ��� Field�� ���� �ѹ��� �޾Ƽ� �Ҵ����ִ� Method�� ���� ����
 * EncoreTest2������ �� �Լ��� ȣ���ϴ� ����� ����غ���.  
 */
public class EncoreGreetTest2 {

	public static void main(String[] args) { //���� �޼ҵ�
		EncoreGreet en; //local ����, Temporary ����, Stack �� ����, �⺻���� ���� 
		en = new EncoreGreet(); // ��ü�� ���� = �޸𸮿� �÷� -> ��ü�� ���� ��Ҹ� �޸𸮿� �ø�(field, method)-> �ּҰ� �Ҵ�
		//EncoreGreet en = new EncoreGreet();
		
		en.setEncore("������", "����", 4,"java" );//Method Calling
		System.out.println(en.getEncore());
		en.sayHello();
	}

}
