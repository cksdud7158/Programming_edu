package pizza.test;

import java.util.Vector;

import pizza.child.BugogiPizza;
import pizza.child.PineApplePizza;
import pizza.child.PotatoPizza;
import pizza.parent.Pizza;
import pizza.service.PizzaService;

public class PizzaServiceTest {
	public static void main(String[] args) {
		
		PizzaService service = new PizzaService();
		Vector<Pizza> v = new Vector<>();//10ĭ¥�� ���������.
		
		v.add(new PotatoPizza(12000, "Pizza Hut"));
		v.add(new BugogiPizza(22000, "Domino Pizza"));
		v.add(new PineApplePizza(27000, "�̽��� ����"));
		v.add(new BugogiPizza(25000, "��������"));
		
		System.out.println("Vector�ȿ� ����� ������ �� : "+v.size());//����� ����Ÿ ����
		System.out.println("Vector�� Capacity: "+v.capacity());//������ �뷮
		System.out.println("Pizza Information :"+v.toString());//��ü����..
		
		service.allMakePizza(v);

	}
}














