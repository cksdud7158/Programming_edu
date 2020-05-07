package test;

public class FighterTest {

	public static void main(String[] args) {
		Fighter f = new Fighter();
		if(f instanceof Unit) {
			System.out.println("f는 Unit의 자손입니다.");
		}
		if(f instanceof Movable) {
			System.out.println("f는 Movable의 자손입니다.");
		}
		if(f instanceof Fightable) {
			System.out.println("f는 Fightable의 자손입니다.");
		}
	}

}

class Unit{
	int currentHP; //유닛의 체력
	int x; // 유닛의 위치
	int y; // 유닛의 위치
}

interface Movable{
	void move(int x, int y);
}

interface attackable{
	void attack(Unit u);
}
// 인터페이스 끼리 상속하면 얻어지는 이득 -> 기능의 강화 
interface Fightable extends Movable, attackable {}

class Fighter extends Unit implements Fightable{ //상속을 받은 후에 임플리먼트 해야함

	@Override
	public void move(int x, int y) {
		
	}

	@Override
	public void attack(Unit u) {
		
	}
	
}




