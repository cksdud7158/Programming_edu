package chatting.step2.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/*
 * 키보드로 입력받은 데이타를 읽어서 
 * 서버로 보낸다.
 * ---------
 * 다시 서버가 보낸 메세지를 받아서 
 * 클라이언트 콘솔 창에 출력한다.
 * ::
 * 입력 2
 * 출력 2 : Socket
 * 
 * Client 로직
 * 1. 소켓 생성
 */
public class ChattClient {
	Socket s;
	BufferedReader br, br1;// br1 추가
	PrintWriter pw;
	
	public void go() {
		try {
			s= new Socket("192.168.0.33", 60000);
			System.out.println("Client Socket Creating");
			
			br = new BufferedReader(new InputStreamReader(System.in));
			pw = new PrintWriter(s.getOutputStream(), true);
			br1 = new BufferedReader(new InputStreamReader(s.getInputStream()));
			
			System.out.println("Client stream Creating");
			
			while(true) {
				String line = br.readLine(); //키보드로 입력 받은 데이타 읽기
				pw.println(line); //서버로 보내기 
				/////////////////////
				String serverMessage= br1.readLine();
				System.out.println("서버가 보낸 메세지"+ serverMessage);
				
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
