package exception.compile.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
/*
 * FileNotFoundException�� �߻��ϴ� ���
 * 1) ������ ���� ��
 * 2) ������ ������ ��ΰ� �߸��Ǿ����� �� 
 */
class FileReading{
	public void readFile(String fileName) {
		try {
		FileReader fileReader = new FileReader(fileName); //FileNotFoundException �� �߻� ����
		System.out.println("FileReader Creatig");
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
public class CompileTest1 {

	public static void main(String[] args) {
		FileReading fr = new FileReading();
		//readFile ȣ��
		String path = "c:\\pcy\\poem.txt";
		fr.readFile(path);
		System.out.println("readFile Callig");
	}
}

















