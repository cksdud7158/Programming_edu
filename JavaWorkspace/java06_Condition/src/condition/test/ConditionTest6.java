package condition.test;

import java.util.Random;

/*
 * formating�� ���׿�����
 */

public class ConditionTest6 {

	public static void main(String[] args) {
		String result = "";
		Random r = new Random();
		
		System.out.println("=====ū�� or ������?");
		//0~99 ������ ������ ����
		int num1 = r.nextInt(100);
		
		if(num1>50) result="ū��";
		else result= "������";
		
		System.out.println(num1+"��"+result+"�Դϴ�");
		System.out.printf("%d��(��) %s �Դϴ�.",num1, result);
		
		int num2 = r.nextInt(10)+1; //1~10
		if(num2%2==0) result="¦��";//¦��
		else result = "Ȧ��";
		System.out.printf("%d�� %s �̴�",num2, result);
		
		System.out.println("==========���� ������");
		//���� �������� ����� �Ҹ������� ���;���
		result = (num2%2==0)? "¦��":"Ȧ��"; // true �� ¦�� false �� Ȧ��
		System.out.printf("%d�� %s �̴�",num2, result);

				
	}

}
