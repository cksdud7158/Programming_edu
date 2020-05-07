/*
 * BeepPrintTest1 실행 클래스... 하나의 프로세스 
 * 이 안에는 메인 쓰레드 하나 밖에 없었다.
 * 병렬작업이 불가능했다.
 * -------------------------------
 * BeepPrintTest2 실행 클래스 .. 하나의 프로세스 
 * 이안에 메인 쓰레드 + 작업 쓰레드를 하나 더 추가 
 * 1) 메인 쓰레드 : beep()를 5번 --- 경고음을 5번 발생
 * 2) 작업 쓰레드 - BeepThread ---띵을 5번 출력 
 */


package thread.step3.test;

import java.awt.Toolkit;

class BeepPrintThread extends Thread{
	
	public void run() {
		for(int i=0; i<5; i++) {
			System.out.println("띵");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}//run
}//class

public class BeepPrintTest2 {

	public static void main(String[] args) { // main 이 Thread 
		
		BeepPrintThread beept = new BeepPrintThread();
		beept.start();// 병렬 작업 
		// 이곳을 기준으로 하나는 run 실행 
		// 다른 하나에는 아래 for문 실행
		
		Toolkit tool = Toolkit.getDefaultToolkit();
		// 경고음 5번 울리는 작업 
		for(int i=0; i<5; i++) {
			tool.beep();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
