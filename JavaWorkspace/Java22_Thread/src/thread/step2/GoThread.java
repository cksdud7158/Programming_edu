package thread.step2;
/*
 * 쓰레드를 만드는 방법
 * 1. extends Thread
 * 2. implements Runnable ---> 더 권장
 * 다중 상속이 안되기 떄문
 */
public class GoThread implements Runnable {
	
	

	@Override
	public void run() {
		int i= 0;
		while(true) {
			try {
				Thread.sleep(1000);// 1초 동안 메모리에서 내림
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
			String tname = Thread.currentThread().getName();
			System.out.println(tname+"  "+ i);
			i++;
			if(i==20)break;
		}
	}
}
