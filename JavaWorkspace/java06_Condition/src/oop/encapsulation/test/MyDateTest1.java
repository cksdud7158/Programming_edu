package oop.encapsulation.test;
import java.util.Scanner;

/*
 * ��ĳ�� ��ü�� ���ؼ� ���� ��¥�� �Է¹ް� 
 * �������� ������ *�� *�� �Դϴ�. �� ���
 * 
 * ���� �߸��� ���̳� ��¥�� �Էµ� ��쿡�� 
 * �߸��� ��¥�Դϴ�.
 * ���
 */
import oop.encapsulation.MyDate;

public class MyDateTest1 {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		MyDate md =new MyDate();
		
		System.out.println("�� �Է�>>");
		int month =sc.nextInt();
		System.out.println("��¥ �Է�>>");
		int day =sc.nextInt();
		
		md.setMonth(month);
		md.setDay(day);
		
		System.out.println("������"+md.getMonth()+"��"+md.getDay()+"�� �Դϴ�.");
		
	}

}
