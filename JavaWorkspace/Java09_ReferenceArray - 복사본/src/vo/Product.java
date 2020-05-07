package vo;
//상품에 대한 정보를 저장하는 VO클래스
//VO : Value Object -> 자료만 담는 객체 
//메서드가 있으면 안됨 
//DB와 연결될 것임 
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
