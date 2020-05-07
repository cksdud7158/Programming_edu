/*
 * 키보드로 테이타를 읽어들여서 
 * 콘솔로 출력하는 로직을 작성 
 * ::
 * Source - 키보드 
 * sink - 콘솔
 * 
 * 1. 스트림 생성 : 입력 스트림만 필요
 * 		InputStreamReader, BufferedReader
 * 2. 데이타 읽어들이기
 * 3. 콘솔 출력 
 */
package io.console.test_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KeyboardInputTest1 {

	public static void main(String[] args) {
		
		//1.
		System.out.println("1.");
		InputStreamReader ir = new InputStreamReader(System.in); // 키보드와 연결
		BufferedReader br = new BufferedReader(ir); // InputStreamReader과 연결 , 랩핑 
	
		
		//2.
		try {
			System.out.println("2.");
			String line = br.readLine();
			while(line!=null) {// 읽어들인 데이터가 있다면..
			//3
			System.out.println("3.");
			System.out.println("Reading Data: "+ line);
			line = br.readLine();//이 부분이 있어야 반복
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
