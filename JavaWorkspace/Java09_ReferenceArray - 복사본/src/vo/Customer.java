package vo;
/*
 * 상품을 구입하는 소비자에 대한 정보를 담고있는 클래스
 * 상품을 구매하는 고객 정보
 * 상품을 구매하지 않은 고객
 * Product < ---------- Customer
 * -------------------------
 */
public class Customer {
	private int ssn;
	private String name;
	private String adress;
	
	private Product[] products;// 여러개를 구매할 떄도 있음

	public Customer(int ssn, String name, String adress) {
		this.ssn = ssn;
		this.name = name;
		this.adress = adress;
	}

	public void buyproducts(Product[] products) {
		this.products = products;
	}

	public int getSsn() {
		return ssn;
	}

	public String getName() {
		return name;
	}

	public String getAdress() {
		return adress;
	}

	public Product[] getProducts() {
		return products;
	}
	
	
	
	
}
