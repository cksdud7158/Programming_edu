package curriculum.test;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import curriculum.exception.*;
import curriculum.manage.StudentManageImpl;
import curriculum.vo.*;


public class StudentScoreManaging {
	public static void main(String[] args){
		System.out.println("Start student score managing program...");
		StudentManageImpl scoreMngr = StudentManageImpl.getInstance();
		
		Map<Integer, Student> students = null;
		int menuNum, stdId=0, stdAge, currId, score = 0;
		String stdName = "";
		Student std = null;
		Curriculum cur = null;
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("�޴��� �������ּ���...");
			System.out.println("1. �л� ���		2. �л��� Ŀ��ŧ�� ���");
			System.out.println("3. ���� ���		4. �л� ����");
			System.out.println("5. ��� �л� ���� ��ȸ	6. �ݺ� �л� ���� ��ȸ");
			System.out.println("7. ��ü ���� ��ȸ		8. �ݺ� ���� ��ȸ");
			System.out.println("9. �ݺ� ��� ���� ��ȸ 10.���� ���� ���� �л� ��ȸ");
			System.out.println("11. ���� ���� ����	12.��ǥ ���� ����");
			System.out.println("13. �� ���� ����		14.���� ���� ����");
			System.out.println("15. �л� �Ѹ� ��ȸ.");
			System.out.println("0. �� ������ �ϰ� ����մϴ�.");
			
			try {
			menuNum = sc.nextInt();
				switch(menuNum) {
				
				case 1:
					System.out.println("�л��� ����մϴ�.");
					System.out.println("������ ID�� �Է��ϼ���.");
					stdId = sc.nextInt();
					System.out.println("�л��� �̸��� �Է��ϼ���.");
					stdName = sc.next();
					System.out.println("�л��� ���̸� �Է��ϼ���.");
					stdAge = sc.nextInt();
					scoreMngr.addStudent(stdId, stdName, stdAge);
					break;
				case 2:{
					System.out.println("�л��� Ŀ��ŧ���� ����մϴ�.");
					System.out.println("�л��� ID�� �Է��ϼ���.");
					stdId = sc.nextInt();
					System.out.println("����� ������ �����ϼ���. 1. Big Data, 2. AI");
					menuNum = sc.nextInt();
					try{if(menuNum==1||menuNum==2) {
						switch(menuNum) {
						case 1:
							scoreMngr.addSubjectOfStudent(stdId,  new BigData());
							break;
						case 2:
							scoreMngr.addSubjectOfStudent(stdId,  new AI());
							break;
						}
					}else
						throw new NullCurriculumException();
					}
					catch(NullCurriculumException e) {
							System.out.println(e.getMessage());
					}
					break;
					}
				case 3:
					System.out.println("�л��� ���������� ����մϴ�.");
					System.out.println("�л��� ID�� �Է��ϼ���.");
					stdId = sc.nextInt();
					try {
						std = scoreMngr.getStudent(stdId);
						cur = std.getCurriculum();
					}catch(NullPointerException e) {
						System.out.println("�ݺ� ������ �����ϴ�. �Ҽ� Ŀ��ŧ���� ������ּ���.");
					}
					if(cur instanceof BigData) menuNum = 1;
					else if(cur instanceof AI) menuNum = 2;
					else {
						System.out.println("�ݺ� ������ �����ϴ�. �Ҽ� Ŀ��ŧ���� ������ּ���.");
					}
					switch(menuNum) {
					case 1:
						System.out.println("���������� �Է��ϼ���.");
						score = sc.nextInt();
						System.out.println("��ǥ������ �Է��ϼ���. ");
						int ptScore = sc.nextInt();
						scoreMngr.registerBigdataScore(stdId, score, ptScore);
						break;
					case 2:
						System.out.println("���������� �Է��ϼ���.");
						score = sc.nextInt();
						System.out.println("���������� �Է��ϼ���.");
						int quizScore = sc.nextInt();
						System.out.println("�� ������ �Է��ϼ���.");
						int teamScore = sc.nextInt();
						scoreMngr.registerAIScore(stdId, score, quizScore, teamScore);
						break;
					}
					break;
				case 4:
					System.out.println("�л� ������ �����մϴ�.");
					System.out.println("�л��� ID�� �Է��ϼ���.");
					stdId = sc.nextInt();
					scoreMngr.deleteStudent(stdId);
					break;
				case 5:
					System.out.println("��� �л��� ������ ��ȸ�մϴ�.");
					printMapStudents(scoreMngr.getAllStudent());
					break;
				case 6:
					System.out.println("�ݺ� �л��� ������ ��ȸ�մϴ�.");
					System.out.println("���� Id�� �Է��ϼ���.");     				//����id�� ���� �� �Է����� ���
					currId = sc.nextInt();
					try {
						printMapStudents(scoreMngr.getStudentOfClass(currId)); 
					}catch (NullCurriculumException e){
						System.out.println(e.getMessage());
						System.out.println();
					}
					break;
				case 7:
					System.out.println("��ü ������ ��ȸ�մϴ�.");
					try {
						std = scoreMngr.getFirstStudent();
						System.out.println(std.toString());
					}catch (NullCurriculumException e){
						System.out.println(e.getMessage());}
					catch(NullPointerException e) {
						System.out.println("�ݺ� ������ �����ϴ�. �Ҽ� Ŀ��ŧ���� ������ּ���.");
					}
					break;
				case 8:
					System.out.println("�ݺ� ������ ��ȸ�մϴ�.");
					System.out.println("���� Id�� �Է��ϼ���.");
					currId = sc.nextInt();
					try {
						std = scoreMngr.getFirstStudent(currId);
						System.out.println(std.toString());
					}catch (NullCurriculumException e){
						System.out.println(e.getMessage());
					}catch(NullPointerException e) {
						System.out.println("�ݺ� ������ �����ϴ�. �Ҽ� Ŀ��ŧ���� ������ּ���.");
					}
					break;
				case 9:
					System.out.println("�ݺ� ��� ������ ��ȸ�մϴ�.");
					System.out.println("���� Id�� �Է��ϼ���.");
					currId = sc.nextInt();
					////�Ʒ� ����
					try {
						System.out.println(scoreMngr.getAvgScoreOfClass(currId));
					}catch (NullCurriculumException e){
						System.out.println(e.getMessage());
					}
					///
					break;
				case 10:
					System.out.println("���� ���� ���� �л����� ��ȸ�մϴ�.");
					System.out.println("������ �Է��ϼ���.");
					score = sc.nextInt();
					try {
						printMapStudents(scoreMngr.findStudentByScore(score));
					} catch (NullPointerException e) {
						System.out.println(e.getMessage());
					} //issue occur
					break;
				case 11:
					System.out.println("���������� �����մϴ�.");
					System.out.println("�л��� ID�� �Է��ϼ���.");
					stdId = sc.nextInt();
					System.out.println("���ο� ������ �Է��ϼ���.");
					score = sc.nextInt();
					scoreMngr.updateStudentScore(stdId, score);
					break;
				case 12:
					System.out.println("��ǥ������ �����մϴ�.");
					System.out.println("�л��� ID�� �Է��ϼ���.");
					stdId = sc.nextInt();
					System.out.println("���ο� ������ �Է��ϼ���.");
					score = sc.nextInt();
					scoreMngr.updatePtScore(stdId, score);
					break;
				case 13:
					System.out.println("�������� �����մϴ�.");
					System.out.println("�л��� ID�� �Է��ϼ���.");
					stdId = sc.nextInt();
					System.out.println("���ο� ������ �Է��ϼ���.");
					score = sc.nextInt();
					scoreMngr.updateTeamProjectScore(stdId, score);
					break;
				case 14:
					System.out.println("���������� �����մϴ�.");
					System.out.println("�л��� ID�� �Է��ϼ���.");
					stdId = sc.nextInt();
					System.out.println("���ο� ������ �Է��ϼ���.");
					score = sc.nextInt();
					scoreMngr.updateQuizScore(stdId, score);
					break;
				case 15:
					System.out.println("�л��Ѹ��� ��ȸ�մϴ�.");
					System.out.println("�л��� ID�� �Է��ϼ���.");
					stdId = sc.nextInt();
					System.out.println(scoreMngr.getStudent(stdId));
					break;
				case 0:
					System.out.println("�л����� �������� �ϰ� ����մϴ�.");
					scoreMngr.StudentTotalScore();
					System.out.println("����� �������ϴ�.");
					break;
				default :
					System.out.println("���α׷��� �����մϴ�...");
					System.exit(0);
				}
			}catch(InputMismatchException e) {
				System.out.println("�Է����ĸ� �߸� �Է��߽��ϴ�.");
				sc = new Scanner(System.in);
			}
		}
	}
	public static void printMapStudents(Map<Integer, Student> students){
		Set<Integer> stdSet = students.keySet();
		Iterator<Integer> it = stdSet.iterator();
		while(it.hasNext()) {
			int key = it.next();
			Student std = students.get(key);
			try{System.out.println(std.toString());}
			catch(NullPointerException e) {
				System.out.println(std.getBasicInfo());
			}
			System.out.println();
		}
	}
}