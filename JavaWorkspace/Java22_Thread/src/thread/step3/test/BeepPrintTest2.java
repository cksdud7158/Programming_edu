/*
 * BeepPrintTest1 ���� Ŭ����... �ϳ��� ���μ��� 
 * �� �ȿ��� ���� ������ �ϳ� �ۿ� ������.
 * �����۾��� �Ұ����ߴ�.
 * -------------------------------
 * BeepPrintTest2 ���� Ŭ���� .. �ϳ��� ���μ��� 
 * �̾ȿ� ���� ������ + �۾� �����带 �ϳ� �� �߰� 
 * 1) ���� ������ : beep()�� 5�� --- ������� 5�� �߻�
 * 2) �۾� ������ - BeepThread ---���� 5�� ��� 
 */


package thread.step3.test;

import java.awt.Toolkit;

class BeepPrintThread extends Thread{
	
	public void run() {
		for(int i=0; i<5; i++) {
			System.out.println("��");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}//run
}//class

public class BeepPrintTest2 {

	public static void main(String[] args) { // main �� Thread 
		
		BeepPrintThread beept = new BeepPrintThread();
		beept.start();// ���� �۾� 
		// �̰��� �������� �ϳ��� run ���� 
		// �ٸ� �ϳ����� �Ʒ� for�� ����
		
		Toolkit tool = Toolkit.getDefaultToolkit();
		// ����� 5�� �︮�� �۾� 
		for(int i=0; i<5; i++) {
			tool.beep();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
