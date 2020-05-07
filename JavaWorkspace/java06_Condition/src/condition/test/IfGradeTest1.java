package condition.test;
/*
 * 주어진 조건이 참일 때만 해당 코드블록을 수행함
 * 문장의 흐름을 제어함으로써 좀더 정교힌 프로그램이 만들어 질수 있습니다.
 * ::
 * if(blooean expression)/ else if(blooean expression)/ else
 * switch~case
 * 
 * 
 */
public class IfGradeTest1 {

	public static void main(String[] args) {
		//성적에 따른 등급을 제어하는 문장을 작성
		int grade= 87;
		
		/*if(grade>=90 && grade<=100) {
			System.out.println("A Grade");
		}
		else if(grade>=80 && grade<=90) {
			System.out.println("B Grade");
		}
		else if(grade>=70 && grade<=80) {
			System.out.println("C Grade");
		}
		else {
			System.out.println("Try Again");
		}*/
		if(grade>=90 && grade<=100) System.out.println("A Grade");
		else if(grade>=80 && grade<=90)System.out.println("B Grade");
		else if(grade>=70 && grade<=80)System.out.println("C Grade");
		else System.out.println("Try Again");
		
	}

}
