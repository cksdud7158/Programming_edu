package condition.test;
/*
 * Math.random()와 함께
 * switch 문에서의 break 키워드에 대해서 살펴보자.
 */
public class SwitchNoBreakTest4 {

	public static void main(String[] args) {
		// Math. 뒤에 나오는 키워드에는 S가 붙어있다 이는 Stactic를 나타내는데 메모리에 올라가있어야 사용 가능, 객체 생성을 따로 안해도됨
		/*double d=Math.random();
		System.out.println(d);
		
		int x=(int)(Math.random()*4)+1; // 1~4사이의 랜덤한 정수가 나옴 
		System.out.println(x);*/
		
		//8~11사이의 랜덤한 정수
		int time=(int)(Math.random()*4+8);
		System.out.println("[현재시간 : "+time+ " 시]");
		
		
		switch(time) {
			case 8:
				System.out.println("출근합니다.");
			case 9:
				System.out.println("오전 회의 합니다.");
			case 10:
				System.out.println("오전 업무 봅니다.");
			case 11:
				System.out.println("외근나갑니다.");
		}
	}

}
