/*
 * NullPointerException::
 * ��ü �������� �ʰ� ��ü�� ����� �����Ϸ��� �Ҷ� �߻��ϴ� ����....
 * ��ü �������� �ʰ� == null
 * 
 * catch�� ������ �Ҽ� �ִ�...
 * ������ �� �߿��� �� �ѹ��� ����ȴ�...
 * 
 * finally
 * ::
 * ���ܿ� ������� ������ ����Ǿ����� �ϴ� �ڵ尡 �ִٸ�...
 * �� �ȿ��� ����־�� �Ѵ�.
 */
package exception.runtime.test;
public class RuntimeExceptionTest3 {
	public static void main(String[] args) {
		System.out.println("========== NullPointerException========");
		String str = new String("Encore");//Heap		
		str = null; 
		try {
			System.out.println("str�� ����Ÿ �� :: "+str);//null
			System.out.println("str ���ڿ� ���� :: "+str.length());
		}catch(Exception e) {
			System.out.println("��Ҵ�...Exception");
		}/*catch(NullPointerException e) {
			System.out.println("��Ҵ�...NullPointerException");
		}*/finally {
			System.out.println("Always Print...");
		}
	}
}
/*
1. ���� �߻��ڵ� �ۼ� ...+ ���ܰ� �߻� ����.
   try + finally
2. ���� �߻��ڵ� �ۼ� ...+ ���ܰ� �߻� + �� ���ܸ� �� ����.
   catch + finally
3. ���� �߻��ڵ� �ۼ� ...+ ���ܰ� �߻� + �� ���ܸ� �� ������.
   finally
   
   finally�� �ַ� �ִ� �ڵ�
   --> �ڿ��� �ݳ��ϴ� �ڵ�...close()
   
   finally�� �������� �ʴ� ��찡 �ִ�.
   1) �� �ȿ��� �ٽ� ���ܰ� �߻��Ҷ�...�� ���� try~catch�� ���ξ� �Ѵ�.
 */



















