package thread.step4.test;

import javax.swing.JOptionPane;
/*
 * ���� ������ 
 * �۾� ������ --ī���� ó�� --CountingThread(implements Runnable)
 */

class CountingThread implements Runnable{

	@Override
	public void run() {
		
		for(int i=10; i>0; i--) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}

			System.out.println(i);

		}
	}
	
}

public class InputThreadTest2 {

	public static void main(String[] args) {
		
		CountingThread cou = new CountingThread();
		Thread tcou = new Thread(cou);
		
		tcou.start();
		// 1. ����Ÿ �Է� �۾�
		String input = JOptionPane.showInputDialog("���� �ζ� ��ȣ�� �Է��ϼ��� ..");
		System.out.println("�Է��Ͻ� ���ڴ�"+ input);
		
		
		
	}

}
