package thread.shared.step4.test;
/*
 * Review ::
 * Thread들은 공유자원을 서로 Sharing 한다
 */
class Calculator{
	private int memory;

	public int getMemory() {
		return memory;
	}

	public void setMemory(int memory) {
		this.memory = memory;
		try{
			Thread.sleep(2000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"  :  "+this.memory);
	}	
}
class User1 extends Thread{
	private Calculator calculator;

	public void setCalculator(Calculator calculator) {
		setName("CalculatorUser1");
		this.calculator = calculator;
	}
	public void run(){
		calculator.setMemory(100);		
	}	
}
class User2 extends Thread{
	private Calculator calculator;

	public void setCalculator(Calculator calculator) {
		setName("CalculatorUser2");
		this.calculator = calculator;
	}
	public void run(){
		calculator.setMemory(50);		
	}	
}
public class SharedMemoryTest {
	public static void main(String[] args) {
		Calculator calculator  = new Calculator();
		
		User1 user1 = new User1();
		user1.setCalculator(calculator);
		user1.start();
		
		User2 user2 = new User2();
		user2.setCalculator(calculator);
		user2.start();
	}
}











