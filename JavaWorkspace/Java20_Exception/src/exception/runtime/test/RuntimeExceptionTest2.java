package exception.runtime.test;
/*
 * NullPointerException
 * ::
 * ��ü�� �������� �ʰ� ��ü�� ����� �����Ϸ��� �� �� �߻��ϴ� ���� 
 * '��ü �������� �ʰ� '�� �ǹ̴� == null
 * 
 * catch�� ������ �� �� �ִ�. 
 * �� catch�� �� �ѹ��� ����ȴ�. 
 * 
 * finally 
 * ::
 * ���ܿ� ��� ���� ������ ����Ǿ������ϴ� �ڵ尡 �ִٸ�
 * �� �ȿ��� ����־���Ѵ�. 
 */
public class RuntimeExceptionTest2 {

	public static void main(String[] args) {
		System.out.println("======NullPointerException======");
		//String str1 = "Encore"; //�޸𸮿� �ö� �� Literal Pool
		String str = new String("Encore"); // �� ����� Heap
		System.out.println(str.toString()); //Encore
		
		str = null; 
		try {
			System.out.println("str�� ������ ��:"+str);
			System.out.println("str ���ڿ� ����:"+str.length());
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("��Ҵ�...1");
		}catch (NullPointerException e) {
			System.out.println("��Ҵ�...2");
		}catch (Exception e) {
			System.out.println("��Ҵ�...3");
		}finally {
			System.out.println("Always Print");
		}

	}
}


/*
 * 1. ���� �߻� �ڵ� �ۼ� + ���ܰ� �߻� ����
 * 	try + finally
 * 2. ���� �߻� �ڵ� �ۼ�  + ���ܰ� �߻� + �� ���ܸ� �� ����
 * 	try + finally
 * 3. ���� �߻� �ڵ� �ۼ�  + ���ܰ� �߻� + �� ���ܸ� �� ����
  	finally
  	
  	finally�� �ַ� �ִ� �ڵ� 
  	--> �ڿ��� �޳��ϴ� �ڵ�  -> close()
  	finally�� �����ϴ� �ʴ� ��찡 �ִ�. 
  	1) ��ǻ�Ͱ� ������ ��
  	2) finally �ȿ��� �� �ٸ� ���ܰ� �߻��� ��� -> finally �ȿ��� try�� ���μ� ��������
*/




