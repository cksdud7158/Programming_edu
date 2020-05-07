package exam.test;
/*
 * 1. static ÇÑ ¸â¹ö´Â °´Ã¼ »ı¼º¾øÀÌ »ç¿ëÇÒ¼ö ÀÖ´Ù
 */
class Member{
	static String name ="±æ¶ËÀÌ";
	static int age = 22; //static V, class V, Àü¿ªº¯¼ö
	int count=1; //ÇÊµå, ¸â¹ö V
	
	public static void getMember() {
		System.out.println("¿ì/À¯/ºû/±ò/ "+ name);
		//System.out.println("count : "+count);
	}
	//non-static
	public  void getMember2() {
		System.out.println("¿ì/À¯/ºû/±ò/ "+ name);
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




