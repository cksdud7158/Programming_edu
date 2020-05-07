package step4.test;
// 테스트 클래스의 역할 : 값을 집어넣고 메서드를 호출하는 역할

import vo.*;
import service.OutletStoreService;

public class OutletStoreServiceTest {

	public static void main(String[] args) {
		//고객을 먼저 생성 2명만 생성
		Customer[] customers =new Customer[3];
		customers[0]= new Customer(123, "이나영", "방배동");
		customers[1]= new Customer(321, "김태희", "서초동");
		customers[2]= new Customer(444, "원빈", "방배동");
		
		//고객이 구매한 상품들 정보
		Product[] pros1 = {
				new Product("진라면", 8000, 2),
				new Product("엘라스틴 샴푸", 18000, 1),
				new Product("달걀", 5000, 1)
			};
		Product[] pros2 = {
				new Product("맥심커피", 32000, 3),
				new Product("스파게티 소스", 55000, 1),
				new Product("달걀", 6000, 2),
				new Product("공기 청정기", 450000, 1)
			};
		
		//3. 이나영이 커피, 스파게티 소스, 달걀, 공기청기를 구매  | 김태희가 진라면, 엘라스틴 샴푸, 달걀을 구매하도록 연결
		//이 부분에서 Customer와 Product와의 Hasing 이 일어난다. 
		customers[0].buyproducts(pros2);
		customers[1].buyproducts(pros1);
		
		//4. service 객체를 생성, 메소드를 호출 
		
		OutletStoreService service= new OutletStoreService();
	
		
		
	}

}
