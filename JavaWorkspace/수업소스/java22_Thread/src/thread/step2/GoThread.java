/*
 * �����带 ����� ���
 * 1. extends Thread
 * 2. implements Runnable ---> v
 */
package thread.step2;
//Thread Ŭ����...
public class GoThread implements Runnable{
	//private String name;
	/*public GoThread(String name){
		super(name);
	}*/
	@Override
	public void run() {
		int i=0;
		while(true) {
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				
			}
			String tname = Thread.currentThread().getName();
			System.out.println("CurrentThread :: "+tname+","+i);
			i++;
			if(i==20)break;
		}		
	}
}






