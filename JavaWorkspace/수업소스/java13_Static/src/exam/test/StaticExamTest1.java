package exam.test;
/*
 * 1. static �� ����� ��ü �������� ����Ҽ� �ִ�
 */
class Member{
	static String name ="�����";
	static int age = 22; //static V, class V, ��������
	int count=1; //�ʵ�, ��� V
	
	public static void getMember() {
		System.out.println("��/��/��/��/ "+ name);
		//System.out.println("count : "+count);
	}
	//non-static
	public  void getMember2() {
		System.out.println("��/��/��/��/ "+ name);
	}
}
public class StaticExamTest1 {
	public static void main(String[] args) {
		/*Member m = new Member();
		m.getMember();*/
		
		Member.getMember();
		//Member.getMember2();

	}
}




