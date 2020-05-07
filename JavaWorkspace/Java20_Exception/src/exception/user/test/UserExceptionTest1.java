package exception.user.test;

import java.util.Scanner;

/*
 * �ÿ��� ���� Exception
 * ::
 * UserException
 * ::
 * 1. ������ ���̺귯�� ���� Ŭ������ ������� �ʰ� ���� ���� Ŭ������ ���� �����ؼ� ����.
 * 2. ���α׷� �󿡼� Ư���� ������ �� ���� ���������� ���ܸ� �߻� ��Ű�� ���
 * 		--> ������ ����� �������� ���
 * 
 * this -> �ʵ� �� --> ���ú����� �ʵ� ������ ������ �� ��� 
 * this() -- �ϳ��� Ŭ�������� �� �ٸ� ������ ȣ��...���ڰ� ����
 */
class ZeroBoom extends Exception{
	
	public ZeroBoom() {
		this("This is ZeroBoomException");
	}
	
	public ZeroBoom(String Message) {
		super(Message);
	}
	
}
class User{
	public void go(int n) throws ZeroBoom {
		System.out.println("go()�� �Ʒ��κп��� �����ۿ��� �մϴ�... �и� 0�̸� �ȵ˴ϴ�.");
		int j = 111;
		if(n==0) {
			//���������� ��ź�� �߻�.. ArithmeticException
			throw new ZeroBoom("�и� 0�̸� �����ϴ�!!"); // ���� ���� ��ü ������ �� ������ �� 
		}
		
		//����
	}
}
// ��Ÿ�Ӱ迭 ���� 
public class UserExceptionTest1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("���ڸ� �Է��ϼ���>>");
		int num = sc.nextInt();
		
		User user = new User();
		try {
			System.out.println("go calling");
			user.go(num); // calling
		}catch(ZeroBoom z) {
			System.out.println(z.getMessage());
			//z.printStackTrace(); // �� ���ο��� ���ܰ� �߻��ߴ��� �� �� �ִ�.������ ���� ���, �����ҋ��� ����ϸ� �ȵ�, ������ �ּ� ó�� 
		}
		System.out.println("��� ����� �����ϰ� ���� �����մϴ�.");
	}
}




