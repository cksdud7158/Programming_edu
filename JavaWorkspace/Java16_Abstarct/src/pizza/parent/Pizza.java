package pizza.parent;
/*
 * �߻� Ŭ������ �뵵
 * ::
 * 1. ���� ������ ���ڵ��� ���� ��, ���ڷμ��� �������� �κ�(�ʵ�,�޼���)�� �θ� ���� ������ �ڽĿ��� �״�� �����ְ� 
 * 2. �ݸ鿡 ���� �ٸ� ���ڰ� ��������� �������� �κ��� �߻� �޼ҵ�� �ڽĿ��� �����־ �ڽ��� ���ο� �µ��� ���� �����ϵ��� �Ѵ�. 
 * 
 * Access Modifier : public, private, protected(��� default�� ���� ����, ��� ������ public�� ���� ����� ����)
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
		return storeName+" "+price+"��";
	}

	public void dough() {
		System.out.println("���� ���װ� �Բ� ���츦 ����");
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
