package thread.step1;

public class GoThread extends Thread {
	
	public GoThread(String name) {
		super(name);
	}

	//�����尡 �۵��ϴ� �κ�
	// ���������� ȣ��Ǳ� ������ ���� Ÿ���̳� ���ڰ��� ������ �ȵ� , ���ܵ� ������ �ȵ� 
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
