package thread.step4.test;

import javax.swing.JOptionPane;
/*
 * 메인 쓰레드 
 * 작업 쓰레드 --카운팅 처리 --CountingThread(implements Runnable)
 */

class CountingThread implements Runnable{

	@Override
	public void run() {
		
		for(int i=10; i>0; i--) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}

			System.out.println(i);

		}
	}
	
}

public class InputThreadTest2 {

	public static void main(String[] args) {
		
		CountingThread cou = new CountingThread();
		Thread tcou = new Thread(cou);
		
		tcou.start();
		// 1. 데이타 입력 작업
		String input = JOptionPane.showInputDialog("최종 로또 번호를 입력하세요 ..");
		System.out.println("입력하신 숫자는"+ input);
		
		
		
	}

}
