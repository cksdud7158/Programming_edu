package exception.runtime.test;
/*
 * 예외 발생 안하면 try 수행
 * 예외 발생하면 
 * 발생한 예외를 잘 잡으면 catch 문 수행 
 */
public class RuntimeExceptionTest1 {

	public static void main(String[] args) {
		String[ ] str= {
			"Hello Java",
			"no I mean it",
			"Nice to meet you"
		};
		
		int i = 0;
		while(i<=3) {
			try {
				//예외 발생 안하면 이 부분을 수행
				System.out.println(str[i]); // 예외는 메소드 안에서 줄 단위로 발생한다. 예외가 발생하여 비정상적으로 발생한다. 	
			}catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("Nice Catch!");
			}
			/*
			 * Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 3
					at exception.runtime.test.RuntimeExceptionTest1.main(RuntimeExceptionTest1.java:14)
					
				런타입 계열은 코드를 수정하면 됨 , 명시적인 처리를 할 필요가 없다. 
			 */
			i++;
			
			
		}
	}
}
