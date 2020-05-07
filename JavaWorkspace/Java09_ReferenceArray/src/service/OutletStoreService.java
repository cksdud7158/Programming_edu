package service;
/*
 * ��ǰ�� �����ϴ� ��, ������ ������ ��ǰ�� ���� ��ɵ��� �ٷ�� ���� Ŭ����...
 */

import vo.Customer;
import vo.Product;

public class OutletStoreService {
	int prosize = 4; //�ʵ� ����
	int custsize = 3;
	
	public String[ ] getAllProductMaker(Customer vo) {
		String[ ] temp = new String[prosize]; //�ӽ� �迭 ������ �ʱ�ȭ 
		Product[ ] pros=vo.getProducts(); 
		int cnt = 0;
		for(Product p : pros) {			
			temp[cnt++] = p.getMaker();
		}
		return temp;
	}

	
	public Customer[ ] getAllCustomer(Customer[ ] custs) {
		Customer[ ] cs = new Customer[custsize];
		int cnt = 0;
		for(Customer c : custs) {
			cs[cnt++] = c;
		}
		return cs;
	}
	
	public Customer getACustomer(Customer[ ] custs, int ssn) {
		Customer cust = null;
		for(Customer c : custs) {
			if(c.getSsn()==ssn) cust = c;			
		}
		return cust;
	}
	
	public int maxPriceProduct(Customer c) { //���ϰ� int �ְ��� ����, ���ڰ� �� ����
		int max = 0;
		System.out.println(c.getName()+" ���� �����Ͻ� �ְ� ��ǰ��....");
		Product[ ] pros = c.getProducts();
		for(Product p : pros) {
			if(p.getPrice()>max) max = p.getPrice();
		}
		return max;
	}
	//�߰�
	public int avgPrice(Customer c) {
		int total = 0;		
		Product[ ] pros = c.getProducts();
		for(Product p : pros) {
			total += p.getPrice();
		}
		return total/pros.length;
	}
	public Product[ ] getMoreAvgProduct(Customer c) {
		Product[ ] temp = new Product[prosize];
		Product[ ] pros=c.getProducts();
		int cnt = 0;
		for(Product p : pros) {
			if(p.getPrice()>=avgPrice(c)) 
				temp[cnt++] = p;			
		}
		return temp;
	}
}

/*
  getAllProductMaker()
  getAllCustomer()
  getACustomer()
  maxPriceProduct()
  getMoreAvgProduct();Ư���� ���� ������ ��ǰ�� �߿���
 
*/
