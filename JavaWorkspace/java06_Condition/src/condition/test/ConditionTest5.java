package condition.test;

public class ConditionTest5 {

	public static void main(String[] args) {
		//1~6사이의 랜덤한 정수가 할당되도록...
		int dice=(int)(Math.random()*6+1); 
		
		if(dice==1)System.out.println("dice="+dice);
		else if(dice==2)System.out.println("dice="+dice);
		else if(dice==3)System.out.println("dice="+dice);
		else if(dice==4)System.out.println("dice="+dice);
		else if(dice==5)System.out.println("dice="+dice);
		else System.out.println("dice="+dice);

	}

}
