package chatting.step2.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/*
 * Ű����� �Է¹��� ����Ÿ�� �о 
 * ������ ������.
 * ---------
 * �ٽ� ������ ���� �޼����� �޾Ƽ� 
 * Ŭ���̾�Ʈ �ܼ� â�� ����Ѵ�.
 * ::
 * �Է� 2
 * ��� 2 : Socket
 * 
 * Client ����
 * 1. ���� ����
 */
public class ChattClient {
	Socket s;
	BufferedReader br, br1;// br1 �߰�
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
				String line = br.readLine(); //Ű����� �Է� ���� ����Ÿ �б�
				pw.println(line); //������ ������ 
				/////////////////////
				String serverMessage= br1.readLine();
				System.out.println("������ ���� �޼���"+ serverMessage);
				
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
