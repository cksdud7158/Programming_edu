package exam.test;
//static block
public class StaticExamTest3 {
	static int i;
	
	public static void main(String[] args) {
		System.out.println("1. main method static block..." + i);
		//��ü ����..();  ---> (){///}
		// 
	}
	
	
	static {
		i=300;
		System.out.println("2.static initialization block..." + i);
	}
	/* ���� ���
	 *  2.static block...300
		1. main method static block...300
		main�� ���� ������� �ʴ´�. 
		
		���κ��� ���� ����Ǵ°��� static �ʱ�ȭ block �� ���� ����� -> �۷ι��� ������ ���� ���� 
		
		 
	 */
}
