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

public class FileReadingTest4 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("src\\result.txt"));
		BufferedWriter brw = new BufferedWriter(new FileWriter("src\\result2.txt"));

		
		String line = "";
		try {
			while((line = br.readLine())!= null) {
			brw.write(line);
			brw.write("\n");
			//문자 데이터 출력 시 데이터를 읽어들인 후 다른 저장소에 모아두었다가 한번에 출력함 
			
			}
			//brw.flush(); // 출력
		}finally {
			br.close();
			brw.close(); // 하지만 flush는 잘 안씀. 닫기전에 임시 저장했던 데이터를 다 내보내고 닫음 
		}
		
	}

}
