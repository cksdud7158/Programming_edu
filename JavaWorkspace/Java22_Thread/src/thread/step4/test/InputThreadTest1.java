package thread.step4.test;

import javax.swing.JOptionPane;
/*
 * ���� �����常 �����Ǵ� ����
 * ���� �۾��� �ȵȴ�. 
 * �ζ� ��ȣ�� �Է� �޴� �۾��� ī���� �۾��� ���������� ����Ǿ���Ѵ�. 
 * -------------------------------------------------
 * 10�� �ȿ� �������� �ζ� ��ȣ�� �ԷµǾ������Ѵ�. 
 */
public class InputThreadTest1 {

	public static void main(String[] args) {
		
		// 1. ����Ÿ �Է� �۾�
		String input = JOptionPane.showInputDialog("���� �ζ� ��ȣ�� �Է��ϼ��� ..");
		System.out.println("�Է��Ͻ� ���ڴ�"+ input);
		
		//2. ������ ī���� �۾�...
		for(int i=10; i>0; i--) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}

			System.out.println(i);

		}
		
	}

}
