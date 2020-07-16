package hrd.service.test;

import java.util.ArrayList;
import java.util.Scanner;

import hrd.service.HrdService;
import hrd.student.vo.Student;
import hrd.vo.Attendance;
import hrd.vo.Benefit;


public class HrdTest {
	public static void main(String[] args) {
		
	//ArrayList<Student> st = new ArrayList<>();
	HrdService service = HrdService.getInstance();
	
	Scanner sc = new Scanner(System.in);
	
	System.out.println("오늘 날짜를 입력받습니다.");
	System.out.println("년도를 입력해주세요(ex)2020 ");
	service.setYear(sc.nextInt());

	for(;;) {
		System.out.println("월을 입력해주세요");
		int month = sc.nextInt();
		if(month>9|| month<4) { //4~9 사이가 아닐 경우 종료 
			System.out.println("1~12월 사이를 입력해주세요 ");
			continue;
//			System.out.println("시스템을 종료합니다.");
//			System.exit(0);
		}else {
			service.setMonth(month);
		}
		System.out.println("일자를 입력해주세요");
		int day = sc.nextInt();
		if (month==5|| month==7|| month==8) { // 각 월에 맞는 일자가 아닐 경우 종료 
			if(day>31) {
				System.out.println("1~31일 사이를 입력해주세요 ");
				continue;
		}else if(month==4|| month==6|| month==9) {
				if(day>30) {
					System.out.println("1~30일 사이를 입력해주세요 ");
					continue;
				}
			}
		}
		service.setDay(day);
		break;
	}
 	// 날짜 입력 받기 
	
	chooseNum :while(true)
	{
		String menu = "";
		menu += "번호를 선택하세요\n";
		menu += "1:   학생을 추가하는 기능\t";
		menu += "2:   특정 학생의 지각정보를 업데이하는 기능\n";
		menu += "3:   특정 학생의 결석정보를 업데이트하는 기능 \t";
		menu += "4:   특정 학생의 연가정보를 업데이트하는 기능 \t";
		menu += "5:   이름으로 학생 찾는 기능 \n";
		menu += "6:   특정 학생 삭제하기 \t";
		menu += "7:   모든 학생 정보를 확인하는 기능\n";
		menu += "8:   특정 학생의 남은 연가일수를 확인하는 기능\t";
		menu += "9:   특정 학생의 당 월의 출석률을 확인하는 기능\n";
		menu += "10:  특정 학생의 전체 출석률을 확인하는 기능\t";
		menu += "11:  특정 학생의 당 월의 지원금을 확인하는 기능\n";
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
			System.out.println("학생 정보를 차례대로 입력해주세요 ");
			System.out.println("학생의 ID를 입력해주세요(String) ");
			String id = sc.next();
			System.out.println("학생의 이름을 입력해주세요(String) ");
			String name = sc.next();
			System.out.println("학생의 타입을 입력해주세요(1.기본 과정 2. 취업성공패키지 과정) ");
			int type = sc.nextInt()-1;
			
			service.AddStudent(new Student(id, name, new Attendance(new ArrayList<Integer>(), new ArrayList<Integer>(), new ArrayList<Integer>()), new Benefit(type)));
			service.setMaxAttendance(id);
			service.setAbsence(id);
			service.setLate(id);
			service.setVacation(id);
			System.out.println(service.SearchID(id)+"\n");
			break;
		case 2:
			System.out.println("학생의 지각정보를 업데이트합니다. \n 학생의 id를 입력해주세요 ");
			String id1 = sc.next();
			System.out.println("학생이 지각한 달을 입력해주세요 ");
			int month1 = sc.nextInt();
			System.out.println("학생의 지각횟수를 입력해주세요");
			int late = sc.nextInt();
			service.updateLate(id1, month1, late);
			break;
		case 3:
			System.out.println("학생의 결석정보를 업데이트합니다. \n 학생의 id를 입력해주세요 ");
			String id2 = sc.next();
			System.out.println("학생이 결석한 달을 입력해주세요 ");
			int month2 = sc.nextInt();
			System.out.println("학생의 결석횟수를 입력해주세요");
			int abscent = sc.nextInt();
			service.updateAbscent(id2, month2, abscent);
			break;
		case 4:
			System.out.println("학생의 연가정보를 업데이트합니다. \n 학생의 id를 입력해주세요 ");
			String id3 = sc.next();
			System.out.println("학생의 연가 사용 일수를 입력해주세요");
			int vacation= sc.nextInt();
			service.updateVacation(id3, vacation);
			break;
		case 5:
			System.out.println("학생의 정보를 확인합니다. \n 이름을 입력해주세요 ");
			String name2 =sc.next();
			System.out.println(service.searchName(name2));
			break;
		case 6:
			System.out.println("학생의 정보를 삭제합니다. \n 학생의 id를 입력해주세요 ");
			String id4 = sc.next();
			service.DeleteStudent(id4);
			break;
		case 7:
			System.out.println("학생의 모든 정보를 확인합니다. ");
			service.ShowAllStudentInfo();
			break;
		case 8:
			System.out.println("남은 연가일수를 확인합니다. \n 학생의 id를 입력해주세요.");
			String id5 = sc.next();
			System.out.println(service.SearchID(id5).getName()+"의 남은 연가 일수는 "+service.getRemainVacation(id5)+"입니다.");
			break;
		case 9:
			System.out.println("당 월의 출석률을 확인합니다. \n 학생의 id를 입력해주세요.");
			String id6 = sc.next();
			System.out.println(service.getThisMonthAttendanceRate(id6));
			break;
		case 10:
			System.out.println("전체 출석률을 확인합니다. \n 학생의 id를 입력해주세요.");
			String id7 = sc.next();
			System.out.println(service.getTotalAttendanceRate(id7));
			break;
		case 11:
			System.out.println("당월에 수령할 수당을 확인합니다. \n 학생의 id를 입력해주세요.");
			String id8 = sc.next();
			System.out.println(service.getThisMonthBenefit(id8));
			break;
		case 12:
			System.out.println("당월 결석 일수를  확인합니다. \n 학생의 id를 입력해주세요.");
			String id9 = sc.next();
			System.out.println(service.getThisMonthAbscence(id9));
			break;
		case 13:
			System.out.println("당월 남은 결석 가능 일수를 확인합니다. \n 학생의 id를 입력해주세요.");
			String id10 = sc.next();
			System.out.println(service.getThisMonthAvailableAbscence(id10));
			break;
		case 14:
			System.out.println("전체 남은 결석 가능 일수를 확인합니다. \n 학생의 id를 입력해주세요.");
			String id11 = sc.next();
			System.out.println(service.getTotalAvailableAbscence(id11));
			break;
			}
		}
	}
}
