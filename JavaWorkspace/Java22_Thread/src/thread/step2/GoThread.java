package thread.step2;
/*
 * �����带 ����� ���
 * 1. extends Thread
 * 2. implements Runnable ---> �� ����
 * ���� ����� �ȵǱ� ����
 */
public class GoThread implements Runnable {
	
	

	@Override
	public void run() {
		int i= 0;
		while(true) {
			try {
				Thread.sleep(1000);// 1�� ���� �޸𸮿��� ����
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
