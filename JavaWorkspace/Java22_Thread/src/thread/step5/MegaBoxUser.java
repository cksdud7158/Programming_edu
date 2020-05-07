package thread.step5;
/*
 * 메가박스 유저는 메가박스에서 좌석을 에매하는 일을 전담하는 쓰레드 
 * 
 * reserve()라는 기능을 작성, 예매 로직을 넣음 
 * 
 */
public class MegaBoxUser implements Runnable {
	
	private boolean seat = false; //좌석 예매가 끝나면 true 할당
	
	@Override
	public void run() {
		//에매하는 기능
		try {
			reserve();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void reserve() throws InterruptedException {
		String tName = Thread.currentThread().getName();
		System.out.println(tName+"님, 예매하러 오셨습니다.");
		
		if(seat==false) {// 좌석이 비었다면
			Thread.sleep(2000);
			System.out.println(tName+"님, 좌석 예매 성공");
			seat = true;
		}else { // 좌석이 이미 예매 완료
			System.out.println(tName+"님, 해당 좌석은 이미 예매 완료된 좌석입니다. ");
		}
	}
}
