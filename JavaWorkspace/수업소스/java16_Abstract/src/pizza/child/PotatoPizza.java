package pizza.child;
//�ڽ� Ŭ����...

import pizza.parent.Pizza;

public class PotatoPizza extends Pizza{
	
	public PotatoPizza(int price, String storeName) {
		//�θ��� �ʵ尡 protected�� �����Ǿ super �Ȼ���ص� �ȴ�.
		super();
		this.price = price;
		this.storeName = storeName;
	}	
	@Override
	public void topping() {
		System.out.println("Potato Topping Pizza....");		
	}

}
