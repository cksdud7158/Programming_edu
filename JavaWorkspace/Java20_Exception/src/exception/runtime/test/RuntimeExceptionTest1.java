package exception.runtime.test;
/*
 * ���� �߻� ���ϸ� try ����
 * ���� �߻��ϸ� 
 * �߻��� ���ܸ� �� ������ catch �� ���� 
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
				//���� �߻� ���ϸ� �� �κ��� ����
				System.out.println(str[i]); // ���ܴ� �޼ҵ� �ȿ��� �� ������ �߻��Ѵ�. ���ܰ� �߻��Ͽ� ������������ �߻��Ѵ�. 	
			}catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("Nice Catch!");
			}
			/*
			 * Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 3
					at exception.runtime.test.RuntimeExceptionTest1.main(RuntimeExceptionTest1.java:14)
					
				��Ÿ�� �迭�� �ڵ带 �����ϸ� �� , ������� ó���� �� �ʿ䰡 ����. 
			 */
			i++;
			
			
		}
	}
}
