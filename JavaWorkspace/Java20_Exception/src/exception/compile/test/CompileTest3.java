package exception.compile.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
/*
 * FileNotFoundException�� �߻��ϴ� ���
 * 1) ������ ���� ��
 * 2) ������ ������ ��ΰ� �߸��Ǿ����� �� 
 */
class FileReading3{
	public void readFile(String fileName) throws FileNotFoundException { // ���ܸ� �ٸ� ������ �������� -> ȣ���� ������ 
		FileReader fileReader = new FileReader(fileName);	
		System.out.println("FileReader Creatig");

	}
}
public class CompileTest3 {

	public static void main(String[] args) throws FileNotFoundException {
		FileReading3 fr = new FileReading3();
		//readFile ȣ��
		String path = "c:\\pcy\\poem.txt";
		fr.readFile(path);

		System.out.println("readFile Callig");
	}
}

















