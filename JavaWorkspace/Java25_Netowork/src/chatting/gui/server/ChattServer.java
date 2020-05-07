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

package chatting.gui.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChattServer {
	ServerSocket server;
	Socket s;
	ArrayList<ChattThread> list; // 여러 소켓을 받기 위해서 필요
	
	public ChattServer() {// 생성자
		list= new ArrayList<>();
	}
	
	public void broadcast(String message) {
		for(ChattThread t : list) {
			t.sendMessage(message); // pw가 없긴때문에 Thread 클래스에서 sendMessage란 메서드 생성 
			
		}
	}
	
	public void go() {
		try {
			server = new ServerSocket(60000); //
			System.out.println("Server Ready");
		
			while(true) {
				s = server.accept();
				ChattThread ct = new ChattThread(s,this); // this를 사용한 이유 Thread가 프로세스의 기능을 쓰기위해 사용
				list.add(ct);
				ct.start(); //run()
			}
		}catch(Exception e){
			
		}
	}
	
	public static void main(String[] args) {
		ChattServer cs = new ChattServer();
		cs.go();
	}
}

class ChattThread extends Thread {
	Socket s;
	BufferedReader br;
	PrintWriter pw;
	ChattServer chattServer;
	
	ChattThread(Socket s,ChattServer chattServer ){
		this.chattServer = chattServer;
		this.s =s;
		System.out.println(s.getInetAddress()+"님이 접속하셨습니다.");
		chattServer.broadcast(s.getInetAddress()+"님이 채팅방에 들어오셨습니다.");
	}
	
	public void sendMessage(String str) {
		pw.println(); 
	}
	
	public void run() {
		try {
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			pw = new PrintWriter(s.getOutputStream(), true);
			
			while(true) {
				String line = br.readLine();
				chattServer.broadcast(line);
				
			}
		}catch(IOException e) {
			// 연결이 끊어졌을때 이곳으로 이동
			System.out.println(s.getInetAddress()+"님이 접속을 끊으셨습니다.");
			chattServer.broadcast(s.getInetAddress()+"님이 채팅방을 나가셨습니다.");
			chattServer.list.remove(this); // this = Thread
		}
	}
	
}
