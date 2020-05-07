/*
 * Source -- ����
 * Sink -- ����
 * ::
 * ���Ͽ� �ִ� ������ �о 
 * �Ǵٸ� ���Ϸ� ����ϴ� ������ �ۼ�
 * 
 */

package io.file.test_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileReadingTest3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("src\\result.txt"));
		PrintWriter pw = new PrintWriter(new FileWriter("src\\result2.txt",true),true); // ù��° ture �� append ����� ����, 
		//�ι�° true �� �ڵ� flush

		
		String line = "";
		try {
			while((line = br.readLine())!= null) {
				pw.println(line);
			}
		}finally {
			br.close();
			
		}
		
	}

}
