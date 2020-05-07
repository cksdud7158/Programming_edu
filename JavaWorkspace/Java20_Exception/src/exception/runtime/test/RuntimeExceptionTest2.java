package exception.runtime.test;
/*
 * NullPointerException
 * ::
 * 객체를 생서하지 않고 객체의 멤버에 접근하려고 할 때 발생하는 예외 
 * '객체 생성하지 않고 '의 의미는 == null
 * 
 * catch는 여러번 할 수 있다. 
 * 단 catch는 단 한번만 수행된다. 
 * 
 * finally 
 * ::
 * 예외와 상관 없이 무조건 수행되어져야하는 코드가 있다면
 * 이 안에다 집어넣어야한다. 
 */
public class RuntimeExceptionTest2 {

	public static void main(String[] args) {
		System.out.println("======NullPointerException======");
		//String str1 = "Encore"; //메모리에 올라갈 때 Literal Pool
		String str = new String("Encore"); // 이 방식은 Heap
		System.out.println(str.toString()); //Encore
		
		str = null; 
		try {
			System.out.println("str의 데이터 값:"+str);
			System.out.println("str 문자열 길이:"+str.length());
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("잡았다...1");
		}catch (NullPointerException e) {
			System.out.println("잡았다...2");
		}catch (Exception e) {
			System.out.println("잡았다...3");
		}finally {
			System.out.println("Always Print");
		}

	}
}


/*
 * 1. 예외 발생 코드 작성 + 예외가 발생 안함
 * 	try + finally
 * 2. 예외 발생 코드 작성  + 예외가 발생 + 그 예외를 잘 잡음
 * 	try + finally
 * 3. 예외 발생 코드 작성  + 예외가 발생 + 그 예외를 못 잡음
  	finally
  	
  	finally에 주로 넣는 코드 
  	--> 자원을 받납하는 코드  -> close()
  	finally가 동작하는 않는 경우가 있다. 
  	1) 컴퓨터가 꺼졌을 때
  	2) finally 안에서 또 다른 예외가 발생할 경우 -> finally 안에서 try로 감싸서 돌려야함
*/




