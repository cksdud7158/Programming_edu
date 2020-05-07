package thread.step2;

public class ComeThread implements Runnable {
	
	/*public ComeThread(String name) {
	}*/

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
