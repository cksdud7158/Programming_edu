/*
 * 클라이언트가 보낸 메세지를 받아서
 * 다시 클라이언트한테 메세지를 보낸다.
 * ::
 * 서버측 로직 
 * 1. ServerSocket 생성 (인자값 port 60000)
 * 2. 클라이언트가 서버에 접속하면 accept로 받아서 
 * 	  Socket을 하나 리턴
 * 3. 소켓으로 부터 스트림 리턴
 */

package chatting.step2.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ChattServer {
	ServerSocket server;
	Socket s;
	Socket cs;
	BufferedReader br;

	//추가
	PrintWriter pw;
	
	public void go() {
		try {
			server = new ServerSocket(60000);
			System.out.println("Server Ready");
			
			s= server.accept();
			System.out.println(s.getInetAddress()+"님이 접속하셨습니다.");
			
			br = new BufferedReader(new InputStreamReader(s.getInputStream())); //s.getInputStream 소켓으로부터 스트림을 받아옴
			pw = new PrintWriter(cs.getOutputStream(), true);
			
			//
			String line = null;
			while((line = br.readLine())!=null) {
				pw.println(line); //스트림 보내기
		}
			br.close();
		}catch(Exception e){
			System.out.println("클라이언트와 연결이 끊어졌습니다.");
		}
	}
	
	public static void main(String[] args) {
		ChattServer cs = new ChattServer();
		cs.go();
	}
}
