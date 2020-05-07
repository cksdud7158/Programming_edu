package thread.step4.test;
/*
 * 카운팅작업 - CountThread
 * 숫자입력작업 - InputThread
 * ::
 * 두 쓰레드간의 Communication은 프로세스의 자원으로 해야한다.
 * 
 */
import javax.swing.JOptionPane;
class InputThread extends Thread{
	
	InputThreadTest3 process;
	InputThread(InputThreadTest3 process){
		this.process = process;
	}	
	public void run() {
		//1. 데이타 입력 작업...
		String input=JOptionPane.showInputDialog("최종 로또 번호를 입력하세요...");
		System.out.println("입력하신 숫자는 "+input+" 입니다.");
		
		process.inputCheck = true;
	}
}
class CountThread extends Thread{	
	InputThreadTest3 process;
	CountThread(InputThreadTest3 process){
		this.process = process;
	}
	
	public void run() {
		//2. 일종의 카운팅 작업...
		for(int i =10; i>0; i--) {
			
			if(process.inputCheck) break;
			System.out.println(i);
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				
			}			
		}//for
		
		if(!process.inputCheck) {
			System.out.println("10초 경과되었습니다...값입력  시간 초과!!");
			System.exit(0);
		}		
	}	
}
//Process...
public class InputThreadTest3 {
	boolean inputCheck = false;
	
	public static void main(String[] args) {
		InputThreadTest3 process = new InputThreadTest3();
		
		CountThread countT = new CountThread(process);
		InputThread inputT = new InputThread(process);
		
		countT.start();
		inputT.start();	
				
	}
}






