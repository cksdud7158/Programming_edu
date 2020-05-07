/*
 * Source -- 파일
 * Sink -- 콘솔
 * ::
 * 파일에 있는 내용을 읽어서 
 * 콘솔로 출력하는 로직을 작성
 * 
 */
package io.file.test_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReadingTest1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("src\\hope.txt"));
		
		String line = "";
		try {
			while((line = br.readLine())!= null) {
			System.out.println(line);
		}
		}finally {
			br.close();
		}
		
	}

}
