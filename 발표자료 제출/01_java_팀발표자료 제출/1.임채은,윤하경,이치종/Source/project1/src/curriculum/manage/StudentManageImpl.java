package curriculum.manage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import curriculum.vo.*;
import curriculum.exception.*;

public class StudentManageImpl implements StudentManage{
	
	private Map<Integer, Student> studentMap;
	private ArrayList<Integer> currList;
	
	private static StudentManageImpl manage = new StudentManageImpl();
	private StudentManageImpl() {
		studentMap = new HashMap<Integer, Student>();
		currList = new ArrayList<Integer>();
		currList.add(1); currList.add(2);
	}
	public static StudentManageImpl getInstance() {
		return manage;
	}
	
	
	@Override
	public void addStudent(int stdId,String name, int age) {
		if(studentMap.containsKey(stdId)) {
			System.out.println(stdId+"�й����� �̹� ��ϵǾ� �ֽ��ϴ�");
		}else {
			Student st = new Student(stdId,name,age);
			studentMap.put(stdId, st);
			System.out.println(name+"���� ��ϵƽ��ϴ�");
		}
		System.out.println();
	}
	@Override
	public void addSubjectOfStudent(int stdId,Curriculum c) {
		if(studentMap.containsKey(stdId)) {
			Student st = studentMap.get(stdId);
			st.setCurriculum(c);
			System.out.println(st.getStudId()+"����"+c.getCurrName()+"Ŀ��ŧ���� ��ϵǾ����ϴ�");
		}else {
			System.out.println(stdId+"���� �����ϴ�");
		}
		System.out.println();
	}
	
	@Override
	public void registerBigdataScore(int stdId,int testScore,int ptScore) {
		if(studentMap.containsKey(stdId)) {
			Student st = studentMap.get(stdId);
			Curriculum cur = st.getCurriculum();
			try{
				if(testScore<=50&& ptScore <=50) {
					cur.setTestScore(testScore);			
					((BigData) cur).setPtScore(ptScore);
					System.out.println(st.getStudId()+"���� ������ ��ϵǾ����ϴ�.");}
				else 
					throw new ScoreException();
			}catch(ScoreException e) {
				System.out.println(e.getMessage());
			}
		}else
			System.out.println(stdId+"���� �����ϴ�");
		System.out.println();
	}
	@Override
	public void registerAIScore(int stdId,int testScore,int quizScore,int teamScore) {
		if(studentMap.containsKey(stdId)) {
			Student st = studentMap.get(stdId);
			Curriculum cur = st.getCurriculum();
			try{
				if(testScore<=50 && quizScore <=25 && teamScore <=25  ){
					cur.setTestScore(testScore);
					((AI) cur).setQuizScore(quizScore);
					((AI) cur).setTeamScore(teamScore);
					System.out.println(st.getStudId()+"���� ������ ��ϵǾ����ϴ�.");}
				else 
					throw new ScoreException();
			}catch(ScoreException e) {
				System.out.println(e.getMessage());
			}
		}else System.out.println(stdId+"���� �����ϴ�");
		System.out.println();
	}
	
	@Override
	public void StudentTotalScore() {
		Set<Integer> set=studentMap.keySet();
		for (Integer key:set) {
			Curriculum curr = studentMap.get(key).getCurriculum();
			if(curr instanceof BigData) {
				int total=((BigData)curr).getPtScore()+curr.getTestScore();
				curr.setTotalScore(total);
			}
			else if(curr instanceof AI) {
				int total=((AI)curr).getQuizScore()+((AI)curr).getTeamScore()+curr.getTestScore();
				curr.setTotalScore(total);
			}
		}
		System.out.println();
	}
	
	
	@Override
	public Map<Integer, Student> getAllStudent(){	
		return studentMap;
	}
	
	@Override 
	public Map<Integer, Student> getStudentOfClass(int classNumber) throws NullCurriculumException{
		if(!currList.contains(classNumber)) {
			throw new NullCurriculumException("���� �����Դϴ�.\n");
		}
			
		Map<Integer, Student> classStudents = new HashMap<Integer, Student>();
		Set<Integer> stdSet = studentMap.keySet();
		Iterator<Integer> it = stdSet.iterator();
		while(it.hasNext()) {
			int key = it.next();
			Student std = studentMap.get(key);
			try {
				if (std.getCurriculum().getCurrId() == classNumber) {
					classStudents.put(key,std);
				}
			}catch(NullPointerException e) {
				e.getMessage();
			}
		}
		return classStudents;
	}
	
	@Override
	public Student getFirstStudent(int classNumber) throws NullCurriculumException{
		if(!currList.contains(classNumber)) {
			throw new NullCurriculumException("���� �����Դϴ�.\n");
		}
		Student firstStudent = null;
		List<Student> list = new ArrayList<>();
		int firstScore = 0;
		
		Set<Integer> stdSet = studentMap.keySet();
		Iterator<Integer> it = stdSet.iterator();
		while(it.hasNext()) {
			int key = it.next();
			Student std = studentMap.get(key);
			try{if(std.getCurriculum().getCurrId()==classNumber) { //Ŀ��ŧ�� ����� �ȵǾ��� �л��� ���.
					list.add(std);}
			}
			catch(NullPointerException e) {
			}
		}
		for(Student st : list) {
			if(st.getCurriculum().getTotalScore()>firstScore) { //Ŀ��ŧ�� ����� �ȵ��ִ� ���.  //���� ����� �ȵ��ִ� ���
				firstStudent = st;
				firstScore = st.getCurriculum().getTotalScore();
			}
		}
		
		return firstStudent;
	}
	@Override
	public Student getFirstStudent() throws NullCurriculumException {
		Student firstStudent = null;
		try {
			int bigdataFirstStudent = getFirstStudent(1).getCurriculum().getTotalScore();
			int AIFristStudent = getFirstStudent(2).getCurriculum().getTotalScore();
		
			if(bigdataFirstStudent > AIFristStudent ){
				firstStudent = getFirstStudent(1);
			}else if(bigdataFirstStudent < AIFristStudent) {
				firstStudent = getFirstStudent(2);
			}else {
				System.out.println(getFirstStudent(1).toString());
				System.out.println(getFirstStudent(2).toString());
			}
		}
		catch (NullCurriculumException e){
			System.out.println(e.getMessage());
		}
		catch (NullPointerException e){
		}
		return firstStudent;
	}
	
	@Override
	public void deleteStudent(int stdId) {
		if(studentMap.containsKey(stdId)) {
			studentMap.remove(stdId);
		}else {
			System.out.println("�������� �ʴ� �й��Դϴ�.");
		}
		System.out.println();
	}
	
	@Override
	public void updateStudentScore(int stdId, int testScore) {
		if(studentMap.containsKey(stdId)) {
			try{studentMap.get(stdId).getCurriculum().setTestScore(testScore);
			}catch(NullPointerException e) {
				System.out.println("�ݺ� ������ �����ϴ�. �Ҽ� Ŀ��ŧ���� ������ּ���.");
				}
			try{if(testScore <=50) {
				System.out.println("���� ���� ������ �Ϸ�Ǿ����ϴ�.");}
			else{throw new ScoreException();}
			}catch(ScoreException e) {
			System.out.println(e.getMessage());}
		}else
			System.out.println("�������� �ʴ� �й��Դϴ�.");
		System.out.println();
	}
	
	@Override
	public void updatePtScore(int stdId,int ptScore) {
		if(studentMap.containsKey(stdId)) {
			Curriculum curr=studentMap.get(stdId).getCurriculum();
			if(curr instanceof BigData) {
				((BigData)curr).setPtScore(ptScore);
				try{if(ptScore <=50) {
					System.out.println("PT���� ������ �Ϸ�Ǿ����ϴ�.");}
				else {throw new ScoreException();}
				}catch(ScoreException e) {
				System.out.println(e.getMessage());}
			}
			else if(curr instanceof AI)
				{System.out.println("AI ���ǿ� PT ������ �ݿ����� �ʽ��ϴ�.");}
			else if(curr==null)
				{System.out.println("�ݺ� ������ �����ϴ�. �Ҽ� Ŀ��ŧ���� ������ּ���.");}
		}else System.out.println("�������� �ʴ� �й��Դϴ�.");
		System.out.println();
	}
	
	@Override
	public void updateTeamProjectScore(int stdId,int teamScore) {
		if(studentMap.containsKey(stdId)) {
			Curriculum curr=studentMap.get(stdId).getCurriculum();
			if(curr instanceof AI) {
				((AI)curr).setTeamScore(teamScore);
				try{if(teamScore <=25) {
					System.out.println("������ ���� ������ �Ϸ�Ǿ����ϴ�.");}
				else {throw new ScoreException();}
				}catch(ScoreException e) {
				System.out.println(e.getMessage());}
			}else if(curr instanceof BigData)
				System.out.println("BigData ���ǿ� ������ ������ �ݿ����� �ʽ��ϴ�.");
			else if(curr==null)
				System.out.println("�ݺ� ������ �����ϴ�. �Ҽ� Ŀ��ŧ���� ������ּ���.");
		}else System.out.println("�������� �ʴ� �й��Դϴ�.");
		System.out.println();
	}

	@Override
	public void updateQuizScore(int stdId,int quizScore) {
		if(studentMap.containsKey(stdId)) {
			Curriculum curr=studentMap.get(stdId).getCurriculum();
			if(curr instanceof AI) {
				((AI)curr).setQuizScore(quizScore);
				try{if(quizScore <=25) {
					System.out.println("�������� ������ �Ϸ�Ǿ����ϴ�.");}
				else {throw new ScoreException();}
				}catch(ScoreException e) {
				System.out.println(e.getMessage());}
			}
			else if(curr instanceof BigData)
				System.out.println("BigData ���ǿ� ������ ������ �ݿ����� �ʽ��ϴ�.");
			else if(curr==null)
				System.out.println("�ݺ� ������ �����ϴ�. �Ҽ� Ŀ��ŧ���� ������ּ���.");
		}else System.out.println("�������� �ʴ� �й��Դϴ�.");
		System.out.println();
	}
	
	@Override
	public Map<Integer, Student> findStudentByScore(int score) throws NullPointerException{
		Map<Integer, Student> findStudents = new HashMap<Integer, Student>();
		Set<Integer> set=studentMap.keySet();
		for (Integer key:set) {
			Student std = studentMap.get(key);
			if(std.getCurriculum() != null) {
				Curriculum curr =std.getCurriculum(); //Ŀ��ŧ������� �ȵ����� ���.
				if(curr.getTotalScore()<=score)
					findStudents.put(key,std);
			}else
				throw new NullPointerException("Ŀ��ŧ���� ��� ��ȸ�� �� �� �����ϴ�\n");
		}
		return findStudents;
	}
	@Override
	public int getAvgScoreOfClass(int classNumber) throws NullCurriculumException {
		if(!currList.contains(classNumber)) {
			throw new NullCurriculumException("���� �����Դϴ�.\n");
		}
		Set<Integer> stdSet = studentMap.keySet();
		Iterator<Integer> it = stdSet.iterator();
		Curriculum curr = null;
		int totalScore = 0;
		int studentNumber = 0;
		
		while(it.hasNext()) {
			int key = it.next();
			Student std = studentMap.get(key);
			if(classNumber == 1) {
				if (std.getCurriculum() instanceof BigData) {
					curr = std.getCurriculum();
					totalScore += curr.getTotalScore();
					studentNumber++;
				}
			}
			else if(classNumber == 2) {
				if (std.getCurriculum() instanceof AI) {
					curr = std.getCurriculum();
					totalScore += curr.getTotalScore();
					studentNumber++;
				}
			}
		}
		try{
			return totalScore / studentNumber;
		}
		catch(ArithmeticException e) {
			System.out.println("������ ������ �ֽ��ϴ�. �ٽ� Ȯ�����ּ���\n");
				return 0;
		}
	}
	
	public Student getStudent(int stdId) {
		return studentMap.get(stdId);
	}
}