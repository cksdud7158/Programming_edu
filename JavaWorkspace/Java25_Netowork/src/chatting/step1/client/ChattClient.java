package chatting.step1.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/*
 * Ű����� �Է¹��� ����Ÿ�� �о 
 * ������ ����Ѵ�.
 * ::
 * �Է� 2
 * ��� 2 : Socket
 * 
 * Client ����
 * 1. ���� ����
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
			System.out.println("�������� ���ῡ �����߽��ϴ�.");
		}
	}
	public static void main(String[] args) {
		
		ChattClient cc = new ChattClient();
		cc.go();
	}

}
