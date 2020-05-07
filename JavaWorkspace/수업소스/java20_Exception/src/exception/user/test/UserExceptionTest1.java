/*
 * 사용자정의 Exception
 * ::
 * UserException
 * ::
 * 1. 기존의 라이브러리 예외클래스를 사용하지 않고 직접	예외 클래스를 내가 정의해서 쓴다.
 * 2. 프로그램상에서 특정한 조건일때 내가 고의적으로 예외를 발생시키는 경우
 *     --> 강력한 제어문의 수단으로 사용
 * this---필드앞---로컬,필드를 구분..
 * this()---하나의 클래스에서 또다른 생성자 호출...인자값 갯수
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
		System.out.println("2. go()는 아랫부분에서 연산작용을 합니다...분모가 0이면 안됩니다.");
		int j = 111;
		if(n==0) {
			//내가 고의적으로 폭탄을 발생....ArithmeticException
			//throw new ZeroBoom();//JVM...내가
			throw new ZeroBoom("분모가 0이면 터집니다!!!");
		}
		
		//연산... j/n...
		//
		
	}
}
public class UserExceptionTest1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력하세요>>>");
		int num = sc.nextInt();
		
		User user = new User();
		try {
			System.out.println("1. go calling...");
			user.go(num);//calling
		}catch(ZeroBoom e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}		
		System.out.println("3. 모든 기능을 수행하고 정상종료 합니다..");
	}
}










