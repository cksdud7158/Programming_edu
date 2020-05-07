/*
 * ��������� Exception
 * ::
 * UserException
 * ::
 * 1. ������ ���̺귯�� ����Ŭ������ ������� �ʰ� ����	���� Ŭ������ ���� �����ؼ� ����.
 * 2. ���α׷��󿡼� Ư���� �����϶� ���� ���������� ���ܸ� �߻���Ű�� ���
 *     --> ������ ����� �������� ���
 * this---�ʵ��---����,�ʵ带 ����..
 * this()---�ϳ��� Ŭ�������� �Ǵٸ� ������ ȣ��...���ڰ� ����
 */

package exception.user.test;

import java.util.Scanner;
9
class ZeroBoom extends Exception{
	ZeroBoom(){
		this("This is ZeroBoomException...");
	}
	ZeroBoom(String message){
		super(message);
	}
}
class User{
	public void go(int n) throws ZeroBoom{
		System.out.println("2. go()�� �Ʒ��κп��� �����ۿ��� �մϴ�...�и� 0�̸� �ȵ˴ϴ�.");
		int j = 111;
		if(n==0) {
			//���� ���������� ��ź�� �߻�....ArithmeticException
			//throw new ZeroBoom();//JVM...����
			throw new ZeroBoom("�и� 0�̸� �����ϴ�!!!");
		}
		
		//����... j/n...
		//
		
	}
}
public class UserExceptionTest1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("���ڸ� �Է��ϼ���>>>");
		int num = sc.nextInt();
		
		User user = new User();
		try {
			System.out.println("1. go calling...");
			user.go(num);//calling
		}catch(ZeroBoom e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}		
		System.out.println("3. ��� ����� �����ϰ� �������� �մϴ�..");
	}
}










