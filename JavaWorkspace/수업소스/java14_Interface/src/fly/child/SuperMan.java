package fly.child;
import fly.Flyer;

/*
 * stop_bullet() 추가...마무리...
 */
public class SuperMan implements Flyer{
	
	@Override
	public void fly() {	
		System.out.println("SuperMan fly...");
		//SIZE=150;
		System.out.println("시속 "+SIZE + "km...");
	}
	@Override
	public void land() {		
		System.out.println("SuperMan land...");
	}
	@Override
	public void take_off() {		
		System.out.println("SuperMan take_off...");
	}	
	public String stop_bullet() {
		return "망또로 총알을 막다";
	}
}
