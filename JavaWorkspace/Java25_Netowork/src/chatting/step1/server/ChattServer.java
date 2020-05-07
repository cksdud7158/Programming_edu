/*
 * Ŭ���̾�Ʈ�� ���� �޼����� �޾Ƽ�
 * �ڽ��� �ܼ�â�� ���� �޼����� ���
 * ::
 * ������ ���� 
 * 1. ServerSocket ���� (���ڰ� port 60000)
 * 2. Ŭ���̾�Ʈ�� ������ �����ϸ� accept�� �޾Ƽ� 
 * 	  Socket�� �ϳ� ����
 * 3. �������� ���� ��Ʈ�� ����
 */

package chatting.step1.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ChattServer {
	ServerSocket server;
	Socket s;
	BufferedReader br;
	
	public void go() {
		try {
			server = new ServerSocket(60000);
			System.out.println("Server Ready");
			
			s= server.accept();
			System.out.println("Client Socket Returning");
			
			br = new BufferedReader(new InputStreamReader(s.getInputStream())); //s.getInputStream �������κ��� ��Ʈ���� �޾ƿ�
			
			//
			String line = null;
			while((line = br.readLine())!=null) {
				System.out.println("Client �� ���� �޼���"+line);
			}
			br.close();
			
		}catch(Exception e){
			System.out.println("Ŭ���̾�Ʈ�� ������ ���������ϴ�.");
		}
	}
	
	public static void main(String[] args) {
		ChattServer cs = new ChattServer();
		cs.go();
	}
}
