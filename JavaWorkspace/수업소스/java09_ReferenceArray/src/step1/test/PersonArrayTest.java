package step1.test;

import vo.Product;

public class PersonArrayTest {
	public static void main(String[] args) {
		//1. Person Ÿ���� �迭�� ����...����...p..������� 3
		Product[ ] p = new Product[3];
		
		//2. for���� �̿��ؼ� ������ �迭 �׸� ����ִ� ���� ���
		for(Product person : p)
			System.out.print(person+" "); //null null null
		
		//3. �迭�� �ּҰ�
		System.out.println("====�迭�� �ּҰ� =====");
		System.out.println(p);
		
		//4. ClassType �迭�� �ʱ�ȭ----��ü�� ������ ����.
		//Person Ÿ���� �迭....PersonŸ������ ������� ��ü
		p[0] = new Product("HP", 120000, 2);
		p[1] = new Product("SAMSUNG", 230000, 3);
		p[2] = new Product("LG", 500000, 13);
		
		/*
		 * �迭 ������ ����ִ� ��ǰ�� ������ ���
		 */
		for(Product pro : p) {
			System.out.print(pro+" ");
		}
		System.out.println("\n===��ǰ���� �����Դϴ�======");
		for(Product pro : p) {
			System.out.println(pro.getMaker()+", "+pro.getPrice());
		}		
	}
}







