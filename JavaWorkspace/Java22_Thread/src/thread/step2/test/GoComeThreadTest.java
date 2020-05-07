package thread.step2.test;

import thread.step2.ComeThread;
import thread.step2.GoThread;

public class GoComeThreadTest {

	public static void main(String[] args) {
		GoThread go2 = new GoThread();
		ComeThread come2 = new ComeThread();
		
		Thread tgo = new Thread(go2, "Go2 Thread");
		Thread tcome = new Thread(come2, "Come Thread");
		
		tgo.start();
		tcome.start();
	}

}
