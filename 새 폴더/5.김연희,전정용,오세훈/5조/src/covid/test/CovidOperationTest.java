package covid.test;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import covid.service.CovidOperationImpl;
import covid.util.Fever;
import covid.vo.child.Staff;
import covid.vo.child.Student;
import covid.vo.child.Teacher;
import covid.vo.parent.Visitor;

public class CovidOperationTest {
	public static void main(String[] args) {
		
		CovidOperationImpl service = new CovidOperationImpl();
		ArrayList<Visitor> test = new ArrayList<>();
		ArrayList<Visitor> AllVisitorsTest = new ArrayList<>();
		
		Scanner sc = new Scanner(System.in);
		
		int selectNum;
		int lecture_num;
		int choosenNum;
		int career;
		boolean flag = true;
		boolean add_flag = true;
		boolean symptom_flag = false;
		boolean mask;
		boolean SelecSymptom;
		String symptom = null;
		String visitorName;
		String major;
		String company;
		String dept;
		String deleteName;
		String maskName;
		String TempName;
		String SymName;
		String Sym;
		double temper_morning;
		double temper_afternoon;
		double temper_test;
		double temper_morgen;
		double temper_tag;
		double sal;
		
		System.out.println("<<COVID-19 관리 프로그램>>");
		
		while(flag) {
			System.out.println("--------------------------------");
			System.out.println("| 1. 방문자 정보 입력		|");
			System.out.println("| 2. 모든 방문자 정보 전체 검색	|");
			System.out.println("| 3. 방문자 정보 제거		|");
			System.out.println("| 4. 마스크 검사			|");
			System.out.println("| 5. 모든 방문자 온도 재기		|");
			System.out.println("| 6. 특정 방문자 온도 정보 수정	|");
			System.out.println("| 7. 특정 방문자 증상 정보 수정	|");
			System.out.println("| 8. 모든 방문자 체온/온도 정보 출력	|");
			System.out.println("| 0. 종료				|");
			System.out.println("--------------------------------");
			System.out.print("입력 : ");
			selectNum = sc.nextInt();
			sc.nextLine();
				
			System.out.println("");
			switch(selectNum) {
				case 1:
					System.out.print("방문자 이름을 입력해주세요. : ");
					visitorName = sc.nextLine();
						
					if(service.checkVisitor(visitorName)) 
						break;
						
					System.out.print("마스크 착용 여부를 입력해주세요. (true/false) : ");
					mask = sc.nextBoolean();
					System.out.print("오전 온도를 입력해주십시오 : ");
					temper_morning = sc.nextDouble();
					System.out.print("오후 온도를 입력해주십시오 : ");
					temper_afternoon = sc.nextDouble();
					System.out.print("증상이 있으십니까 (true/false)? "); 
					SelecSymptom = sc.nextBoolean(); 
					sc.nextLine();
						
					if(SelecSymptom) {
							System.out.print("증상을 입력해주십시오. : "); 
							symptom = sc.nextLine();
							symptom_flag = true;
					} // if
					
					else 
						symptom = null;
											
					while(true) {
						System.out.println("방문자의 종류는 무엇입니까? ");
						System.out.print("1. 학생 2. 선생님 3. 직원 : ");
						choosenNum = sc.nextInt();
						
						switch(choosenNum) {
							case 1:
								System.out.print("강의실 번호를 입력해주십시오. : "); 
								lecture_num = sc.nextInt();
								sc.nextLine();
								System.out.print("전공을 입력해주십시오. : ");
								major = sc.nextLine();
								if(symptom_flag)
									service.addVisitor(new Student(visitorName, mask, new Fever(temper_morning, temper_afternoon), symptom, lecture_num, major ));
								else 
									service.addVisitor(new Student(visitorName, mask, new Fever(temper_morning, temper_afternoon), lecture_num, major ));
								break;
							case 2:
								System.out.print("경력 기간을 입력해주십시오. (정수) : ");
								career = sc.nextInt();
								sc.nextLine();
								System.out.print("소속 회사를 입력해주십시오. : ");
								company = sc.nextLine();
								if(symptom_flag)
								service.addVisitor(new Teacher(visitorName, mask, new Fever(temper_morning, temper_afternoon), symptom, career, company ));
								else 
									service.addVisitor(new Teacher(visitorName, mask, new Fever(temper_morning, temper_afternoon), career, company));
								break;
							case 3:
								System.out.print("월급을 입력해주십시오. : ");
								sal = sc.nextDouble();
								sc.nextLine();
								System.out.print("직무를 입력해주십시오. : ");
								dept = sc.nextLine();
								if(symptom_flag)
									service.addVisitor(new Staff(visitorName, mask, new Fever(temper_morning, temper_afternoon), sal, dept ));
								else 
									service.addVisitor(new Staff(visitorName, mask, new Fever(temper_morning, temper_afternoon), sal, dept));
								break;
							default :
									System.out.println("다시 입력해주십시오.");
							} // switch

						if(1 <= choosenNum && choosenNum <= 3) 
							break;
							
					} // while
						break;
				case 2: 
					AllVisitorsTest = service.getAllVisitors();
					service.printVistiors(AllVisitorsTest);
					break;
				case 3:
					System.out.print("제거하고 싶은 방문자의 이름을 입력해주십시오. : ");
					deleteName = sc.nextLine();
					service.deleteVistor(deleteName);
					break;
				case 4:
					System.out.print("마스크 착용 유무를 검사하고 싶은 방문자의 이름을 입력해주십시오. : ");
					maskName = sc.nextLine();
					service.checkMask(maskName);
					break;
				case 5:
					System.out.println("모든 방문자의 온도를 재겠습니다.");
					System.out.print("기준 온도를 입력해주십시오. : ");
					temper_test  = sc.nextDouble();
					service.overTemperature(temper_test);
					break;
				case 6:
					System.out.print("온도를 바꾸고 싶은 방문자의 이름을 입력하십시오. : ");
					TempName = sc.nextLine();
					System.out.print("바꿀 오전 온도를 입력해주십시오. : ");
					temper_morgen = sc.nextDouble();
					System.out.print("바꿀 오후 온도를 입력해주십시오. : ");
					temper_tag = sc.nextDouble();
					service.updateCondition(TempName, new Fever(temper_morgen, temper_tag));
					break;
				case 7:
					System.out.print("증상을 바꾸고 싶은 방문자의 이름을 입력하십시오. : ");
					SymName = sc.nextLine();
					System.out.print("바꿀 증상을 입력해주십시오. : ");
					Sym = sc.nextLine();
					service.updateCondition(SymName, Sym);
					break;
				case 8:
					System.out.println("모든 방문자 체온/온도 정보를 출력하겠습니다. ");
					service.printVisitors();
					break;
				case 0:
					System.exit(0);
				default :
					System.out.println("잘못 입력하셨습니다. 다시 입력해주십시오.");
			} // switch
				
		} // while 
			
	} // main
		
} // class
