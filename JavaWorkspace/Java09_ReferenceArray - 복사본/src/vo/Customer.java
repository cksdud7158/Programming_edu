package vo;
/*
 * ��ǰ�� �����ϴ� �Һ��ڿ� ���� ������ ����ִ� Ŭ����
 * ��ǰ�� �����ϴ� �� ����
 * ��ǰ�� �������� ���� ��
 * Product < ---------- Customer
 * -------------------------
 */
public class Customer {
	private int ssn;
	private String name;
	private String adress;
	
	private Product[] products;// �������� ������ ���� ����

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
