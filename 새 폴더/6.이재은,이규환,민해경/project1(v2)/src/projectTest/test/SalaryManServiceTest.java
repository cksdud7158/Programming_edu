package projectTest.test;

import java.util.ArrayList;
import java.util.Scanner;

import projectTest.service.SalaryManServiceImpl;
import projectTest.vo.SalaryMan;

public class SalaryManServiceTest {
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		ArrayList<SalaryMan> getState = new ArrayList<SalaryMan>();
		
		SalaryManServiceImpl mgr = SalaryManServiceImpl.getInstance();
		
		int turns = 20;
		System.out.println(turns+"번 반복합니다.\n"); // 오타 수정
		
		turn: for(int i=0; i<turns ; i++) {
			game : while(true)
			{
				String menu = "";
				menu += "번호를 선택하세요\n";
				menu += "1. 회사원 추가하기\n";
				menu += "2: 워라밸 지키며 일합시다.\n";
				menu += "3: 파워 야근 모드!\n";
				menu += "4: 휴가를 떠나요~\n";
				menu += "5: 특정 회사원 검색\n";
				menu += "6: HP로 회사원 검색\n";
				menu += "7: 랭킹\n";
				menu += "8: 월급 협상\n";
				menu += "9: 회사원 제거하기\n";
				menu += "0: 턴 끝내기";
	
				System.out.println(menu);
				int number = sc.nextInt();
				
				switch(number)
				{
				case 0: 
					if(mgr.isFinished(mgr.getList())) {
						mgr.setFalse(mgr.getList());
						System.out.printf("***%d번째 턴을 종료합니다***\n",i+1);
						break game;
					}
					else {
						System.out.println("턴이 남아있는 회사원이 있습니다.");
						break;
					}
					
	
				case 1: //회사원 추가하기
					System.out.println("새로운 회사원이 다닐 회사를 선택해주세요.");
					System.out.println("번호 선택 (1: 대기업 / 2: 중소기업) : ");
					int num1 = sc.nextInt();
					
					if(num1 < 0 || 2 < num1)
						continue;
						
					System.out.println("이름 : ");
					String name = sc.next();
					
					mgr.addSalaryMan(name, num1);
					mgr.getInfo();
					break;
					
				case 2:// 워라밸지키며 일합니다
					if(mgr.getSize()!=0) {
					System.out.println("이번 달은 워라밸을 추구합니다.");
					mgr.workInfo(); // getinfo -> workInfo()로 메소드 변경
					int num2 = sc.nextInt();
					mgr.work(mgr.getList().get(num2-1));
					}
					else System.out.println("직원이 존재하지 않습니다. 직원을 추가해주세요.");
					break;
					
				case 3: // 파워 야근 모드
					if(mgr.getSize()!=0) {
					System.out.println("이번 달은 파워 야근 모드입니다.");
					mgr.workInfo();
					int num3 = sc.nextInt();
					mgr.nightwork(mgr.getList().get(num3-1));
					}
					else System.out.println("직원이 존재하지 않습니다. 직원을 추가해주세요.");
					break;
					
				case 4: //휴가를 떠납니다
					if(mgr.getSize()!=0) {
					System.out.println("이번 달은 휴가를 떠나게 됩니다.");
					mgr.workInfo();
					int num4 = sc.nextInt();
					mgr.vacation(mgr.getList().get(num4-1));}
					
					else System.out.println("직원이 존재하지 않습니다. 직원을 추가해주세요.");
					break;
					
				case 5://특정 회사원 검색
					if(mgr.getSize()!=0) {
					System.out.println("검색할 사원번호를 입력해주세요: ");
					int searchEmpNo = sc.nextInt();
					mgr.getSalaryMan(searchEmpNo);
					}
					
					else System.out.println("일을 진행할 직원이 존재하지 않습니다. 직원을 추가해주세요.");
					
					break;
					
				case 6://체력확인(Hp가 적은 순으로 정렬)
					if(mgr.getSize()!=0) mgr.searchHP();
					else System.out.println("일을 진행할 직원이 존재하지 않습니다. 직원을 추가해주세요.");
					break;
					
				case 7://승리에 제일 가까운 사람은? (월급이 높은순으로 정렬)
					if(mgr.getSize()!=0) mgr.searchSalary();
					else System.out.println("일을 진행할 직원이 존재하지 않습니다. 직원을 추가해주세요.");
					break;
					
				case 8://월급협상
					if(mgr.getSize()!=0) {
						System.out.println("월급협상하고자 하는 분을 정해주세요");
						mgr.workInfo();
						int salUpEmpNo = sc.nextInt();
						mgr.updateSalaryMan(mgr.getList().get(salUpEmpNo-1));
					}
					
					else System.out.println("일을 진행할 직원이 존재하지 않습니다. 직원을 추가해주세요.");
					
					break;
					
				case 9://회사원 제거하기
					if(mgr.getSize()!=0) {
						System.out.println("삭제하고자 하는 회사원의 사원번호를 입력해주세요");
						int DeleteEmpNo = sc.nextInt();
						mgr.deleteSalaryMan(DeleteEmpNo);
					}
					
					else System.out.println("일을 진행할 직원이 존재하지 않습니다. 직원을 추가해주세요.");
					break;
					}// end of switch
				
				getState = mgr.getList();
				if(!(mgr.getVic(getState).isEmpty())) {
					for(SalaryMan sm: getState) {
						System.out.println("성공엔딩! "+sm.getName()+"님이 목적 달성에 성공하셨습니다.");
						System.out.println("게임을 종료합니다.");
						break turn;
					}
				}
				else if(!(mgr.getSick(getState).isEmpty())) {
						for(SalaryMan sm: getState) {
							System.out.println("입원엔딩! "+sm.getName()+"님이 병원에 입원하였습니다.");
							System.out.println("게임을 종료합니다.");
							break turn;}
				}
			} //end of while
		if(i==19) System.out.printf("미달성엔딩! %d회 이내에 목표를 달성하지 못했습니다.",i+1);
		} // end of turns
	}//main	
}//class

