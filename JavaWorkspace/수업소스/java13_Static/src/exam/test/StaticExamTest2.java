package exam.test;
//필드와 static V가 어떻게 다른지를 확실하게 구분..
//static 변수는 생성된 객체들이 값을 공유한다...!!!...의미를 정확하게 이해
class Car{
	int serialNumber;
	static int counter; 
	
	Car(){
		counter++;//1
		serialNumber = counter;
	}
}
public class StaticExamTest2 {
	public static void main(String[] args) {
		Car car1 = new Car();
		Car car2 = new Car();
		Car car3 = new Car();
		
		System.out.println("========== field =================");
		System.out.println(car1.serialNumber);//1
		System.out.println(car2.serialNumber);//2
		System.out.println(car3.serialNumber);//3

		System.out.println("\n========== Static V =================");
		System.out.println(Car.counter);//3
		System.out.println(car1.counter);//3
		System.out.println(car2.counter);//3
		System.out.println(car3.counter);//3
	}
}




