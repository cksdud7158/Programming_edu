package stream.object.test;

import java.util.ArrayList;

import stream.object.service.CarService;
import stream.object.vo.Car;

public class CarServiceTest {

	public static void main(String[] args) throws Exception {
		String path = "src\\list.obj";
		
		CarService service = new CarService();
		
		ArrayList<Car> list = new ArrayList<>();
		list.add(new Car("렉스턴", 3500));
		list.add(new Car("아반떼", 2500));
		list.add(new Car("제네시스", 5000));
		
		service.outputCar(list, path); //직렬화
		System.out.println("lis.obj에 자동차의 정보를 출력");
		System.out.println("=======================");
		
		ArrayList<Car> returnCar = service.inputCar(path);
		System.out.println("역질렬화로 자동차의 정보를 가져와 출력합니다.");
		for(Car c : returnCar) System.out.println(c);
		
	}

}
