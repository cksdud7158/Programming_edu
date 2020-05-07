package service;

import vo.Product;

/*
 * �پ��� ��ǰ���� �ٷ�� ����� ��Ƴ��� ���� Ŭ����
 * �� Ŭ�������� �ٷ�� ��ɵ�...
 * 1) �پ��� ��ǰ���� maker�� ���
 * 2) ��ǰ���� �� �ݾ��� ����
 * 3) ��ǰ���� ��հ��� ����
 * 4) Ư�� �ݾ� �̻�Ǵ� ��ǰ�� ������ ���
 * 5) Ư�� ȸ�� ��ǰ�� �����ϴ� ���
 */
//���񽺴� vo�� hasing �ϰ� �ִ�. vo�� �޼����� ���ڰ����� ������ �ִ�. 

public class ProductStoreService {
	public void printAllProductMakers(Product[] pros) {
		for(Product pro : pros) {
			System.out.println(pro.getMaker());
		}
	}
	public int getTotalPrice(Product[] pros) {
		int total = 0;
		for(Product pro : pros) {
			total += pro.getPrice()*pro.getCount();
		}
		return total;
	}
	public int getAveragePrice(Product[] pros) {
		return getTotalPrice(pros)/pros.length;
	}
	public void printMorePrice(Product[] pros, int price) {
		for(Product pro : pros) {
			if(pro.getPrice()>=price) {
				System.out.println(pro.getMaker()+","+pro.getPrice());
			}
		}
	}
	public Product[] getCertainMaker(Product[] pros, String maker) {
		Product[] products =new Product[pros.length];
		int idx =0;
		for(Product pro : pros) {
			if(pro.getMaker().equals(maker)) {
				products[idx++]=pro;
			}
		}
		return products;
	}
}
