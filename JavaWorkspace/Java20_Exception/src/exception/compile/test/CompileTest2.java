package exception.compile.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
/*
 * FileNotFoundException�� �߻��ϴ� ���
 * 1) ������ ���� ��
 * 2) ������ ������ ��ΰ� �߸��Ǿ����� �� 
 */
class FileReading2{
	public void readFile(String fileName) throws FileNotFoundException { // ���ܸ� �ٸ� ������ �������� -> ȣ���� ������ 
		FileReader fileReader = new FileReader(fileName);	
		System.out.println("FileReader Creatig");

	}
}
public class CompileTest2 {

	public static void main(String[] args) {
		FileReading2 fr = new FileReading2();
		//readFile ȣ��
		String path = "c:\\pcy\\poem.txt";
		try {
		fr.readFile(path);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("readFile Callig");
	}
}

















