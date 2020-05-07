/*
 * Ű����� ����Ÿ�� �о�鿩��
 * �ַܼ� ����ϴ� ������ �ۼ�
 * ::
 * Source --- Ű����
 * Sink --- �ܼ�
 * ::
 * 1. ��Ʈ�� ���� : �Է½�Ʈ���� �ʿ�...��½�Ʈ�� ���ʿ�
 *    InputStreamReader, BufferedReader
 * 2. �о���δ�...
 *     readLine()    
 * 3. �ַܼ� ���
 *    System.out.println()   
 */
package io.console.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KeyboardInputTest1 {
	public static void main(String[] args) {
		//1.
		System.out.println("1. Stream ����.....");
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		
		//2.
		try {
			System.out.println("2. readLine() ���� �о�帳�ϴ�.....");
			String line=br.readLine();
			while(line!=null) { //�о���� ����Ÿ�� �ִٸ�...
				//3. 
				System.out.println("Reading Data : "+line);
				line=br.readLine();//�� �κ��� �־�� �ݺ��Ѵ�.
			}			
		} catch (IOException e) {
			
		}finally {
			try {
				br.close();
			}catch(IOException e) {
				
			}
		}
		
	}
}






