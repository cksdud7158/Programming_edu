package hrd.service;

import java.util.ArrayList;
import java.util.Calendar;

import hrd.student.vo.Student;

public class HrdService implements Service{
	
	public static int[] days = {15,17,22,20,21,19};	//index +4 => month, 4�� �����ϼ� 15�Ϸ� �����߽��ϴ�
	public static int year,month,day;
	private ArrayList<Student> list;
	
	//�̱���
	private static HrdService service = new HrdService();	
	
	private HrdService(){
		list = new ArrayList<>();
	}
	
	public static HrdService getInstance() {
		return service;
	}
	//���ó�¥ �ʱ�ȭ
	public void setYear(int year) {
		HrdService.year = year;
	}
	public void setMonth(int month) {
		HrdService.month = month;
	}
	public void setDay(int day) {
		HrdService.day = day;
	}
	
	//��Ͽ� �л� �߰�
	public void AddStudent(Student s) {
		boolean find = false;
		for(Student std : list) {
			if(std.getId().equals(s.getId())) {
				find = true;
				System.out.println(std.getName()+"�� �̹� ��ϵǾ��ֽ��ϴ�. ");
				return;
			}
		}
		if(find==false) { //���� ������ ����.
			list.add(s);
		System.out.println(s.getName()+"���� ���� ��ϵǼ̽��ϴ�.");
		}
	}
	
	// �⼮�ʱ�ȭ
	public void setMaxAttendance(String id) {
		ArrayList<Integer> MaxAttendance = new ArrayList<Integer>();//15,17,22,20,21,19>
		for(int i=0;i<month-4;i++) {
			MaxAttendance.add(HrdService.days[i]);
		}
		MaxAttendance.add(getThisMonth(HrdService.year, HrdService.month, HrdService.day));
		for(Student s : list) {
			if(s.getId().equals(id)) {
				s.getAttendance().getAttendace().addAll(MaxAttendance);
			}
		}
	}
	
	// �Ἦ�ʱ�ȭ
	public void setAbsence(String id) {
		ArrayList<Integer> minabscent = new ArrayList<Integer>();//<0,0>
		for(int i=0; i<month-3;i++) minabscent.add(0);
		for(Student s : list) {
			if(s.getId().equals(id)) {
				s.getAttendance().getAbscent().addAll(minabscent);
			}
		}
	}
	
	// �����ʱ�ȭ
	public void setLate(String id) {
		ArrayList<Integer> minlate = new ArrayList<Integer>();//<0,0>
		for(int i=0; i<month-3;i++) minlate.add(0);
		for(Student s : list) {
			if(s.getId().equals(id)) {
				s.getAttendance().getLate().addAll(minlate);
			}
		}
	}
	// �ް� �ʱ�ȭ
	public void setVacation(String id) {
		Student s = SearchID(id);
		if(s==null)
			return;
		s.getAttendance().setVacation(month-4); 	//4�� - �ް� 0, 5�� �ް� 1, 6�� �ް� 2 ----
	}
	
	static Calendar cal = Calendar.getInstance(); 		//default calendar is set today

	//cal.get(Calendar.MONTH)
	public int getThisMonth(int year,int month, int date) {
		month=month-1;// Jan=0, Feb=1---
		cal.set(year,month,date);
		int today=date;
		int days=0;
		for(int i = 1; i<=today;i++) {			//������ ���
			switch(month){
				case 3:
					if(i<6)
						continue;	//����

					else if(15<=i && i<=17)
						continue; //������~¡�˴ٸ� ����, �ָ�����
					
					else if(i==30)	//����ź����
						continue;
					else
						break;
				case 4:
					if(i==1 || i==4 || i==5 || i==15)
						continue;
					else
						break;
				case 6:
					if(17<=i && i<=21)	//�����ް�
						continue;
					else
						break;
				case 8:
					if(i>=25)
						continue;
					break;
			}
			
			cal.set(year,month,i);
			if(cal.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY || cal.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY)
				continue;
			days++;
		}
		return days;
	}
	//update
	public void updateLate(String id, int month, int late) {
		boolean find = false;
		for(Student s : list) {
			if(s.getId().equals(id)) {
				find = true;
				System.out.println(s.getName()+" ���� "+month+" �� ����ȸ���� "+ late+" ȸ�� �����մϴ�.");
				s.getAttendance().getLate().set(month-4, late);
			}
		}	
		if(find == false) System.out.println(id+" �� ��ġ�ϴ� ȸ������ ��Ͽ� �����ϴ�.");
	}

	public void updateAbscent(String id, int month, int abscent) {
		boolean find = false;
		for(Student s : list) {
			if(s.getId().equals(id)) {
				find = true;
				System.out.println(s.getName()+" ���� "+month+" �� �Ἦȸ���� "+ abscent+" ȸ�� �����մϴ�.");
				s.getAttendance().getAbscent().set(month-4, abscent);
			}
		}
		
		if(find == false) System.out.println(id+" �� ��ġ�ϴ� ȸ������ ��Ͽ� �����ϴ�.");
		
	}
	// vacation update �߰�, �ް� ����ϼ��� �Է��ϸ� ���� �ް��ϼ��� ��ȯ
	public void updateVacation(String id, int vacation) {
		for(Student s : list) {
			if(s.getId().contains(id)) {
				if(s.getAttendance().getVacation()-vacation<0) {
					System.out.println("���� �ް��� �����ϴ�.");
					break;
				}else {
				System.out.println(s.getName()+" ���� �ް��� "+ vacation +" �ϸ�ŭ �� ����մϴ�.");
				s.getAttendance().setVacation(s.getAttendance().getVacation()-vacation);
				}
			}
		}
		
	}
	
	// ����ID�� ��ȯ
	public Student SearchID(String id) {
		for(Student s : list) {
			if(s.getId().contains(id)) {
				return s;
			}
		}
		System.out.println(id+" ��/�� ���õ� ȸ������ ��Ͽ� �����ϴ�.");
		return null;
	}
	
	//  �̸����� �˻� -> ���� �̸� �ٸ� ���̵� ���� �л����� ����Ʈ�� ��ȯ
	public ArrayList<Student> searchName(String name) {
		ArrayList<Student> temp = new ArrayList<>();
		boolean find = false;
		for(Student s : list) {
			if(s.getName().contains(name)) {
				find=true;
				System.out.println(name+"�� ��/�� ���õ� ȸ������ ������ ����մϴ�.");
				temp.add(s);
			}
		}
		if(find==false) System.out.println(name+" ��/�� ���õ� ȸ������ ��Ͽ� �����ϴ�.");
		return temp;
	}

	public void DeleteStudent(String id) {
		boolean find = false;
		for(Student s : list) {
			if(s.getId().equals(id)) {
				System.out.println(s.getName()+ " ���� ������ �����մϴ�.");
				find = true;
				list.remove(s);
				break;
			}
		}
		if(find==false) System.out.println(id+" ��/�� ���õ� ȸ������ ��Ͽ� �����ϴ�.");
		
	}
	
	//��� ���� ���
	public void ShowAllStudentInfo() {
		for(Student s: list) System.out.println(s);	
	}

	public int getRemainVacation(String id) {
		Student s = SearchID(id);	
		return s.getAttendance().getVacation();
	}
	
	/*// ������Ʈ�� ������ �Ἦ���� ġȯ
	public void finalAttendance() {
		int finalAbsence = 
	}*/
	
	// �̴� �⼮���� �⼮�� ����
	public ArrayList<Double> getThisMonthAttendanceRate(String id) {
		ArrayList<Double> temp = new ArrayList<Double>(); 
		double thisMonthAttendance = 0.0;
		double thisMonthAttendanceRate = 0.0;
		for(Student s : list) {
			if(s.getId().equals(id)) {
				thisMonthAttendance =  s.getAttendance().getAttendace().get(month-4)//rawAttendacne(
										-s.getAttendance().getAbscent().get(month-4)//absence
										-s.getAttendance().getLate().get(month-4)/3; //late
				thisMonthAttendanceRate = Math.round(thisMonthAttendance/(double) getThisMonth(year, month, day)*10000)/100; //**** / *100 (�̴޿� �� �����ϼ�)
				temp.add(Math.floor(thisMonthAttendance)); // �⼮�ϼ��� 0��° �ε�����
				temp.add(thisMonthAttendanceRate); // �⼮���� 1��° �ε�����
			}
		}
		return temp;
	}
	
	public ArrayList<Double> getTotalAttendanceRate(String id) {
		ArrayList<Double> temp = new ArrayList<Double>(); 
		double totalAttendance = 0.0;
		double totalAttendanceRate = 0.0;
		double totalMaxAttendace =0.0;
		double totalAbcsence=0.0;
		double totalLate=0.0;
		
		// �⼮�� ���ϱ�
		for(Student s : list) {
			if(s.getId().equals(id)) {
				for(int i=0;i<month-3;i++) {
					totalMaxAttendace += (double)s.getAttendance().getAttendace().get(i);
					totalAbcsence += (double)s.getAttendance().getAbscent().get(i);
					totalLate += (double)s.getAttendance().getLate().get(i);
				}
				totalAttendance = totalMaxAttendace - totalAbcsence - totalLate/3;
				totalAttendanceRate = Math.round(totalAttendance/totalMaxAttendace*10000)/100;
				temp.add(Math.floor(totalAttendance)); // �⼮�ϼ��� 0��° �ε�����
				temp.add(totalAttendanceRate); // �⼮���� 1��° �ε�����
			}
		}
		return temp;
	}

	public double getThisMonthBenefit(String id) {
		Student s = SearchID(id);
		if(s==null)
			return 0;
		if(s.getBenefit().getAllowance() * getThisMonth(year,month,day)>284000) {
			return 284000;
		}else {
		return s.getBenefit().getAllowance() * getThisMonth(year,month,day);
		}
	}

	public int getThisMonthAbscence(String id) {
		for(Student s : list) {
			if(s.getId().equals(id)) {
				return s.getAttendance().getAbscent().get(month-4); 
			}
		}
		return 0;
	}

	public int getThisMonthAvailableAbscence(String id) {
		int temp;
		for(Student s : list) {
			if(s.getId().equals(id)) {
				temp=
				(int)Math.floor(s.getAttendance().getAttendace().get(month-4)*0.2) //�̴��Ѽ����ϼ�*0.2=80%������ �⼮��
				-  s.getAttendance().getAbscent().get(month-4) // �ش�� �Ἦ�ϼ�
				-  s.getAttendance().getLate().get(month-4)/3; // �ش�� �����ϼ� ==> ���� *3 = 1�Ἦ
				return temp;
			}
		}
		return 0;
	}

	public int getTotalAvailableAbscence(String id) {
		int temp;
		int totalMaxAttendace = 0; // �������� ��ü �����ϼ�
		int totalAbscence = 0;
		int totalLate=0;
		for(Student s : list) {
			if(s.getId().equals(id)) {
				for(int i=0;i<HrdService.days.length;i++) {
					totalMaxAttendace += HrdService.days[i]; 
				}
				for(int i=0;i<month-3;i++) {
					totalAbscence += s.getAttendance().getAbscent().get(i);
					totalLate += s.getAttendance().getLate().get(i);
				}
				temp=
				(int) Math.floor(totalMaxAttendace*0.2) // �ش��+���ޱ����� �Ѽ����ϼ�*0.2=80%������ �⼮��
				- totalAbscence
				- totalLate/3; // �̶������� �Ἦ�ϼ�
				return temp;
			}
		}
		return 0;
	}

	

}
