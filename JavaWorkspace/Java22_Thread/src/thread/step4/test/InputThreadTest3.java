package thread.step4.test;

import javax.swing.JOptionPane;
/*
 * 카운팅 작업 -CountThread
 * 숫자입력작업 - InputThread
 * ::
 * 두 쓰레드 간의 Communication은 프로세스의 자원으로 해야한다. 
 */

class CountThread implements Runnable{
	private InputThreadTest3 process;
	
	public CountThread(InputThreadTest3 process) {
		this.process = process;
	}
	
	@Override
	public void run() {
		
		for(int i=10; i>0; i--) {
			
			if(process.inputCheck) break;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
			System.out.println(i);
			
			if(!process.inputCheck) {
				System.out.println("10초 경과되었습니다. ");
				System.exit(0);
			}
		}
	}
}

class InputThread implements Runnable{
private InputThreadTest3 process;
	
	public InputThread(InputThreadTest3 process) {
		this.process = process;
	}
	@Override
	public void run() {
		String input = JOptionPane.showInputDialog("최종 로또 번호를 입력하세요 ..");
		System.out.println("입력하신 숫자는"+ input);
		
		process.inputCheck = true;
	}
	
}

public class InputThreadTest3 {
	
	boolean inputCheck = false;
	
	public static void main(String[] args) {
		InputThreadTest3 process = new InputThreadTest3();
		
		CountThread cou = new CountThread(process); // Thread 가 Process를 가지는 hasing 관계
		Thread tcou = new Thread(cou);
		tcou.start();
		
		InputThread ip = new InputThread(process);
		Thread tip = new Thread(ip);
		tip.start();
		
		// 1. 카운팅 중 값이 입력되면 값을 출력하고 카운팅을 멈춰야함 
		
		
		//2. 카운팅이 끝날 때까지 값이 들어오지 않으면 더이상 값을 입력 못하게 하고 시간이 종료되었다는 알림을 넣어줘야함 

		
		
		
		
	}

}
