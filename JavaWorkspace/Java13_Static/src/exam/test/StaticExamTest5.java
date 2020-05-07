package exam.test;
/*
 * Singletone Pattern
 * ::
 * Ŭ�����κ��� ���� �� �Ѱ��� �ν��Ͻ��� �����ϰ� 
 * �ܺηκ��� ��ü ������ ���� ���ϵ��� ���Ƶδ� ����
 *  �̱��� ���� -> ��ü�� ���鶧 class �� �ʼ� 
 *  �̶� �̱��� Ÿ������ ����� �ش� �ν��Ͻ��� �ΰ� �̻� �� ����
 *  
 *  �ڵ� �ۼ� ���
 *  	1. Ŭ�������� �ϴ� �ϳ��� ��ü�� ���� --> private static ���� �����ؼ� ����
 *  	2. �ܺο��� ��ü ������ ���ϵ��� ���´�. ----> private ������()
 *  	3. �ϳ� ����� ���� ��ü�� �ܺο��� ����� �� �ֵ��� ����д�. ---> public static ����
 */

class Factory{
	private static Factory factory = new Factory(); //1�� ����
	private Factory() { // 2�� ����
		System.out.println("Car Factory..Creating");
	}
	
	public static Factory getInstance() { // 3�� ���� static�� �� ����� ��ü ������ �ȵ� ���¿��� ���� ���� 
		return factory;
	}
}
public class StaticExamTest5 {	
	public static void main(String[] args) {
		// Factory f = new Factory(); // ������ ȣ���� �ȵ�
		Factory factory1= Factory.getInstance();
		Factory factory2= Factory.getInstance();
		Factory factory3= Factory.getInstance();
		System.out.println(factory1);
		System.out.println(factory2);
		System.out.println(factory3);
	}
}
