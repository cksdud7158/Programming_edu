package condition.test;

public class ConditionTest5 {

	public static void main(String[] args) {
		int dice = (int)(Math.random()*6)+1;
		
		if(dice==1) System.out.println("Dice 1");
		else if(dice==2) System.out.println("Dice 2");
		else if(dice==3) System.out.println("Dice 3");
		else if(dice==4) System.out.println("Dice 4");
		else if(dice==5) System.out.println("Dice 5");
		else System.out.println("Dice 6");

	}

}
