package exception.compile.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/*
 * main()���� throws �� �� �ִ°��� ������ �迭�� �����ϴ�. 
 */
public class CompileTest5 {

	public static void main(String[] args) throws FileNotFoundException, IOException{
		String path = "c:\\pcy\\poem.txt";
		
		FileReader fr = null; // ���������� �ƴ� �������� ������ �����ؾ���
		try {
		System.out.println("1. FileReader Ŭ���� ����");
		fr = new FileReader(path); // ���������� ����.
	
		System.out.println("2. ������ ������ �о���Դϴ�. ");
		fr.read();
		//���������� ��ٴ� close()
		}finally {
			fr.close();
		}
	}
}

















