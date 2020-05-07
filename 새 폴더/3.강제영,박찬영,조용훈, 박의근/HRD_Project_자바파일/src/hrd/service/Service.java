package hrd.service;
import java.util.ArrayList;
import hrd.student.vo.*;

public interface Service {
	
//======================�⺻============================
	public void setMaxAttendance(String id);//�����ϼ��ʱ�ȭ
	public void setAbsence(String id);//�Ἦ�ʱ�ȭ
	public void setLate(String id);//�����ʱ�ȭ
	public void setVacation(String id);//�ް� �ʱ�ȭ
	public void setYear(int year);//�⵵ �ʱ�ȭ
	public void setMonth(int month); // �� �ʱ�ȭ 
	public void setDay(int day); // �� �ʱ�ȭ 
	
//	======================CURD============================
	public void AddStudent(Student s); // �л� �߰� 
	public void updateLate(String id, int month, int late); // ���� Ƚ�� ������Ʈ 
	public void updateAbscent(String id, int month, int abscent); // �Ἦ�� �ϼ� ������Ʈ 
	public void updateVacation(String id, int vacation); // ����� ���� �ϼ� ������ 
	public Student SearchID(String id);//����ID�� ��ȯ
	public ArrayList<Student> searchName(String name);//�̸����� �˻� -> ���� �̸� �ٸ� ���̵� ���� �л����� ����Ʈ�� ��ȯ
	public void DeleteStudent(String id);// Ư�� �л� ���� 
	public void ShowAllStudentInfo(); // ��� �л� ������ ��
	///=====================���========================
	public int getRemainVacation(String id); // ���� �ް� ���
	public ArrayList<Double> getThisMonthAttendanceRate(String id);//�̴� �⼮�ϼ��� �⼮�� ���
	public ArrayList<Double> getTotalAttendanceRate(String id); //�������ڱ��� �⼮�ϼ��� �⼮�� ���
	public double getThisMonthBenefit(String id); //�̹��� ���� ���
	public int getThisMonthAbscence(String id); //�̴� �Ἦ�ϼ� ���
	public int getThisMonthAvailableAbscence(String id);	//�̴� �Ἦ�����ϼ� ���
	public int getTotalAvailableAbscence(String id);		//�����Ⱓ ��ü �Ἦ�����ϼ� ���(���ݱ��� �Ἦ, ���� ���)
	
	
	
	

	
	

}
