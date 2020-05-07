package exam.test;
//�ʵ�� static V �� ��� �ٸ��� Ȯ���ϰԱ����ؾ��� 
//static V �� ������ ��ü���� ���� �����Ѵ�.
// ��ü���� �����ϴ� ���� static �� �����ؾ��� 
//
class Car{
	int serialNumber;
	static int counter; //static�� ������ ���� ������ ����
	
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
