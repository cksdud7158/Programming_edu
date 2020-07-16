package hrd.service;
import java.util.ArrayList;
import hrd.student.vo.*;

public interface Service {
	
//======================기본============================
	public void setMaxAttendance(String id);//수업일수초기화
	public void setAbsence(String id);//결석초기화
	public void setLate(String id);//지각초기화
	public void setVacation(String id);//휴가 초기화
	public void setYear(int year);//년도 초기화
	public void setMonth(int month); // 월 초기화 
	public void setDay(int day); // 일 초기화 
	
//	======================CURD============================
	public void AddStudent(Student s); // 학생 추가 
	public void updateLate(String id, int month, int late); // 지각 횟수 업데이트 
	public void updateAbscent(String id, int month, int abscent); // 결석한 일수 업데이트 
	public void updateVacation(String id, int vacation); // 사용한 연가 일수 업데이 
	public Student SearchID(String id);//고유ID값 반환
	public ArrayList<Student> searchName(String name);//이름으로 검색 -> 같은 이름 다른 아이디를 쓰는 학생들의 리스트를 반환
	public void DeleteStudent(String id);// 특정 학생 삭제 
	public void ShowAllStudentInfo(); // 모든 학생 데이터 출
	///=====================기능========================
	public int getRemainVacation(String id); // 남은 휴가 출력
	public ArrayList<Double> getThisMonthAttendanceRate(String id);//이달 출석일수와 출석률 출력
	public ArrayList<Double> getTotalAttendanceRate(String id); //오늘일자까지 출석일수와 출석률 출력
	public double getThisMonthBenefit(String id); //이번달 수당 출력
	public int getThisMonthAbscence(String id); //이달 결석일수 출력
	public int getThisMonthAvailableAbscence(String id);	//이달 결석가능일수 출력
	public int getTotalAvailableAbscence(String id);		//교육기간 전체 결석가능일수 출력(지금까지 결석, 지각 고려)
	
	
	
	

	
	

}
