/*
 * Ű����� ����Ÿ�� �о�鿩�� 
 * �ַܼ� ����ϴ� ������ �ۼ� 
 * ::
 * Source - Ű���� 
 * sink - �ܼ�
 * 
 * 1. ��Ʈ�� ���� : �Է� ��Ʈ���� �ʿ�
 * 		InputStreamReader, BufferedReader
 * 2. ����Ÿ �о���̱�
 * 3. �ܼ� ��� 
 */
package io.console.test_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KeyboardInputTest1 {

	public static void main(String[] args) {
		
		//1.
		System.out.println("1.");
		InputStreamReader ir = new InputStreamReader(System.in); // Ű����� ����
		BufferedReader br = new BufferedReader(ir); // InputStreamReader�� ���� , ���� 
	
		
		//2.
		try {
			System.out.println("2.");
			String line = br.readLine();
			while(line!=null) {// �о���� �����Ͱ� �ִٸ�..
			//3
			System.out.println("3.");
			System.out.println("Reading Data: "+ line);
			line = br.readLine();//�� �κ��� �־�� �ݺ�
			}
		} catch (IOException e) {
		}finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
