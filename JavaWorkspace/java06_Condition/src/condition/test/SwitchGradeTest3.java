package condition.test;

import java.util.Scanner;

/*
 * ��޿� ���� �ش��ϴ� case ���� ����ǵ��� ������ �ۼ�
 * ������ ����� ���� �������� �Է¹޾Ҵٸ�
 * ����� �Է¹޵��� ������ ����  
 */
public class SwitchGradeTest3 {

	public static void main(String[] args) {
		//������ ���� ����� �����ϴ� ������ �ۼ�
		Scanner sc = new Scanner(System.in);
		System.out.println("����� �̸��� �Է��ϼ���...\n");	
		String name = sc.nextLine();
		System.out.println("����� ����� �Է��ϼ���...\n");
		String grade = sc.nextLine();
		
		/*switch(grade) {
		case "A": System.out.println(name+", "+ grade+"�Դϴ�.");
		break;
		case "B": System.out.println(name+", "+ grade+"�Դϴ�.");
		break;
		case "C": System.out.println(name+", "+ grade+"�Դϴ�.");
		break;
		default : System.out.println("A,B,C �� �ϳ��� �Է��� �ּ���");
		}
		*/
		String message = "";
		
		switch(grade) {
		case "A": message = name +" ��, ����� ������ 90~100�Դϴ�.";
		break;
		case "B": System.out.println(name+", "+ grade+"�Դϴ�.");
		break;
		case "C": System.out.println(name+", "+ grade+"�Դϴ�.");
		break;
		default : System.out.println("A,B,C �� �ϳ��� �Է��� �ּ���");
		}
		
	}
}
