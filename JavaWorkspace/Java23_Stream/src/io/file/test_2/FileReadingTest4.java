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

public class FileReadingTest4 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("src\\result.txt"));
		BufferedWriter brw = new BufferedWriter(new FileWriter("src\\result2.txt"));

		
		String line = "";
		try {
			while((line = br.readLine())!= null) {
			brw.write(line);
			brw.write("\n");
			//���� ������ ��� �� �����͸� �о���� �� �ٸ� ����ҿ� ��Ƶξ��ٰ� �ѹ��� ����� 
			
			}
			//brw.flush(); // ���
		}finally {
			br.close();
			brw.close(); // ������ flush�� �� �Ⱦ�. �ݱ����� �ӽ� �����ߴ� �����͸� �� �������� ���� 
		}
		
	}

}
