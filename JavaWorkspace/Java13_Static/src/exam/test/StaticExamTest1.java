package exam.test;
/*
 * static�� ����� ��ü �������� ����� �� �ִ�
 */
class Member{
	static String name ="�浿��";
	static int age =22; //static ����, class ����, ���� ����
	int count = 1; //field, ��� ����
	// static
	public static void getMember() {
		System.out.println("��������"+name);
		//System.out.println("count" + count));
	}
	// non-static
	public void getMember2() {
		System.out.println("��������"+name);
	}
}


public class StaticExamTest1 {
	public static void main(String[] args) {
/*		Member m = new Member();
		m.getMember();*/
		Member.getMember();
		//static �� static ���� ���Ѵ�.  -> main �ȿ����� static �� ��ü�� ��� ���� ��, �޸𸮿� �÷�����
		//Member.getMember2();
	}

}
