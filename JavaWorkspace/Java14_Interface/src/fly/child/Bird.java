package fly.child;

import fly.Flyer;

/*
 * Flyer 를 상속받은 자식 클래스 
 * 인터페이스를 부모로 둔 자식은 (Bird) 반드시 부모가 가진 모든 추상 메소드를 다 구현해야만 한다.
 * 클래스와 인터페이스의 차이 추상화
 * 
 * 인터페이스는 추상화로만 이루어져야한다. 
 * 클래스는 객체화 되야함 따라서 추상성이 존재하면 안됨
 * 
 * 인터페이스는 다중 상속 가능함 -> 여러개의 인터페이스를 부모로 둘 수 있음
 * 인터페이스의 부모는 인터페이스만 가능
 * 
 * 추상 메서드 -> 티비로서의 공통적인 부분은 부모로서 물려줌 and 타입은 같지만 서로 다른 기능을 갖을시 abstract을 사용
 *  		   계층 구조에선 sub 취급을 안받음, 자식 클래스의 경우 받은 기능을 꼭 구현해야함 
 */
	public abstract class Bird implements Flyer { //abstract -> 부분적 추상화
	
/*	@Override
	public void fly() {
		System.out.println("새가 난다.");
	}*/

	@Override
	public void land() {
		System.out.println("새가 착륙한다.");
	}

	@Override
	public void take_off() {
		System.out.println("새가 이륙한다.");
	}
	
	public String layEgg() {
		return "알을 깐다";
	}

}
