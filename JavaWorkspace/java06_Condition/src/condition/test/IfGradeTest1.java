package condition.test;
/*
 * �־��� ������ ���� ���� �ش� �ڵ����� ������
 * ������ �帧�� ���������ν� ���� ������ ���α׷��� ����� ���� �ֽ��ϴ�.
 * ::
 * if(blooean expression)/ else if(blooean expression)/ else
 * switch~case
 * 
 * 
 */
public class IfGradeTest1 {

	public static void main(String[] args) {
		//������ ���� ����� �����ϴ� ������ �ۼ�
		int grade= 87;
		
		/*if(grade>=90 && grade<=100) {
			System.out.println("A Grade");
		}
		else if(grade>=80 && grade<=90) {
			System.out.println("B Grade");
		}
		else if(grade>=70 && grade<=80) {
			System.out.println("C Grade");
		}
		else {
			System.out.println("Try Again");
		}*/
		if(grade>=90 && grade<=100) System.out.println("A Grade");
		else if(grade>=80 && grade<=90)System.out.println("B Grade");
		else if(grade>=70 && grade<=80)System.out.println("C Grade");
		else System.out.println("Try Again");
		
	}

}
