/*
 * �ش� �ڵ忡�� ������ Thread�� �ۼ������ʰ� ���� 
 * ������� �߻���Ű�� ���ÿ� ������� �ַܼ� �������ϴ� �۾� 
 * ->�� �������� main �Ʒ����� ó���ϵ��� �Ұ��̴�.
 */
package thread.step3.test;

import java.awt.Toolkit;

public class BeepPrintTest1 {

	public static void main(String[] args) { // main �� Thread 
		
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
		
		for(int i=0; i<5; i++) {
			System.out.println("��");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}
