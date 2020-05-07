package thread.step4.test;

import javax.swing.JOptionPane;
/*
 * ī���� �۾� -CountThread
 * �����Է��۾� - InputThread
 * ::
 * �� ������ ���� Communication�� ���μ����� �ڿ����� �ؾ��Ѵ�. 
 */

class CountThread implements Runnable{
	private InputThreadTest3 process;
	
	public CountThread(InputThreadTest3 process) {
		this.process = process;
	}
	
	@Override
	public void run() {
		
		for(int i=10; i>0; i--) {
			
			if(process.inputCheck) break;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
			System.out.println(i);
			
			if(!process.inputCheck) {
				System.out.println("10�� ����Ǿ����ϴ�. ");
				System.exit(0);
			}
		}
	}
}

class InputThread implements Runnable{
private InputThreadTest3 process;
	
	public InputThread(InputThreadTest3 process) {
		this.process = process;
	}
	@Override
	public void run() {
		String input = JOptionPane.showInputDialog("���� �ζ� ��ȣ�� �Է��ϼ��� ..");
		System.out.println("�Է��Ͻ� ���ڴ�"+ input);
		
		process.inputCheck = true;
	}
	
}

public class InputThreadTest3 {
	
	boolean inputCheck = false;
	
	public static void main(String[] args) {
		InputThreadTest3 process = new InputThreadTest3();
		
		CountThread cou = new CountThread(process); // Thread �� Process�� ������ hasing ����
		Thread tcou = new Thread(cou);
		tcou.start();
		
		InputThread ip = new InputThread(process);
		Thread tip = new Thread(ip);
		tip.start();
		
		// 1. ī���� �� ���� �ԷµǸ� ���� ����ϰ� ī������ ������� 
		
		
		//2. ī������ ���� ������ ���� ������ ������ ���̻� ���� �Է� ���ϰ� �ϰ� �ð��� ����Ǿ��ٴ� �˸��� �־������ 

		
		
		
		
	}

}
