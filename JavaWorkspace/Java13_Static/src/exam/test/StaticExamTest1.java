package exam.test;
/*
 * static한 멤버는 객체 생성없이 사용할 수 있다
 */
class Member{
	static String name ="길동이";
	static int age =22; //static 변수, class 변수, 전역 변수
	int count = 1; //field, 멤버 변수
	// static
	public static void getMember() {
		System.out.println("우유빛깔"+name);
		//System.out.println("count" + count));
	}
	// non-static
	public void getMember2() {
		System.out.println("우유빛깔"+name);
	}
}


public class StaticExamTest1 {
	public static void main(String[] args) {
/*		Member m = new Member();
		m.getMember();*/
		Member.getMember();
		//static 은 static 끼리 통한다.  -> main 안에서는 static 한 객체만 사용 가능 즉, 메모리에 올려야함
		//Member.getMember2();
	}

}
