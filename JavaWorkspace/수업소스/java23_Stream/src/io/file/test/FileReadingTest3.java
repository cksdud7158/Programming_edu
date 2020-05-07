/*
 * Source --- ����
 * Sink   --- ����...src\\result.txt
 * ::
 * ���Ͽ� �ִ� ������ �о
 * �Ǵٸ� ���Ϸ� ����ϴ� ������ �ۼ�
 * ::
 * 
 */
package io.file.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileReadingTest3 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("src\\hope.txt"));
		PrintWriter pw = new PrintWriter(new FileWriter("src\\data\\result.txt", true),true);
		try {
			String line = "";
			while((line =br.readLine())!=null) {
				pw.println(line);
			}
			//bw.flush();
		}finally {
			br.close();
			
		}
	}
}








