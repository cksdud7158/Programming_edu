package self.test;

import java.util.Scanner;


public class CatchAMouseTest {

	public static String solv(int x, int y, int z) {
		if(Math.abs(x-z)>Math.abs(y-z)) return "B�� ��Ҵ�";
		else if(Math.abs(x-z)>Math.abs(y-z)) return "A�� ��Ҵ�";
		else return "�㰡 ��������.";
		}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//������� �� �Է�
		System.out.println("����� A ����");
		int cata = Math.abs(sc.nextInt());
		System.out.println("����� B ����");
		int catb= Math.abs(sc.nextInt());
		System.out.println("�� ����");
		int mouse= Math.abs(sc.nextInt());
		
		String result = solv(cata, catb, mouse);
		System.out.printf("Result:: %s", result);
		
		
	}


}
