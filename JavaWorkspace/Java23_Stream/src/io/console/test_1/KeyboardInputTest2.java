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
/*
 * 키보드로 읽어들인 데이타를 
 * 콘솔로 출력하는 로직 을 작성
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KeyboardInputTest2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("키보드로 데이타를 입력하세요 \n");
		
		String line = "";
		try {
		while((line = br.readLine())!= null) {
			if(line.equals("고마해라")) {
				System.out.println("입력금지 종료합니다.");
				break;
			}else {
				System.out.println("Reading Data : "+ line);
			}
		}
		}finally {
			br.close();
		}
	}

}
