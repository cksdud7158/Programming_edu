package thread.step1;
//Thread Ŭ����...
public class ComeThread extends Thread{
	
	public ComeThread(String name){
		super(name);
	}
	//�����尡 �۵��ϴ� �κ�...���������� ȣ��Ǳ� ������ �״�� ����Ѵ�.
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
