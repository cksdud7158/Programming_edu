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
	
	System.out.println("���� ��¥�� �Է¹޽��ϴ�.");
	System.out.println("�⵵�� �Է����ּ���(ex)2020 ");
	service.setYear(sc.nextInt());

	for(;;) {
		System.out.println("���� �Է����ּ���");
		int month = sc.nextInt();
		if(month>9|| month<4) { //4~9 ���̰� �ƴ� ��� ���� 
			System.out.println("1~12�� ���̸� �Է����ּ��� ");
			continue;
//			System.out.println("�ý����� �����մϴ�.");
//			System.exit(0);
		}else {
			service.setMonth(month);
		}
		System.out.println("���ڸ� �Է����ּ���");
		int day = sc.nextInt();
		if (month==5|| month==7|| month==8) { // �� ���� �´� ���ڰ� �ƴ� ��� ���� 
			if(day>31) {
				System.out.println("1~31�� ���̸� �Է����ּ��� ");
				continue;
		}else if(month==4|| month==6|| month==9) {
				if(day>30) {
					System.out.println("1~30�� ���̸� �Է����ּ��� ");
					continue;
				}
			}
		}
		service.setDay(day);
		break;
	}
 	// ��¥ �Է� �ޱ� 
	
	chooseNum :while(true)
	{
		String menu = "";
		menu += "��ȣ�� �����ϼ���\n";
		menu += "1:   �л��� �߰��ϴ� ���\t";
		menu += "2:   Ư�� �л��� ���������� �������ϴ� ���\n";
		menu += "3:   Ư�� �л��� �Ἦ������ ������Ʈ�ϴ� ��� \t";
		menu += "4:   Ư�� �л��� ���������� ������Ʈ�ϴ� ��� \t";
		menu += "5:   �̸����� �л� ã�� ��� \n";
		menu += "6:   Ư�� �л� �����ϱ� \t";
		menu += "7:   ��� �л� ������ Ȯ���ϴ� ���\n";
		menu += "8:   Ư�� �л��� ���� �����ϼ��� Ȯ���ϴ� ���\t";
		menu += "9:   Ư�� �л��� �� ���� �⼮���� Ȯ���ϴ� ���\n";
		menu += "10:  Ư�� �л��� ��ü �⼮���� Ȯ���ϴ� ���\t";
		menu += "11:  Ư�� �л��� �� ���� �������� Ȯ���ϴ� ���\n";
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
			System.out.println("�л� ������ ���ʴ�� �Է����ּ��� ");
			System.out.println("�л��� ID�� �Է����ּ���(String) ");
			String id = sc.next();
			System.out.println("�л��� �̸��� �Է����ּ���(String) ");
			String name = sc.next();
			System.out.println("�л��� Ÿ���� �Է����ּ���(1.�⺻ ���� 2. ���������Ű�� ����) ");
			int type = sc.nextInt()-1;
			
			service.AddStudent(new Student(id, name, new Attendance(new ArrayList<Integer>(), new ArrayList<Integer>(), new ArrayList<Integer>()), new Benefit(type)));
			service.setMaxAttendance(id);
			service.setAbsence(id);
			service.setLate(id);
			service.setVacation(id);
			System.out.println(service.SearchID(id)+"\n");
			break;
		case 2:
			System.out.println("�л��� ���������� ������Ʈ�մϴ�. \n �л��� id�� �Է����ּ��� ");
			String id1 = sc.next();
			System.out.println("�л��� ������ ���� �Է����ּ��� ");
			int month1 = sc.nextInt();
			System.out.println("�л��� ����Ƚ���� �Է����ּ���");
			int late = sc.nextInt();
			service.updateLate(id1, month1, late);
			break;
		case 3:
			System.out.println("�л��� �Ἦ������ ������Ʈ�մϴ�. \n �л��� id�� �Է����ּ��� ");
			String id2 = sc.next();
			System.out.println("�л��� �Ἦ�� ���� �Է����ּ��� ");
			int month2 = sc.nextInt();
			System.out.println("�л��� �ἮȽ���� �Է����ּ���");
			int abscent = sc.nextInt();
			service.updateAbscent(id2, month2, abscent);
			break;
		case 4:
			System.out.println("�л��� ���������� ������Ʈ�մϴ�. \n �л��� id�� �Է����ּ��� ");
			String id3 = sc.next();
			System.out.println("�л��� ���� ��� �ϼ��� �Է����ּ���");
			int vacation= sc.nextInt();
			service.updateVacation(id3, vacation);
			break;
		case 5:
			System.out.println("�л��� ������ Ȯ���մϴ�. \n �̸��� �Է����ּ��� ");
			String name2 =sc.next();
			System.out.println(service.searchName(name2));
			break;
		case 6:
			System.out.println("�л��� ������ �����մϴ�. \n �л��� id�� �Է����ּ��� ");
			String id4 = sc.next();
			service.DeleteStudent(id4);
			break;
		case 7:
			System.out.println("�л��� ��� ������ Ȯ���մϴ�. ");
			service.ShowAllStudentInfo();
			break;
		case 8:
			System.out.println("���� �����ϼ��� Ȯ���մϴ�. \n �л��� id�� �Է����ּ���.");
			String id5 = sc.next();
			System.out.println(service.SearchID(id5).getName()+"�� ���� ���� �ϼ��� "+service.getRemainVacation(id5)+"�Դϴ�.");
			break;
		case 9:
			System.out.println("�� ���� �⼮���� Ȯ���մϴ�. \n �л��� id�� �Է����ּ���.");
			String id6 = sc.next();
			System.out.println(service.getThisMonthAttendanceRate(id6));
			break;
		case 10:
			System.out.println("��ü �⼮���� Ȯ���մϴ�. \n �л��� id�� �Է����ּ���.");
			String id7 = sc.next();
			System.out.println(service.getTotalAttendanceRate(id7));
			break;
		case 11:
			System.out.println("����� ������ ������ Ȯ���մϴ�. \n �л��� id�� �Է����ּ���.");
			String id8 = sc.next();
			System.out.println(service.getThisMonthBenefit(id8));
			break;
		case 12:
			System.out.println("��� �Ἦ �ϼ���  Ȯ���մϴ�. \n �л��� id�� �Է����ּ���.");
			String id9 = sc.next();
			System.out.println(service.getThisMonthAbscence(id9));
			break;
		case 13:
			System.out.println("��� ���� �Ἦ ���� �ϼ��� Ȯ���մϴ�. \n �л��� id�� �Է����ּ���.");
			String id10 = sc.next();
			System.out.println(service.getThisMonthAvailableAbscence(id10));
			break;
		case 14:
			System.out.println("��ü ���� �Ἦ ���� �ϼ��� Ȯ���մϴ�. \n �л��� id�� �Է����ּ���.");
			String id11 = sc.next();
			System.out.println(service.getTotalAvailableAbscence(id11));
			break;
			}
		}
	}
}
