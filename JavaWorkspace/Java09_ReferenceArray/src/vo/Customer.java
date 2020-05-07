package vo;
/*
 * 상품을 구입하는 소비자에 대한 정보를 담고 있는 클래스..
 * 상품을 구매하는 고객
 * 상품을 구매하지 않은 고객
 * Product <------ Customer
 * ========================
 * 
 */
public class Customer {
	//필드 생성 
	private int ssn;
	private String name;
	private String address;
	private Product[] products; // Hasing
	
	//생성자 생성
	public Customer(int ssn, String name, String address) {
		super();
		this.ssn = ssn;
		this.name = name;
		this.address = address;
	}
	
	public void buyProducts(Product[] products) {
		this.products = products;
	}
	
	public int getSsn() {
		return ssn;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public Product[] getProducts() {
		return products;
	}
	
	public String getCustomer() {
		return ssn+", "+name+" , "+address;
	}
}
















