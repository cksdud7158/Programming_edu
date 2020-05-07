package step3.test;

import service.ProductStoreService;
import vo.Product;

public class ProductStoreServiceTest {
	public static void main(String[] args) {
		ProductStoreService service = new ProductStoreService();
		
		Product[ ] pros = {
				new Product("HP", 120000, 2),
				new Product("SAMSUNG", 230000, 3),
				new Product("LG", 500000, 13),
				new Product("HP", 5000000, 1)				
		};	
		
		System.out.println("1. ��� ��ǰ�� maker�� ����մϴ�...");
		service.printAllProductMaker(pros);
		
		System.out.println("2. ��� ��ǰ�� �Ѱ����� �޾ƿɴϴ�...");
		System.out.println(service.getTotalPrice(pros)+" ��");
		
		System.out.println("3. 20���� �̻��� ��ǰ�� �Դϴ�...");
		service.printMorePrice(pros, 200000);
				
		System.out.println("4. ������ ȸ���� ��ǰ�� �Դϴ�...");
		Product[ ] products=service.getCertainMaker(pros, "HP");
		for(Product p : products) { 
			if(p==null) continue;
			System.out.println(p.getMaker()+","+p.getPrice());
		}
	}
}






