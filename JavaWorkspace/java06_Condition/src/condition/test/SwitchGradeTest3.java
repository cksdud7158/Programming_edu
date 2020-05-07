package condition.test;

import java.util.Scanner;

/*
 * 등급에 따라서 해당하는 case 문이 실행되도록 로직을 작성
 * 이전에 실행시 값을 성적으로 입력받았다면
 * 등급을 입력받도록 로직을 수정  
 */
public class SwitchGradeTest3 {

	public static void main(String[] args) {
		//성적에 따른 등급을 제어하는 문장을 작성
		Scanner sc = new Scanner(System.in);
		System.out.println("당신의 이름을 입력하세요...\n");	
		String name = sc.nextLine();
		System.out.println("당신의 등급을 입력하세요...\n");
		String grade = sc.nextLine();
		
		/*switch(grade) {
		case "A": System.out.println(name+", "+ grade+"입니다.");
		break;
		case "B": System.out.println(name+", "+ grade+"입니다.");
		break;
		case "C": System.out.println(name+", "+ grade+"입니다.");
		break;
		default : System.out.println("A,B,C 중 하나를 입력해 주세요");
		}
		*/
		String message = "";
		
		switch(grade) {
		case "A": message = name +" 님, 당신의 성적은 90~100입니다.";
		break;
		case "B": System.out.println(name+", "+ grade+"입니다.");
		break;
		case "C": System.out.println(name+", "+ grade+"입니다.");
		break;
		default : System.out.println("A,B,C 중 하나를 입력해 주세요");
		}
		
	}
}
