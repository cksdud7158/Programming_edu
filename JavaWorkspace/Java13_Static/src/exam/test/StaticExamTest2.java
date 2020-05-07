package exam.test;
//필드와 static V 가 어떻게 다른지 확실하게구분해야함 
//static V 는 생성된 객체들이 값을 공유한다.
// 객체마다 공유하는 값은 static 로 설계해야함 
//
class Car{
	int serialNumber;
	static int counter; //static한 변수는 로컬 레벨에 못씀
	
	Car(){
		counter++; //1
		serialNumber = counter;
	}
}
public class StaticExamTest2 {
	public static void main(String[] args) {
		Car car1 = new Car();
		Car car2 = new Car();
		Car car3 = new Car();
		
		System.out.println("=============field===========");
		System.out.println(car1.serialNumber);
		System.out.println(car2.serialNumber);
		System.out.println(car3.serialNumber);
		
		System.out.println("=============Static V===========");
		System.out.println(Car.counter);
		System.out.println(car1.counter);
		System.out.println(car2.counter);
		System.out.println(car3.counter);

	}
}
