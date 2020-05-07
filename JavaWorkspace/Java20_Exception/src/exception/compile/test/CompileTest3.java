package exception.compile.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
/*
 * FileNotFoundException이 발생하는 경우
 * 1) 파일이 없을 때
 * 2) 파일은 있지만 경로가 잘못되어있을 때 
 */
class FileReading3{
	public void readFile(String fileName) throws FileNotFoundException { // 예외를 다른 곳으로 보내버림 -> 호출한 곳으로 
		FileReader fileReader = new FileReader(fileName);	
		System.out.println("FileReader Creatig");

	}
}
public class CompileTest3 {

	public static void main(String[] args) throws FileNotFoundException {
		FileReading3 fr = new FileReading3();
		//readFile 호출
		String path = "c:\\pcy\\poem.txt";
		fr.readFile(path);

		System.out.println("readFile Callig");
	}
}

















