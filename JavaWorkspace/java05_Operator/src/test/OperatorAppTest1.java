package test;
/*
 * Local Variable �� Field Variable ������ 
 * ����� ��ġ�� ���� ����������. 
 * Field Variable  
 * 1.Ŭ���� �ٷ� ��, �޼ҵ� �ٱ�, 
 * 2.�⺻���� �ִ�. 
 * 3.Heap�� �ڸ�
 * 4.Member Variable �ν��Ͻ� ����, ��ü ����
 * 
 * Local Variable 
 * 1.�޼ҵ� ��, 
 * 2.�⺻���� ����. ���� �ݵ�� �ʱ�ȭ�ϰ� ����ؾ���. 
 * 3.Stack �� �ڸ�
 * 4.���� ���� 
 */

public class OperatorAppTest1 {

	public static void main(String[] args) {
		//local Variable ����
		int i=5;
		int j=3;
		
		Operator o1 = new Operator();
		Operator o2 = new Operator();
		
		o1=o2; // �ּҰ��� o2�� ����������. 
		
		System.out.println("o1 �ּҰ�:"+o1);
		System.out.println("o1 �ּҰ�:"+o2);
		System.out.println(o1==o2); 
		
		System.out.println("������ % ::"+i %j  );
		System.out.println(i==j); //false
		System.out.println(i!=j); // true
		
		boolean flag = false;
		System.out.println(flag); //false
		System.out.println(!flag); //true
		
		int k=10;
		System.out.println(k++); //���߿� 1�� ����
		System.out.println(k);
		
		int m=10;
		System.out.println(++m); //���� 1�� ���� 
		System.out.println(m);
		
		System.out.println(o1.test1()||o1.test2());
		
		
	}

}


// Ŭ������ ������ �޾Ƽ� ���� �� public �� ��� �ϳ��� �ٴ´�.
// ���� �޼ҵ� �տ� �ٿ��д�.
// ���� public �� �ٿ��� �̸��� class�� �̸����� ����Ǿ���  
class Operator{
	public boolean test1() {
		System.out.println("test1() call....");
		return true;
	}
	
	public boolean test2() {
		System.out.println("test2() call....");
		return false;
	}
}

