package fly.child;
import fly.Flyer;

/*
 * stop_bullet() �߰�...������...
 */
public class SuperMan implements Flyer{
	
	@Override
	public void fly() {	
		System.out.println("SuperMan fly...");
		//SIZE=150;
		System.out.println("�ü� "+SIZE + "km...");
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
		return "���Ƿ� �Ѿ��� ����";
	}
}
