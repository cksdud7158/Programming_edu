package pizza.test;

import java.util.Vector;

import pizza.child.ApplePizza;
import pizza.child.BulgogiPizza;
import pizza.child.PotatoPizza;
import pizza.parent.Pizza;
import pizza.service.PizzaService;

public class PizzaServiceTest {

	public static void main(String[] args) {
		
		PizzaService ps = new PizzaService();
		Vector<Pizza> v = new Vector<>();//<E> -> Elenment, ��ü�� Ÿ���� �־��־����, ���� ����� ���������ʾƵ� 10ĭ¥���� �������
		v.add(new PotatoPizza(12000, "Pizzahut"));
		v.add(new BulgogiPizza(22000, "���̳�"));
		v.add(new ApplePizza(25000, "�̽���"));
		v.add(new BulgogiPizza(25000, "���ڼ�"));
		
		System.out.println("Vector �ȿ� ����� ���� ��: "+v.size());
		System.out.println("Vector�� Capaciry: "+v.capacity());
		System.out.println("Pizza Information "+v);
		
		ps.allMakePizza(v);
	}

}
