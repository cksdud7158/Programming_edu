package pizza.service;

import java.util.Vector;

import pizza.parent.Pizza;

// ���� �ٸ� �������� ���ڸ� �ڵ鸵�ϴ� ����� ������ �ִ� ���� Ŭ����
public class PizzaService {
	
	public void allMakePizza(Vector<Pizza> v) {
		for(Pizza p: v) {
			p.makePizza();
			System.out.println("==================================");
		}
	}
}
