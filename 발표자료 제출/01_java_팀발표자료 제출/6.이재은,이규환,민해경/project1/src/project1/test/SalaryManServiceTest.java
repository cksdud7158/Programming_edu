package project1.test;
import java.util.ArrayList;
import java.util.Scanner;

import project1.service.SalaryManServiceImpl;

public class SalaryManServiceTest {
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		
		SalaryManServiceImpl mgr = SalaryManServiceImpl.getInstance();
		
		
		System.out.println("플레이 턴 수를 입력하세요>");
		int turn = 20;
		
		aaa : while(turn > 0)
		{
			String menu = "";
			menu += "번호를 선택하세요\n";
			menu += "1. 회사원 추가하기 ";
			menu += "2: 워라밸지키며 일합니다.";
			menu += "3: 휴가를 떠납니다.";
			menu += "4: 파워 야근 모드";
			menu += "5: 특정 회사원 검색";
			menu += "6: HP로 회사원 검색";
			menu += "7: 월급으로 회사원 검색";
			menu += "8: 회사원 승진";
			menu += "9: 회사원 제거하기";
			menu += "0: 끝내기";

			System.out.println(menu);
			int number = sc.nextInt();
			
			switch(number)
			{
			case 0: 
				break aaa;
			
			case 1:
				System.out.println("회사원이 다닐 회사를 선택해주세요.");
				System.out.println("번호 선택 (1: 대기업 / 2: 중소기업) : ");
				int num = sc.nextInt();
				
				if(num < 0 || 2 < num)
					continue;
					
				System.out.println("주민번호: ");
				int ssn = sc.nextInt();
				System.out.println("이름 : ");
				String name = sc.next();
				
				if(num==1) mgr.addSalaryMan(ssn, name, 1);
				else mgr.addSalaryMan(ssn, name, 2);
				
				break;
				
			case 2:
				System.out.println("어떤 회사원에게 일을 시킬까요? 번호를 입력해주세요");
				
				int i = sc.nextInt();
				mgr.work(s);
				break;
			case 3:
				System.out.println("검색할 isbn 입력 : ");
				String name1 = sc.next();				
				System.out.println(mgr.searchBookByIsbn(name1));
				break;
			case 4:
				System.out.println("검색할 title 입력 : ");
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
				System.out.println("검색할 publisher 입력 : ");
				String name3 = sc.next();
				ArrayList<Book> returnList4=mgr.searchBookByPublish(name3);
				for(Book b : returnList4)System.out.println(b);
				break;
			case 9:
				System.out.println("검색할 가격 입력 : ");
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