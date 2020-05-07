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
	
	System.out.println("오늘 날짜를 입력받습니다.");
	System.out.println("년도를 입력해주세요(ex)2020 ");
	int year = sc.nextInt();
	System.out.println(year);
	System.out.println("월을 입력해주세요");
	int month = sc.nextInt();
	System.out.println(month);
	System.out.println("일자를 입력해주세요");
	int day = sc.nextInt();
	System.out.println(day);
	
	chooseNum : while(true)
	{
		String menu = "";
		menu += "번호를 선택하세요\n";
		menu += "1:   학생을 추가하는 기능\t";
		menu += "2:   특정 학생의 지각정보를 업데이하는 기능\n";
		menu += "3:   특정 학생의 결석정보를 업데이트하는 기능 \t";
		menu += "4:   특정 학생 정보를 찾는 기능\n";
		menu += "5:   특정 학생을 삭제하는 기능\t";
		menu += "6:   모든 학생 정보를 확인하는 기능\n";
		menu += "7:   특정 학생의 남은 연가일수를 확인하는 기능\t";
		menu += "8:   특정 학생의 당 월의 출석률을 확인하는 기능\n";
		menu += "9:   특정 학생의 전체 출석률을 확인하는 기능\t";
		menu += "10:  특정 학생의 당 월의 지원금을 확인하는 기능\n";
		menu += "11:  특정 학생의 당 월 출석 일수를 확인하는 기능\t";
		menu += "12:  특정 학생의 당 월 결석 일수를 확인하는 기능\t";
		menu += "13:  특정 학생의 당 월 남은 결석 가능 일수를 확인하는 기능\t";
		menu += "14:  특정 학생의 남은 전체 결석 가능 일수를 확인하는 기능\t";
		menu += "0:끝내기";

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
