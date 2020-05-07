package condition.test;

import java.util.Random;

/*
 * formating과 삼항연산자
 */

public class ConditionTest6 {

	public static void main(String[] args) {
		String result = "";
		Random r = new Random();
		
		System.out.println("=====큰수 or 작은수?");
		//0~99 사이의 임의의 정수
		int num1 = r.nextInt(100);
		
		if(num1>50) result="큰수";
		else result= "작은수";
		
		System.out.println(num1+"은"+result+"입니다");
		System.out.printf("%d는(은) %s 입니다.",num1, result);
		
		int num2 = r.nextInt(10)+1; //1~10
		if(num2%2==0) result="짝수";//짝수
		else result = "홀수";
		System.out.printf("%d는 %s 이다",num2, result);
		
		System.out.println("==========삼항 연산자");
		//삼항 연사자의 결과는 불리언으로 나와야함
		result = (num2%2==0)? "짝수":"홀수"; // true 면 짝수 false 면 홀수
		System.out.printf("%d는 %s 이다",num2, result);

				
	}

}
