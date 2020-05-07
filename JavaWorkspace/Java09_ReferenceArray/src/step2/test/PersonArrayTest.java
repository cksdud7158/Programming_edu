package step2.test;

import vo.Product;

public class PersonArrayTest {

	public static void main(String[] args) {
		//1.�迭�� ������ �ʱ�ȭ�� �ѹ���...
		Product[] pros = {
			new Product("Hp", 21500,2),
			new Product("Samsung", 230000, 3),
			new Product("LG", 500000,13)
		};
		//2. Product ��ǰ���� ����� ��� ...��ǰ��
		System.out.println("��ǰ ����Ŀ ������ ����մϴ�.");
		for(Product pro : pros) {
			System.out.println(pro.getMaker()+ " ");
		}
		//3. ��ǰ�� �߿��� ���ݴ밡 20������ ȣ���ϴ� ��ǰ�� ����Ŀ�� ������ ���
		for(Product pro : pros) {
			if(pro.getPrice()>200000) {
				System.out.print(pro.getMaker());
			}
		}
		//4. ��ü ��ǰ�� �� ������ �� ���
		int sum =0;
		for(Product pro : pros) {
			sum =sum+pro.getPrice();
		}
		System.out.println("�� ������ : "+sum);
	
	}
}