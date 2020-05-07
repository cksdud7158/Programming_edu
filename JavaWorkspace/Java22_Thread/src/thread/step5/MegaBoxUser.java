package thread.step5;
/*
 * �ް��ڽ� ������ �ް��ڽ����� �¼��� �����ϴ� ���� �����ϴ� ������ 
 * 
 * reserve()��� ����� �ۼ�, ���� ������ ���� 
 * 
 */
public class MegaBoxUser implements Runnable {
	
	private boolean seat = false; //�¼� ���Ű� ������ true �Ҵ�
	
	@Override
	public void run() {
		//�����ϴ� ���
		try {
			reserve();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void reserve() throws InterruptedException {
		String tName = Thread.currentThread().getName();
		System.out.println(tName+"��, �����Ϸ� ���̽��ϴ�.");
		
		if(seat==false) {// �¼��� ����ٸ�
			Thread.sleep(2000);
			System.out.println(tName+"��, �¼� ���� ����");
			seat = true;
		}else { // �¼��� �̹� ���� �Ϸ�
			System.out.println(tName+"��, �ش� �¼��� �̹� ���� �Ϸ�� �¼��Դϴ�. ");
		}
	}
}
