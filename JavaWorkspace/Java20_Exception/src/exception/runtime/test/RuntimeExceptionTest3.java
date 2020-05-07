package exception.runtime.test;
/*
 *  
 */
public class RuntimeExceptionTest3 {

	public static void main(String[] args) {
		System.out.println("======NullPointerException======");
		String str = new String("Encore"); // 
		str = null; 
		try {
			System.out.println("str의 데이터 값:"+str);
			System.out.println("str 문자열 길이:"+str.length());
		//}catch (Exception e) {
			//System.out.println("잡았다...Exception"); -> 이렇게 수행 안됨, 디테일한 거부터 큰 예외처리가 순차적으로 해야함 
		}catch (NullPointerException e) {
			System.out.println("잡았다...NullPointerException");
		}finally {
			System.out.println("Always Print");
		}

	}
}




