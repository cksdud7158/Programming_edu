/*
 * Ŭ���̾�Ʈ�� ���� �޼����� �޾Ƽ�
 * �ٽ� Ŭ���̾�Ʈ���� �޼����� ������.
 * ::
 * ������ ���� 
 * 1. ServerSocket ���� (���ڰ� port 60000)
 * 2. Ŭ���̾�Ʈ�� ������ �����ϸ� accept�� �޾Ƽ� 
 * 	  Socket�� �ϳ� ����
 * 3. �������� ���� ��Ʈ�� ����
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

	//�߰�
	PrintWriter pw;
	
	public void go() {
		try {
			server = new ServerSocket(60000);
			System.out.println("Server Ready");
			
			s= server.accept();
			System.out.println(s.getInetAddress()+"���� �����ϼ̽��ϴ�.");
			
			br = new BufferedReader(new InputStreamReader(s.getInputStream())); //s.getInputStream �������κ��� ��Ʈ���� �޾ƿ�
			pw = new PrintWriter(cs.getOutputStream(), true);
			
			//
			String line = null;
			while((line = br.readLine())!=null) {
				pw.println(line); //��Ʈ�� ������
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
