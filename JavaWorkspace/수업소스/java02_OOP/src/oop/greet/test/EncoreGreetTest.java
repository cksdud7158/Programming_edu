package oop.greet.test;

import java.util.Scanner;

import oop.greet.EncoreGreet;

public class EncoreGreetTest {
	public static void main(String[] args) {//����޼ҵ�
		EncoreGreet en = new EncoreGreet();
		
		//����ó�� �ҽ��ڵ忡 ���� ���� �ϵ��ڵ� ���� �ʰ�
		// ����ÿ� Ű����� �Է¹��� ���� ó���ϵ���...Scanner ���
		
		Scanner sc = new Scanner(System.in);
		System.out.println("�̸��� �Է��ϼ���>>>>");//��ä��
		String scName=sc.nextLine();
		en.name=scName;
		
		System.out.println("�޼����� �Է��ϼ���>>>>");//��ä��
		String scMsg=sc.nextLine();
		en.message = scMsg;
		en.sayHello();
	}
}





