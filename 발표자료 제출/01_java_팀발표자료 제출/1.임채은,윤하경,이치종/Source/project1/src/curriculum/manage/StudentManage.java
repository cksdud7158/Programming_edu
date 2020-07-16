package curriculum.manage;
import java.util.Map;

import curriculum.exception.NullCurriculumException;
import curriculum.vo.Curriculum;
import curriculum.vo.Student;


public interface StudentManage {
	void addStudent(int stdid,String name, int age); //�л����
	void addSubjectOfStudent(int stdid,Curriculum curriculum);
	void registerBigdataScore(int stdid,int testScore,int ptScore); //���� ���(Big data)
	void registerAIScore(int stdid,int testScore,int quizScore,int teamScore); //���� ���(AI)
		
	Student getStudent(int stdId);//�л� ��ȸ

	Map<Integer, Student> getStudentOfClass(int classNumber) throws NullCurriculumException;//�ݺ� �л� ���� ��ȸ
	Map<Integer, Student> getAllStudent(); //��� �л� ���� ��ȸ
	Student getFirstStudent(int classNumber) throws NullCurriculumException; //�ݺ� ����
	Student getFirstStudent() throws NullCurriculumException; //��ü����
	int getAvgScoreOfClass(int classNumber) throws NullCurriculumException;//�ݺ� ��� ���� ���� ��ȸ
	
	Map<Integer, Student> findStudentByScore(int score) throws NullPointerException; //�������� �л�����ȸ
	
	void updateStudentScore(int stdId, int testScore); //�������� ����
	void updatePtScore(int stdid,int ptScore); //��ǥ���� ����
	void updateTeamProjectScore(int stdid,int teamScore); //��������Ʈ ���� ����
	void updateQuizScore(int stdid,int quizScore); //�������� ����
	
	void deleteStudent(int stdId);//�л� ����
	
	void StudentTotalScore(); //�л��� ���������
}