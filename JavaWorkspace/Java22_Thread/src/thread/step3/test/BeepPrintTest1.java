/*
 * 해당 코드에선 별도의 Thread를 작성하지않고 실행 
 * 경고음을 발생시키고 동시에 경고음을 콘솔로 프린팅하는 작업 
 * ->두 가지일을 main 아래에서 처리하도록 할것이다.
 */
package thread.step3.test;

import java.awt.Toolkit;

public class BeepPrintTest1 {

	public static void main(String[] args) { // main 이 Thread 
		
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
		
		for(int i=0; i<5; i++) {
			System.out.println("띵");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}
