package chatting.step1.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/*
 * 키보드로 입력받은 데이타를 읽어서 
 * 서버로 출력한다.
 * ::
 * 입력 2
 * 출력 2 : Socket
 * 
 * Client 로직
 * 1. 소켓 생성
 */
public class ChattClient {
	Socket s;
	BufferedReader br;
	PrintWriter pw;
	
	public void go() {
		try {
			s= new Socket("192.168.0.38", 60000);
			System.out.println("Client Socket Creating");
			
			br = new BufferedReader(new InputStreamReader(System.in));
			pw = new PrintWriter(s.getOutputStream(), true);
			
			System.out.println("Client stream Creating");
			
			String line ="";
			while((line= br.readLine())!=null) {
				pw.println(line);
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
