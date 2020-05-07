package vo;
//��ǰ�� ���� ������ �����ϴ� VOŬ����
//VO : Value Object -> �ڷḸ ��� ��ü 
//�޼��尡 ������ �ȵ� 
//DB�� ����� ���� 
public class Product {
	private String maker;
	private int price;
	private int count;
	
	public Product(String maker, int price, int count) {
		super();
		this.maker = maker;
		this.price = price;
		this.count = count;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	
	
}
