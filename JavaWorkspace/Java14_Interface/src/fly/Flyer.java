package fly;
//완벽한 추상화  --> 구현된것이 하나도 없어야 인터페이스다. 
// 인터페이스 구성 요소 = 추상메소드 + 상수
// 부모의 역할은 타입으로 사용 가능
public interface Flyer {
	//날으는 것과 관련된 기능의 Template을 선언 
	public static final int SIZE=100;
	void fly(); // 위와 아래가 같음, public abstract 가 생략되어있음
	public abstract void land();
	public abstract void take_off();
	
}
