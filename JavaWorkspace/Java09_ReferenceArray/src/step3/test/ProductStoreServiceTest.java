package step3.test;
// �׽�Ʈ Ŭ������ ���� : ���� ����ְ� �޼��带 ȣ���ϴ� ����

import service.ProductStoreService;
import vo.Product;

public class ProductStoreServiceTest {

	public static void main(String[] args) {
		ProductStoreService service = new ProductStoreService();
		
		Product[] pros = {
				new Product("Hp", 21500,2),
				new Product("Samsung", 230000, 3),
				new Product("LG", 500000,13),
				new Product("Hp", 5000000,2)
			};
		
		System.out.println("1. ��� ��ǰ�� maker�� ����մϴ�..");
		service.printAllProductMakers(pros);
		
		System.out.println("2. ��� ��ǰ�� �� ������ �޾ƿɴϴ�.");
		System.out.println(service.getTotalPrice(pros)+"��");
		
		System.out.println("3. 200,000�� �̻��� ��ǰ�Դϴ�.");
		service.printMorePrice(pros, 200000);
		
		System.out.println("4. ������ ȸ���� ��ǰ���Դϴ�.");
		Product[] products= service.getCertainMaker(pros, "HP");
		for(Product p: products) {
			if(p==null) continue;
			System.out.println(p.getMaker()+","+p.getPrice());
		}
	}

}
