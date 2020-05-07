package self.test;

import java.util.Scanner;

class CatchAMouseTest{
	public static String solv(int x, int y, int z) {
		if(Math.abs(x-z)>Math.abs(y-z)) return "CatB Catch!!";
		else if(Math.abs(x-z)<Math.abs(y-z)) return "CatA Catch!!";
		else return "Mouse Escape!!";		
	}
	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		//순서대로 값을 입력받고
		int cata = sc.nextInt();
		int catb = sc.nextInt();
		int mouse = sc.nextInt();
		String result = solv(cata, catb, mouse);
		System.out.printf("Result :: %s", result);
	}
}






