package condition.test;

import java.util.Random;

/*
 * formating �� ���� ������
 */
public class ConditionTest6 {
	public static void main(String[] args) {
		String result = "";
		Random r= new Random();//�����ϴ�
		
		System.out.println("=====ū��? Ȥ�� ������?");
		//0~99������ ������ ����
		int num1 = r.nextInt(100);
		
		if(num1>50) result="ū��";
		else result=  "������";
		
		//System.out.println(num1+" �� "+result+" �Դϴ�.");
		System.out.printf("%d��(��) %s�̴�%n",num1, result );
		
		int num2 = r.nextInt(10)+1;
		if(num2 % 2==0) result ="¦��";
		else result ="Ȧ��";
		System.out.printf("%d��(��) %s�̴�%n",num2, result );
		
		System.out.println("============���� ������=================");
		result = (num2 % 2==0)? "¦��" : "Ȧ��";
		System.out.printf("%d��(��) %s�̴�%n",num2, result );
	}
}










