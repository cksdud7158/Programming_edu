package step4.test;
// �׽�Ʈ Ŭ������ ���� : ���� ����ְ� �޼��带 ȣ���ϴ� ����

import vo.*;
import service.OutletStoreService;

public class OutletStoreServiceTest {

	public static void main(String[] args) {
		//���� ���� ���� 2�� ����
		Customer[] customers =new Customer[3];
		customers[0]= new Customer(123, "�̳���", "��赿");
		customers[1]= new Customer(321, "������", "���ʵ�");
		customers[2]= new Customer(444, "����", "��赿");
		
		//���� ������ ��ǰ�� ����
		Product[] pros1 = {
				new Product("�����", 8000, 2),
				new Product("����ƾ ��Ǫ", 18000, 1),
				new Product("�ް�", 5000, 1)
			};
		Product[] pros2 = {
				new Product("�ƽ�Ŀ��", 32000, 3),
				new Product("���İ�Ƽ �ҽ�", 55000, 1),
				new Product("�ް�", 6000, 2),
				new Product("���� û����", 450000, 1)
			};
		
		//3. �̳����� Ŀ��, ���İ�Ƽ �ҽ�, �ް�, ����û�⸦ ����  | ������ �����, ����ƾ ��Ǫ, �ް��� �����ϵ��� ����
		//�� �κп��� Customer�� Product���� Hasing �� �Ͼ��. 
		customers[0].buyproducts(pros2);
		customers[1].buyproducts(pros1);
		
		//4. service ��ü�� ����, �޼ҵ带 ȣ�� 
		
		OutletStoreService service= new OutletStoreService();
	
		
		
	}

}
