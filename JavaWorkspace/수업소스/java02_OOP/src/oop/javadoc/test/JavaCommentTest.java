package oop.javadoc.test;

import oop.javadoc.JavaComment;

/*
 * main() ������ ������ �ϴ� ����Ŭ����
 * ����.....
 * JavaComment ��ü�� ���� == �޸𸮿� �ø���. == �ı�(Member-Filed, Methoid)�� �޸𸮿� �ö󰣴�
 * 														|
 * 													JVM > Heap
 * ��ü ������ ���?    ����� ��ü�� ��ġ���� ������...1004
 */
public class JavaCommentTest {
	public static void main(String[] args) {
		JavaComment jc = new JavaComment();//1004
		//jc�� ��������...reference Variable
		System.out.println(jc);
		
		//jc��� �̸��� ��ü�� ������ ����?-->������, ����ҷ���
		//�ʵ���---> �� �Ҵ�
		//�޼ҵ� ��� --> ȣ��(ȣ���ؾ����� ����� �����Ѵ�)
		
		jc.name = "HaBaRee"; //�� �Ҵ�
		System.out.println(jc.scoreSum(100, 100)); //METHOD Calling
		
	}
}








