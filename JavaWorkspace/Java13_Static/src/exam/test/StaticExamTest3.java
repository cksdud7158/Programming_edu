package exam.test;
//static block
public class StaticExamTest3 {
	static int i;
	
	public static void main(String[] args) {
		System.out.println("1. main method static block..." + i);
		//객체 생성..();  ---> (){///}
		// 
	}
	
	
	static {
		i=300;
		System.out.println("2.static initialization block..." + i);
	}
	/* 실행 결과
	 *  2.static block...300
		1. main method static block...300
		main이 먼저 실행되지 않는다. 
		
		메인보다 먼저 실행되는것은 static 초기화 block 가 먼저 진행됨 -> 글로벌한 변수를 먼저 받음 
		
		 
	 */
}
