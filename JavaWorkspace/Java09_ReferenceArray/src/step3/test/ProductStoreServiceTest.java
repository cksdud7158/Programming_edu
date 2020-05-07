package step3.test;
// 테스트 클래스의 역할 : 값을 집어넣고 메서드를 호출하는 역할

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
		
		System.out.println("1. 모든 상품의 maker를 출력합니다..");
		service.printAllProductMakers(pros);
		
		System.out.println("2. 모든 상품의 총 가격을 받아옵니다.");
		System.out.println(service.getTotalPrice(pros)+"원");
		
		System.out.println("3. 200,000원 이상의 제품입니다.");
		service.printMorePrice(pros, 200000);
		
		System.out.println("4. 동일한 회사의 제품들입니다.");
		Product[] products= service.getCertainMaker(pros, "HP");
		for(Product p: products) {
			if(p==null) continue;
			System.out.println(p.getMaker()+","+p.getPrice());
		}
	}

}
