package chatting.step3.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChattClient {
	Socket s;
	BufferedReader br;// br1 추가
	PrintWriter pw;
	
	public void go() {
		try {
			s= new Socket("192.168.0.33", 60000);
			System.out.println("Client Socket Creating");
			
			br = new BufferedReader(new InputStreamReader(System.in));
			pw = new PrintWriter(s.getOutputStream(), true);
			
			//추가
			ClientThread ct = new ClientThread(s);
			ct.start(); // run()
			
			while(true) {
				String line = br.readLine(); //키보드로 입력 받은 데이타 읽기
				pw.println(line); //서버로 보내기		
			}
			
		}catch(Exception e){
			System.out.println("서버와의 연결에 실패했습니다.");
		}
	}
	public static void main(String[] args) {
		
		ChattClient cc = new ChattClient();
		cc.go();
	}

}

class ClientThread extends Thread{ //서버가 전달해오는 스트림을 전담하는 쓰레드
	Socket s;
	BufferedReader br2;
	String str;
	
	ClientThread(Socket s){
		this.s = s;
	}
	
	public void run() {
		try {
			br2 = new BufferedReader(new InputStreamReader(s.getInputStream()));
			while(true) {
				str= br2.readLine();
				System.out.println("서버 메세지 : "+str);
					
			}
		}catch(Exception e) {
			
		}
	}
	
}
