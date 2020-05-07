package thread.step1;

public class GoThread extends Thread {
	
	public GoThread(String name) {
		super(name);
	}

	//쓰레드가 작동하는 부분
	// 내부적으로 호출되기 때문에 리턴 타입이나 인자값을 넣으면 안됨 , 예외도 던지면 안됨 
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
