/*
 * Source -- 파일
 * Sink -- 파일
 * ::
 * 파일에 있는 내용을 읽어서 
 * 또다른 파일로 출력하는 로직을 작성
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
		PrintWriter pw = new PrintWriter(new FileWriter("src\\result2.txt",true),true); // 첫번째 ture 는 append 덮어쓰기 방지, 
		//두번째 true 는 자동 flush

		
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
