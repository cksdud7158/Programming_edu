package exception.compile.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
/*
 * FileNotFoundException이 발생하는 경우
 * 1) 파일이 없을 때
 * 2) 파일은 있지만 경로가 잘못되어있을 때 
 */
class FileReading{
	public void readFile(String fileName) {
		try {
		FileReader fileReader = new FileReader(fileName); //FileNotFoundException 이 발생 원인
		System.out.println("FileReader Creatig");
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
public class CompileTest1 {

	public static void main(String[] args) {
		FileReading fr = new FileReading();
		//readFile 호출
		String path = "c:\\pcy\\poem.txt";
		fr.readFile(path);
		System.out.println("readFile Callig");
	}
}

















