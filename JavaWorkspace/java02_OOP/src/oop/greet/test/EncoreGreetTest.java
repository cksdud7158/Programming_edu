package oop.greet.test;

import java.util.Scanner;

import oop.greet.EncoreGreet;

public class EncoreGreetTest {

	public static void main(String[] args) { //���� �޼ҵ�
		EncoreGreet en; //local ����, Temporary ����, Stack �� ����, �⺻���� ���� 
		en = new EncoreGreet(); // ��ü�� ���� = �޸𸮿� �÷� -> ��ü�� ���� ��Ҹ� �޸𸮿� �ø�(field, method)-> �ּҰ� �Ҵ�
		/*
		 * 1. �������� �ʱ�ȭ
		 * 2. �ּҰ� �Ҵ�
		 * 3. Stack ������ en ������ �ּҰ� �Ҵ�
		 * 4. ���� �߻�
		 */
		
		//����ó�� �ҽ��ڵ忡 ���� ���� �ϵ��ڵ����� �ʰ�
		// ����ÿ� ȭ��ܿ� Ű����� ���� �Է¹޾� ó���ǵ��� Scanner ��� 
		Scanner sc = new Scanner(System.in);
		System.out.println("�̸��� �Է��ϼ���");
		String scname =  sc.nextLine();
		en.name = scname;
		
		System.out.println("�޼����� �Է��ϼ���");
		String scmessage =  sc.nextLine();
		en.message = scmessage;

		en.sayHello();
	}

}
