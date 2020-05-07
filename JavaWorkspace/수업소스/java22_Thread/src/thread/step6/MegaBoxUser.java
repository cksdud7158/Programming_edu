package thread.step6;
/*
 * MegaBoxUser�� MegaBox���� �¼��� �����ϴ� ���� �����ϴ� �������� ����..
 * reserve() ��� ����� �ϳ� �ۼ�...���ŷ����� �ۼ�..
 */
public class MegaBoxUser implements Runnable{
	private boolean seat = false;//�¼����Ű� ������ true �Ҵ�
	
	@Override
	public void run() {
		try {
			reserve();
		} catch (InterruptedException e) {
			
		}		
	}	
	public synchronized void reserve() throws InterruptedException{
		String tName = Thread.currentThread().getName();
		System.out.println(tName+" ��, �����Ϸ� ���̽��ϴ�..!! ");
		
		if(seat==false) { //�¼��� ����ٸ�..
			Thread.sleep(2000);
			System.out.println(tName+" ��, �¼� ���� ���� ");
			seat = true;
		}else {//�¼��� �̹� ���� �Ϸ�Ǿ��ٸ�.
			System.out.println(tName+" ��, �ش� �¼��� �̹� ���� �Ϸ� �� �¼��Դϴ�.");
		}
	}
}






