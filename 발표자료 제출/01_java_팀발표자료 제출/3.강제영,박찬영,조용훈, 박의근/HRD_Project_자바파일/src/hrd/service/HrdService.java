package hrd.service;

import java.util.ArrayList;
import java.util.Calendar;

import hrd.student.vo.Student;

public class HrdService implements Service{
	
	public static int[] days = {15,17,22,20,21,19};	//index +4 => month, 4월 수업일수 15일로 수정했습니다
	public static int year,month,day;
	private ArrayList<Student> list;
	
	//싱글톤
	private static HrdService service = new HrdService();	
	
	private HrdService(){
		list = new ArrayList<>();
	}
	
	public static HrdService getInstance() {
		return service;
	}
	//오늘날짜 초기화
	public void setYear(int year) {
		HrdService.year = year;
	}
	public void setMonth(int month) {
		HrdService.month = month;
	}
	public void setDay(int day) {
		HrdService.day = day;
	}
	
	//목록에 학생 추가
	public void AddStudent(Student s) {
		boolean find = false;
		for(Student std : list) {
			if(std.getId().equals(s.getId())) {
				find = true;
				System.out.println(std.getName()+"은 이미 등록되어있습니다. ");
				return;
			}
		}
		if(find==false) { //기존 리스에 없다.
			list.add(s);
		System.out.println(s.getName()+"님이 정상 등록되셨습니다.");
		}
	}
	
	// 출석초기화
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
	
	// 결석초기화
	public void setAbsence(String id) {
		ArrayList<Integer> minabscent = new ArrayList<Integer>();//<0,0>
		for(int i=0; i<month-3;i++) minabscent.add(0);
		for(Student s : list) {
			if(s.getId().equals(id)) {
				s.getAttendance().getAbscent().addAll(minabscent);
			}
		}
	}
	
	// 지각초기화
	public void setLate(String id) {
		ArrayList<Integer> minlate = new ArrayList<Integer>();//<0,0>
		for(int i=0; i<month-3;i++) minlate.add(0);
		for(Student s : list) {
			if(s.getId().equals(id)) {
				s.getAttendance().getLate().addAll(minlate);
			}
		}
	}
	// 휴가 초기화
	public void setVacation(String id) {
		Student s = SearchID(id);
		if(s==null)
			return;
		s.getAttendance().setVacation(month-4); 	//4월 - 휴가 0, 5월 휴가 1, 6월 휴가 2 ----
	}
	
	static Calendar cal = Calendar.getInstance(); 		//default calendar is set today

	//cal.get(Calendar.MONTH)
	public int getThisMonth(int year,int month, int date) {
		month=month-1;// Jan=0, Feb=1---
		cal.set(year,month,date);
		int today=date;
		int days=0;
		for(int i = 1; i<=today;i++) {			//공휴일 계산
			switch(month){
				case 3:
					if(i<6)
						continue;	//개강

					else if(15<=i && i<=17)
						continue; //선거일~징검다리 휴일, 주말포함
					
					else if(i==30)	//석가탄신일
						continue;
					else
						break;
				case 4:
					if(i==1 || i==4 || i==5 || i==15)
						continue;
					else
						break;
				case 6:
					if(17<=i && i<=21)	//여름휴가
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
				System.out.println(s.getName()+" 님의 "+month+" 월 지각회수를 "+ late+" 회로 변경합니다.");
				s.getAttendance().getLate().set(month-4, late);
			}
		}	
		if(find == false) System.out.println(id+" 와 일치하는 회원님은 목록에 없습니다.");
	}

	public void updateAbscent(String id, int month, int abscent) {
		boolean find = false;
		for(Student s : list) {
			if(s.getId().equals(id)) {
				find = true;
				System.out.println(s.getName()+" 님의 "+month+" 월 결석회수를 "+ abscent+" 회로 변경합니다.");
				s.getAttendance().getAbscent().set(month-4, abscent);
			}
		}
		
		if(find == false) System.out.println(id+" 와 일치하는 회원님은 목록에 없습니다.");
		
	}
	// vacation update 추가, 휴가 사용일수를 입력하면 남은 휴가일수를 반환
	public void updateVacation(String id, int vacation) {
		for(Student s : list) {
			if(s.getId().contains(id)) {
				if(s.getAttendance().getVacation()-vacation<0) {
					System.out.println("남은 휴가가 없습니다.");
					break;
				}else {
				System.out.println(s.getName()+" 님은 휴가를 "+ vacation +" 일만큼 더 사용합니다.");
				s.getAttendance().setVacation(s.getAttendance().getVacation()-vacation);
				}
			}
		}
		
	}
	
	// 고유ID값 반환
	public Student SearchID(String id) {
		for(Student s : list) {
			if(s.getId().contains(id)) {
				return s;
			}
		}
		System.out.println(id+" 와/과 관련된 회원님은 목록에 없습니다.");
		return null;
	}
	
	//  이름으로 검색 -> 같은 이름 다른 아이디를 쓰는 학생들의 리스트를 반환
	public ArrayList<Student> searchName(String name) {
		ArrayList<Student> temp = new ArrayList<>();
		boolean find = false;
		for(Student s : list) {
			if(s.getName().contains(name)) {
				find=true;
				System.out.println(name+"님 와/과 관련된 회원님의 정보를 출력합니다.");
				temp.add(s);
			}
		}
		if(find==false) System.out.println(name+" 와/과 관련된 회원님은 목록에 없습니다.");
		return temp;
	}

	public void DeleteStudent(String id) {
		boolean find = false;
		for(Student s : list) {
			if(s.getId().equals(id)) {
				System.out.println(s.getName()+ " 님의 정보를 삭제합니다.");
				find = true;
				list.remove(s);
				break;
			}
		}
		if(find==false) System.out.println(id+" 와/과 관련된 회원님은 목록에 없습니다.");
		
	}
	
	//모든 정보 출력
	public void ShowAllStudentInfo() {
		for(Student s: list) System.out.println(s);	
	}

	public int getRemainVacation(String id) {
		Student s = SearchID(id);	
		return s.getAttendance().getVacation();
	}
	
	/*// 업데이트된 지각을 결석으로 치환
	public void finalAttendance() {
		int finalAbsence = 
	}*/
	
	// 이달 출석수와 출석률 산출
	public ArrayList<Double> getThisMonthAttendanceRate(String id) {
		ArrayList<Double> temp = new ArrayList<Double>(); 
		double thisMonthAttendance = 0.0;
		double thisMonthAttendanceRate = 0.0;
		for(Student s : list) {
			if(s.getId().equals(id)) {
				thisMonthAttendance =  s.getAttendance().getAttendace().get(month-4)//rawAttendacne(
										-s.getAttendance().getAbscent().get(month-4)//absence
										-s.getAttendance().getLate().get(month-4)/3; //late
				thisMonthAttendanceRate = Math.round(thisMonthAttendance/(double) getThisMonth(year, month, day)*10000)/100; //**** / *100 (이달에 총 수업일수)
				temp.add(Math.floor(thisMonthAttendance)); // 출석일수를 0번째 인덱스에
				temp.add(thisMonthAttendanceRate); // 출석율은 1번째 인덱스에
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
		
		// 출석일 구하기
		for(Student s : list) {
			if(s.getId().equals(id)) {
				for(int i=0;i<month-3;i++) {
					totalMaxAttendace += (double)s.getAttendance().getAttendace().get(i);
					totalAbcsence += (double)s.getAttendance().getAbscent().get(i);
					totalLate += (double)s.getAttendance().getLate().get(i);
				}
				totalAttendance = totalMaxAttendace - totalAbcsence - totalLate/3;
				totalAttendanceRate = Math.round(totalAttendance/totalMaxAttendace*10000)/100;
				temp.add(Math.floor(totalAttendance)); // 출석일수를 0번째 인덱스에
				temp.add(totalAttendanceRate); // 출석율은 1번째 인덱스에
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
				(int)Math.floor(s.getAttendance().getAttendace().get(month-4)*0.2) //이달총수업일수*0.2=80%수준의 출석률
				-  s.getAttendance().getAbscent().get(month-4) // 해당월 결석일수
				-  s.getAttendance().getLate().get(month-4)/3; // 해당월 지각일수 ==> 지각 *3 = 1결석
				return temp;
			}
		}
		return 0;
	}

	public int getTotalAvailableAbscence(String id) {
		int temp;
		int totalMaxAttendace = 0; // 교육과정 전체 수업일수
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
				(int) Math.floor(totalMaxAttendace*0.2) // 해당달+전달까지의 총수업일수*0.2=80%수준의 출석률
				- totalAbscence
				- totalLate/3; // 이때까지의 결석일수
				return temp;
			}
		}
		return 0;
	}

	

}
