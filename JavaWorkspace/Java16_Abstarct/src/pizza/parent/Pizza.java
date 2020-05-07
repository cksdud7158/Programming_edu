package pizza.parent;
/*
 * 추상 클래스의 용도
 * ::
 * 1. 여러 종류의 피자들을 만들 때, 피자로서의 공통적인 부분(필드,메서드)은 부모가 가진 성질을 자식에게 그대로 물려주고 
 * 2. 반면에 서로 다른 피자가 만들어지는 결정적인 부분은 추상 메소드로 자식에게 물려주어서 자식이 본인에 맞도록 직접 구현하도록 한다. 
 * 
 * Access Modifier : public, private, protected(평소 default와 같은 상태, 상속 받으면 public와 같은 기능을 가짐)
 * Usage Modifier : abstract, static, final...etc
 */
public abstract class Pizza {
	protected int price;
	protected String storeName;
	
	public Pizza() {}
	
	public Pizza(int price, String storeName) {
		super();
		this.price = price;
		this.storeName = storeName;
	}
	
	//
	public void makePizza() {
		dough();
		topping();
		bake();
		cut();
		box();
	}
	
	@Override
	public String toString() {
		return storeName+" "+price+"원";
	}

	public void dough() {
		System.out.println("피자 반죽과 함께 도우를 빚다");
	}
	
	public void box() {
		System.out.println("Boxing");
	}
	
	public void bake() {
		System.out.println("baking");
	}
	
	public void cut() {
		System.out.println("cut to pizza");
	}
	
	public abstract void topping();
	
}
