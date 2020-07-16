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
		
		System.out.println("<<COVID-19 ���� ���α׷�>>");
		
		while(flag) {
			System.out.println("--------------------------------");
			System.out.println("| 1. �湮�� ���� �Է�		|");
			System.out.println("| 2. ��� �湮�� ���� ��ü �˻�	|");
			System.out.println("| 3. �湮�� ���� ����		|");
			System.out.println("| 4. ����ũ �˻�			|");
			System.out.println("| 5. ��� �湮�� �µ� ���		|");
			System.out.println("| 6. Ư�� �湮�� �µ� ���� ����	|");
			System.out.println("| 7. Ư�� �湮�� ���� ���� ����	|");
			System.out.println("| 8. ��� �湮�� ü��/�µ� ���� ���	|");
			System.out.println("| 0. ����				|");
			System.out.println("--------------------------------");
			System.out.print("�Է� : ");
			selectNum = sc.nextInt();
			sc.nextLine();
				
			System.out.println("");
			switch(selectNum) {
				case 1:
					System.out.print("�湮�� �̸��� �Է����ּ���. : ");
					visitorName = sc.nextLine();
						
					if(service.checkVisitor(visitorName)) 
						break;
						
					System.out.print("����ũ ���� ���θ� �Է����ּ���. (true/false) : ");
					mask = sc.nextBoolean();
					System.out.print("���� �µ��� �Է����ֽʽÿ� : ");
					temper_morning = sc.nextDouble();
					System.out.print("���� �µ��� �Է����ֽʽÿ� : ");
					temper_afternoon = sc.nextDouble();
					System.out.print("������ �����ʴϱ� (true/false)? "); 
					SelecSymptom = sc.nextBoolean(); 
					sc.nextLine();
						
					if(SelecSymptom) {
							System.out.print("������ �Է����ֽʽÿ�. : "); 
							symptom = sc.nextLine();
							symptom_flag = true;
					} // if
					
					else 
						symptom = null;
											
					while(true) {
						System.out.println("�湮���� ������ �����Դϱ�? ");
						System.out.print("1. �л� 2. ������ 3. ���� : ");
						choosenNum = sc.nextInt();
						
						switch(choosenNum) {
							case 1:
								System.out.print("���ǽ� ��ȣ�� �Է����ֽʽÿ�. : "); 
								lecture_num = sc.nextInt();
								sc.nextLine();
								System.out.print("������ �Է����ֽʽÿ�. : ");
								major = sc.nextLine();
								if(symptom_flag)
									service.addVisitor(new Student(visitorName, mask, new Fever(temper_morning, temper_afternoon), symptom, lecture_num, major ));
								else 
									service.addVisitor(new Student(visitorName, mask, new Fever(temper_morning, temper_afternoon), lecture_num, major ));
								break;
							case 2:
								System.out.print("��� �Ⱓ�� �Է����ֽʽÿ�. (����) : ");
								career = sc.nextInt();
								sc.nextLine();
								System.out.print("�Ҽ� ȸ�縦 �Է����ֽʽÿ�. : ");
								company = sc.nextLine();
								if(symptom_flag)
								service.addVisitor(new Teacher(visitorName, mask, new Fever(temper_morning, temper_afternoon), symptom, career, company ));
								else 
									service.addVisitor(new Teacher(visitorName, mask, new Fever(temper_morning, temper_afternoon), career, company));
								break;
							case 3:
								System.out.print("������ �Է����ֽʽÿ�. : ");
								sal = sc.nextDouble();
								sc.nextLine();
								System.out.print("������ �Է����ֽʽÿ�. : ");
								dept = sc.nextLine();
								if(symptom_flag)
									service.addVisitor(new Staff(visitorName, mask, new Fever(temper_morning, temper_afternoon), sal, dept ));
								else 
									service.addVisitor(new Staff(visitorName, mask, new Fever(temper_morning, temper_afternoon), sal, dept));
								break;
							default :
									System.out.println("�ٽ� �Է����ֽʽÿ�.");
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
					System.out.print("�����ϰ� ���� �湮���� �̸��� �Է����ֽʽÿ�. : ");
					deleteName = sc.nextLine();
					service.deleteVistor(deleteName);
					break;
				case 4:
					System.out.print("����ũ ���� ������ �˻��ϰ� ���� �湮���� �̸��� �Է����ֽʽÿ�. : ");
					maskName = sc.nextLine();
					service.checkMask(maskName);
					break;
				case 5:
					System.out.println("��� �湮���� �µ��� ��ڽ��ϴ�.");
					System.out.print("���� �µ��� �Է����ֽʽÿ�. : ");
					temper_test  = sc.nextDouble();
					service.overTemperature(temper_test);
					break;
				case 6:
					System.out.print("�µ��� �ٲٰ� ���� �湮���� �̸��� �Է��Ͻʽÿ�. : ");
					TempName = sc.nextLine();
					System.out.print("�ٲ� ���� �µ��� �Է����ֽʽÿ�. : ");
					temper_morgen = sc.nextDouble();
					System.out.print("�ٲ� ���� �µ��� �Է����ֽʽÿ�. : ");
					temper_tag = sc.nextDouble();
					service.updateCondition(TempName, new Fever(temper_morgen, temper_tag));
					break;
				case 7:
					System.out.print("������ �ٲٰ� ���� �湮���� �̸��� �Է��Ͻʽÿ�. : ");
					SymName = sc.nextLine();
					System.out.print("�ٲ� ������ �Է����ֽʽÿ�. : ");
					Sym = sc.nextLine();
					service.updateCondition(SymName, Sym);
					break;
				case 8:
					System.out.println("��� �湮�� ü��/�µ� ������ ����ϰڽ��ϴ�. ");
					service.printVisitors();
					break;
				case 0:
					System.exit(0);
				default :
					System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ֽʽÿ�.");
			} // switch
				
		} // while 
			
	} // main
		
} // class
