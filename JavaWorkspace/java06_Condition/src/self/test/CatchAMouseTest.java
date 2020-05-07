package self.test;

import java.util.Scanner;


public class CatchAMouseTest {

	public static String solv(int x, int y, int z) {
		if(Math.abs(x-z)>Math.abs(y-z)) return "B가 잡았다";
		else if(Math.abs(x-z)>Math.abs(y-z)) return "A가 잡았다";
		else return "쥐가 도망갔다.";
		}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//순서대로 값 입력
		System.out.println("고양이 A 숫자");
		int cata = Math.abs(sc.nextInt());
		System.out.println("고양이 B 숫자");
		int catb= Math.abs(sc.nextInt());
		System.out.println("쥐 숫자");
		int mouse= Math.abs(sc.nextInt());
		
		String result = solv(cata, catb, mouse);
		System.out.printf("Result:: %s", result);
		
		
	}


}
