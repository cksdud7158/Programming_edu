package exception.compile.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CompileTest4 {

	public static void main(String[] args){
		String path = "c:\\pcy\\poem.txt";
		
		FileReader fr = null; // ���������� �ƴ� �������� ������ �����ؾ���
	
		try {
			System.out.println("1. FileReader Ŭ���� ����");
			fr = new FileReader(path); // ���������� ����.
		
			System.out.println("2. ������ ������ �о���Դϴ�. ");
			fr.read();
			//���������� ��ٴ� close()
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

















