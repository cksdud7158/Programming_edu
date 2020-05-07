package oop.constructor.test;
/*
 * ���δٸ� ���� ��ü 3���� �������.
 * �׷��� ���� �ٸ� �ּҰ��� ��Ÿ������
 * ��ü�� ������ �� ������ �ȿ� ���ڰ��� �־����� �ʾұ� ������ 
 * ������� ���� �������ʴ� ����Ʈ ��ü�� �����Ǿ���. 
 * 
 * ���� �����ڸ� ���ؼ� ���� �Է��ϰ� ��ü�� �����ʰ� ���ÿ� ���� �������� ���� 
 */
import oop.constructor.Shirt;

public class ShirtTest {

	public static void main(String[] args) {
		/*Shirt roundT = new Shirt();
		Shirt jumpa = new Shirt();
		Shirt shortShirt = new Shirt();*/
		
		//�޸𸮿� �ö󰡼� �츮�� ����� �� �ִ� ��ü, Instance, ����������� �Ҵ� 
		Shirt roundT = new Shirt("����Ŭ��", true, 'B');
		Shirt jumpa = new Shirt("���׶�",true, 'B');
		Shirt shortShirt = new Shirt("aaa", true, 'W');
		//���� �ٸ� ���� ��ü�� ��������ٸ� Heap ������ ��ü 3���� �ε�Ǿ� ���� ���̰�
		//������ �ּҴ� ���� �ٸ��� ������ ���� ������ �ּҰ����� ���� �ٸ��� ���;��Ѵ�. 
		System.out.println(roundT);
		System.out.println(jumpa);
		System.out.println(shortShirt);
		
		System.out.println("+++++++++++++++++++++++");
		
		System.out.println(roundT.getDetails());
		System.out.println(jumpa.getDetails());
		System.out.println(shortShirt.getDetails());
	}

}
