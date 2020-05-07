package exception.compile.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CompileTest4 {

	public static void main(String[] args){
		String path = "c:\\pcy\\poem.txt";
		
		FileReader fr = null; // 지역변수가 아닌 전역으로 사전에 설정해야함
	
		try {
			System.out.println("1. FileReader 클래스 생성");
			fr = new FileReader(path); // 수도꼭지를 연다.
		
			System.out.println("2. 파일의 내용을 읽어들입니다. ");
			fr.read();
			//수도꼭지를 잠근다 close()
		}catch(FileNotFoundException e) {
				e.printStackTrace();
		}catch(IOException e) {
				e.printStackTrace();
		}finally {
			try {
			fr.close();
			}catch (IOException e) {

			}
		}
	}
}

















