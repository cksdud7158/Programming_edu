package pizza.child;

import pizza.parent.Pizza;

// �ڽ� Ŭ����
public class ApplePizza extends Pizza{
	
	public ApplePizza(int price, String storeName) {
		// �θ��� �ʵ尡 protected�� ���� �Ǿ super �Ȼ���ص� �ȴ�. 
		this.price = price;
		this.storeName = storeName;
	}
	
	@Override
	public void topping() {
		System.out.println("Apple Topping Pizza");
	}

}
