package pizza.child;
//�ڽ� Ŭ����...

import pizza.parent.Pizza;

public class BugogiPizza extends Pizza{
	
	public BugogiPizza(int price, String storeName) {
		//�θ��� �ʵ尡 protected�� �����Ǿ super �Ȼ���ص� �ȴ�.
		this.price = price;
		this.storeName = storeName;
	}	
	@Override
	public void topping() {
		System.out.println("Bugogi Topping Pizza....");		
	}

}
