package exam.test;
//�ʵ�� static V�� ��� �ٸ����� Ȯ���ϰ� ����..
//static ������ ������ ��ü���� ���� �����Ѵ�...!!!...�ǹ̸� ��Ȯ�ϰ� ����
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




