package project1.test;
import java.util.ArrayList;
import java.util.Scanner;

import project1.service.SalaryManServiceImpl;

public class SalaryManServiceTest {
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		
		SalaryManServiceImpl mgr = SalaryManServiceImpl.getInstance();
		
		
		System.out.println("�÷��� �� ���� �Է��ϼ���>");
		int turn = 20;
		
		aaa : while(turn > 0)
		{
			String menu = "";
			menu += "��ȣ�� �����ϼ���\n";
			menu += "1. ȸ��� �߰��ϱ� ";
			menu += "2: �������Ű�� ���մϴ�.";
			menu += "3: �ް��� �����ϴ�.";
			menu += "4: �Ŀ� �߱� ���";
			menu += "5: Ư�� ȸ��� �˻�";
			menu += "6: HP�� ȸ��� �˻�";
			menu += "7: �������� ȸ��� �˻�";
			menu += "8: ȸ��� ����";
			menu += "9: ȸ��� �����ϱ�";
			menu += "0: ������";

			System.out.println(menu);
			int number = sc.nextInt();
			
			switch(number)
			{
			case 0: 
				break aaa;
			
			case 1:
				System.out.println("ȸ����� �ٴ� ȸ�縦 �������ּ���.");
				System.out.println("��ȣ ���� (1: ���� / 2: �߼ұ��) : ");
				int num = sc.nextInt();
				
				if(num < 0 || 2 < num)
					continue;
					
				System.out.println("�ֹι�ȣ: ");
				int ssn = sc.nextInt();
				System.out.println("�̸� : ");
				String name = sc.next();
				
				if(num==1) mgr.addSalaryMan(ssn, name, 1);
				else mgr.addSalaryMan(ssn, name, 2);
				
				break;
				
			case 2:
				System.out.println("� ȸ������� ���� ��ų���? ��ȣ�� �Է����ּ���");
				
				int i = sc.nextInt();
				mgr.work(s);
				break;
			case 3:
				System.out.println("�˻��� isbn �Է� : ");
				String name1 = sc.next();				
				System.out.println(mgr.searchBookByIsbn(name1));
				break;
			case 4:
				System.out.println("�˻��� title �Է� : ");
				String name2 = sc.next();
				ArrayList<Book> returnList=mgr.searchBookByTitle(name2);
				for(Book b : returnList) System.out.println(b);
				
				break;
			case 5:
				
				break;
			case 6:
				ArrayList<Book> returnList2=mgr.onlySearchMagazin();
				for(Book b : returnList2) {
					System.out.println(b);
				}
				break;
			case 7:
				ArrayList<Book> returnList3 = mgr.magazineOfThisYearInfo(2019);
				for(Book b : returnList3) {
					System.out.println(b);
				}
				break;
			case 8:
				System.out.println("�˻��� publisher �Է� : ");
				String name3 = sc.next();
				ArrayList<Book> returnList4=mgr.searchBookByPublish(name3);
				for(Book b : returnList4)System.out.println(b);
				break;
			case 9:
				System.out.println("�˻��� ���� �Է� : ");
				int num2 = sc.nextInt();
				ArrayList<Book> returnList5=mgr.searchBookByPrice(num2);
				for(Book b : returnList5)System.out.println(b);
				break;
			case 10:
				System.out.println(mgr.getTotalPrice());
				break;
			case 11:
				System.out.println(mgr.getAvgPrice());
				
			}
		}
		
		
	}//main
}//class