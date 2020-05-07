package vo;
/*
 * ��ǰ�� �����ϴ� �Һ��ڿ� ���� ������ ��� �ִ� Ŭ����..
 * ��ǰ�� �����ϴ� ��
 * ��ǰ�� �������� ���� ��
 * Product <------ Customer
 * ========================
 * 
 */
public class Customer {
	//�ʵ� ���� 
	private int ssn;
	private String name;
	private String address;
	private Product[] products; // Hasing
	
	//������ ����
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
















