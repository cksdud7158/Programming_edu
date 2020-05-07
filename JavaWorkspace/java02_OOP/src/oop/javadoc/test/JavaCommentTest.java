package oop.javadoc.test;
/*
 * main() ������ �����ϴ� ���� Ŭ����
 * JavaComment ��ü �����Ѵ� = ��ü�� ���� = �޸𸮿� �ø���. = Member(fieldm, method)�� �޸𸮿� �ö󰣴�.-> JVM �Ʒ� Heap�� �ּ� ����
 * -> new �� ���� �����Ǵ� Member�� Heap�� �ö�
 * ��ü ������ ��� -> �ּ� �Ҵ� ( ����� ��ü�� ��ġ���� ������)
 *  */
import oop.javadoc.JavaComment;

public class JavaCommentTest {

	public static void main(String[] args) {
		JavaComment jc = new JavaComment();
		// jc�� ���� ����(Reference Variable)�� �θ�(�ּҰ��� ������)
		System.out.println(jc);
		
		//jc ��� �̸��� ��ü�� ������ ���� -> ����ϱ� ���� 
		// �ʵ� ��� -> �� �Ҵ�
		// �޼ҵ� ��� -> ȣ��(ȣ���ؾ����� ����� �����Ѵ�.)
		
		jc.name = "Ryan"; //�� �Ҵ�
		System.out.println(jc.scoreSum(100, 100));   //Method Calling
		
	}

}
