package condition.test;

import java.util.Scanner;

/*
 * ��޿� ����
 * �ش��ϴ� case���� ����ǵ��� ������ �ۼ�...
 * ������ ����� ���� ������ �Է¹޾Ҵٸ�
 * ����� �Է¹޵��� ������ ����...
 */
public class SwitchGradeTest3 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("����� �̸��� �Է��ϼ���...");
		String name = sc.nextLine();
		System.out.println("����� ����� �Է��ϼ���...");
		String grade = sc.nextLine();
		
		String message = "";
		switch(grade) {
		case "A":
			message = name+" ��, ����� ������ 90~100";
			break;
		case "B":
			message = name+" ��, ����� ������ 80~90";
			break;
		case "C":
			message = name+" ��, ����� ������ 70~80";
			break;
		default:
			message = "Try Again!!";
		}
		System.out.println(message);
	}
}












