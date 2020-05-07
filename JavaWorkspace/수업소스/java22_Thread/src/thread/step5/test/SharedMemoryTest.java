package thread.step5.test;
/*
 * 이 코드는 제공한다...
 * Thread들은 Process의 공유자원을 서로 Sharing 한다
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











