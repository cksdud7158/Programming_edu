package stram.object.service.test;

import java.util.ArrayList;

import stram.object.service.CarService;
import stram.object.vo.Car;

public class CarServiceTest {
	public static void main(String[] args) throws Exception{
		String path = "src\\list.obj";
		
		CarService service = new CarService();
		
		ArrayList<Car> list = new ArrayList<>();
		list.add(new Car("������", 3500));
		list.add(new Car("�ƹݶ�", 2500));
		list.add(new Car("���ʽý�", 5000));
		
		service.outputCar(list, path); //����ȭ
		System.out.println("list.obj�� �ڵ����� ������ ����߽��ϴ�...");
		System.out.println("==================================");
		
		ArrayList<Car> returnCar = service.inputCar(path);
		System.out.println("������ȭ�� �ڵ��� ������ �����ͼ� ����մϴ�...");
		for(Car c : returnCar)	System.out.println(c);		
		
	}
}

















