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
		Vector<Pizza> v = new Vector<>();//<E> -> Elenment, 객체의 타입을 넣어주어야함, 따로 사이즈를 지정하지않아도 10칸짜리가 만들어짐
		v.add(new PotatoPizza(12000, "Pizzahut"));
		v.add(new BulgogiPizza(22000, "도미노"));
		v.add(new ApplePizza(25000, "미스터"));
		v.add(new BulgogiPizza(25000, "피자수"));
		
		System.out.println("Vector 안에 저장된 피자 수: "+v.size());
		System.out.println("Vector의 Capaciry: "+v.capacity());
		System.out.println("Pizza Information "+v);
		
		ps.allMakePizza(v);
	}

}
