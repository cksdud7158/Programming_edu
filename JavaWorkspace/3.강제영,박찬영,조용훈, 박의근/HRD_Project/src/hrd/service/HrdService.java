package hrd.service;

import java.util.ArrayList;

import hrd.student.vo.Student;
import hrd.vo.Date;

public class HrdService {

	static int year, month, day;
	private ArrayList<Student> list;
	public ArrayList<Integer> days = new ArrayList<Integer>();

	// 싱글톤
	private static HrdService service = new HrdService();

	private HrdService() {
		list = new ArrayList<>();
	}

	public static HrdService getInstance() {
		return service;
	}

	public void setToday(int year, int month, int day) {
		HrdService.year = year;
		HrdService.month = month;
		HrdService.day = day;
	}

	public void AddStudent(Student s) {
		boolean find = false;
		for (Student std : list) {
			if (std.getId().equals(std.getId())) {
				find = true;
				System.out.println(std.getName() + "은 이미 등록되어있습니다. ");
				return;
			}
		}
		if (find == false) { // 기존 리스에 없다.
			list.add(s);
			System.out.println(s.getName() + "님이 정상 등록되셨습니다.");
		}
		list.add(s);

	}

	public void updateLate(String id, int month, int late) {
		boolean find = false;
		for (Student s : list) {
			if (s.getId().equals(id)) {
				find = true;
				System.out.println(s.getName() + " 님의 출결 정보를 변경합니다.");
				s.getAttendance().getLate().set(month - 4, late);
			}
		}

		if (find == false)
			System.out.println(id + " 와 일치하는 회원님은 목록에 없습니다.");
	}

	public void updateAbscent(String id, int month, int abscent) {
		boolean find = false;
		for (Student s : list) {
			if (s.getId().equals(id)) {
				find = true;
				System.out.println(s.getName() + " 님의 출결 정보를 변경합니다.");
				s.getAttendance().getAbscent().set(month - 4, abscent);
			}
		}

		if (find == false)
			System.out.println(id + " 와 일치하는 회원님은 목록에 없습니다.");

	}

	public ArrayList<Student> SearchStudent(String id) {
		ArrayList<Student> temp = new ArrayList<>();
		boolean find = false;
		for (Student s : list) {
			if (s.getId().contains(id)) {
				find = true;
				temp.add(s);
			}
		}
		if (find == false)
			System.out.println(id + " 와/과 관련된 회원님은 목록에 없습니다.");

		return temp;
	}

	public void DeleteStudent(String id) {
		boolean find = false;
		for (Student s : list) {
			if (s.getId().equals(id)) {
				System.out.println(s.getName() + " 님의 정보를 삭제합니다.");
				find = true;
				list.remove(s);
				break;
			}
		}
		if (find == false)
			System.out.println(id + " 와/과 관련된 회원님은 목록에 없습니다.");

	}

	public ArrayList<Student> ShowAllStudentInfo() {
		return list;
	}

	public int getRemainVacation(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<Double> getThisMonthAttendanceRate(String id) {
		ArrayList<Double> temp = new ArrayList<Double>();
		double thisMonthAttendance = 0.0;
		double thisMonthAttendanceRate = 0.0;
		for (Student s : list) {
			if (s.getId().equals(id)) {
				thisMonthAttendance = s.getAttendance().getAttendace().get(month - 4);
				thisMonthAttendanceRate = thisMonthAttendance / Date.getThisMonth(year, month, day); // **** / *100 (이달에
																										// 총 수업일수)
				temp.add(thisMonthAttendance); // 출석일수를 0번째 인덱스에
				temp.add(thisMonthAttendanceRate); // 출석율은 1번째 인덱스에
			}
		}
		return temp;
	}

	public ArrayList<Double> getTotalAttendanceRate(String id, int thismonth) {
		ArrayList<Double> temp = new ArrayList<Double>();
		/*
		 * double totalAttendance = 0.0; double totalAttendanceRate = 0.0; for(int
		 * i=0;i<thismonth-4;i++) { double pastTotalAttendance =
		 * Date.getAttendace().get(i); } for(Student s : Student) {
		 * 
		 * if(s.getId().equals(id)) {
		 * 
		 * totalAttendance += thismont~~;
		 * 
		 * } }
		 */
		return temp;
	}

	public double getThisMonthBenefit(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getThisMonthAttendance(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getThisMonthAbscence(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getThisMonthAvailableAbscence(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getTotalAvailableAbscence(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
