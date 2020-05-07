package exception.user.test;

import java.util.Scanner;

/*
 * 시용자 정의 Exception
 * ::
 * UserException
 * ::
 * 1. 기존의 라이브러리 예외 클래스를 사용하지 않고 직접 예외 클래스를 내가 정의해서 쓴다.
 * 2. 프로그램 상에서 특정한 조건일 때 내가 고의적으로 예외를 발생 시키는 경우
 * 		--> 강력한 제어문의 수단으로 사용
 * 
 * this -> 필드 앞 --> 로컬변수와 필드 변수를 구분할 때 사용 
 * this() -- 하나의 클래스에서 또 다른 생성자 호출...인자값 갯수
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
		System.out.println("go()는 아랫부분에서 연산작용을 합니다... 분모가 0이면 안됩니다.");
		int j = 111;
		if(n==0) {
			//고의적으로 폭탄을 발생.. ArithmeticException
			throw new ZeroBoom("분모가 0이면 터집니다!!"); // 내가 예외 객체 생성할 때 던지면 됨 
		}
		
		//연산
	}
}
// 런타임계열 예외 
public class UserExceptionTest1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력하세요>>");
		int num = sc.nextInt();
		
		User user = new User();
		try {
			System.out.println("go calling");
			user.go(num); // calling
		}catch(ZeroBoom z) {
			System.out.println(z.getMessage());
			//z.printStackTrace(); // 몇 라인에서 예외가 발생했는지 알 수 있다.개발할 때만 사용, 배포할떄는 사용하면 안됨, 배포시 주석 처리 
		}
		System.out.println("모든 기능을 수행하고 정상 종료합니다.");
	}
}




