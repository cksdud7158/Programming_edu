package hrd.service.test;

import java.util.ArrayList;
import java.util.Scanner;

import hrd.service.HrdService;
import hrd.student.vo.Student;
import hrd.vo.Attendance;

public class HrdTest {
	public static void main(String[] args) {
		
	//ArrayList<Student> st = new ArrayList<>();
	HrdService service = HrdService.getInstance();
	
	Scanner sc = new Scanner(System.in);
	
	System.out.println("���� ��¥�� �Է¹޽��ϴ�.");
	System.out.println("�⵵�� �Է����ּ���(ex)2020 ");
	int year = sc.nextInt();
	System.out.println(year);
	System.out.println("���� �Է����ּ���");
	int month = sc.nextInt();
	System.out.println(month);
	System.out.println("���ڸ� �Է����ּ���");
	int day = sc.nextInt();
	System.out.println(day);
	
	chooseNum : while(true)
	{
		String menu = "";
		menu += "��ȣ�� �����ϼ���\n";
		menu += "1:   �л��� �߰��ϴ� ���\t";
		menu += "2:   Ư�� �л��� ���������� �������ϴ� ���\n";
		menu += "3:   Ư�� �л��� �Ἦ������ ������Ʈ�ϴ� ��� \t";
		menu += "4:   Ư�� �л� ������ ã�� ���\n";
		menu += "5:   Ư�� �л��� �����ϴ� ���\t";
		menu += "6:   ��� �л� ������ Ȯ���ϴ� ���\n";
		menu += "7:   Ư�� �л��� ���� �����ϼ��� Ȯ���ϴ� ���\t";
		menu += "8:   Ư�� �л��� �� ���� �⼮���� Ȯ���ϴ� ���\n";
		menu += "9:   Ư�� �л��� ��ü �⼮���� Ȯ���ϴ� ���\t";
		menu += "10:  Ư�� �л��� �� ���� �������� Ȯ���ϴ� ���\n";
		menu += "11:  Ư�� �л��� �� �� �⼮ �ϼ��� Ȯ���ϴ� ���\t";
		menu += "12:  Ư�� �л��� �� �� �Ἦ �ϼ��� Ȯ���ϴ� ���\t";
		menu += "13:  Ư�� �л��� �� �� ���� �Ἦ ���� �ϼ��� Ȯ���ϴ� ���\t";
		menu += "14:  Ư�� �л��� ���� ��ü �Ἦ ���� �ϼ��� Ȯ���ϴ� ���\t";
		menu += "0:������";

		System.out.println(menu);
		int number = sc.nextInt();
		
		switch(number)
		{
		case 0: 
			break chooseNum;
		case 1:
			break;
		case 2:
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		case 7:
			break;
		case 8:
			break;
		case 9:
			break;
		case 10:
			break;
		case 11:
			break;
		case 12:
			break;
		case 13:
			break;
		case 14:
			break;
			}
		}
	}
}
