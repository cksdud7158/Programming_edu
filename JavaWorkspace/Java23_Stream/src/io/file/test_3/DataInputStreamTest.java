/*
 * Byte �迭 ��Ʈ�� ..
 * ���̳ʸ� ����Ÿ(�̹��� ����)�� �о
 * ���Ϸ� ����ϴ� ������ �ۼ�
 * ::
 * �Է� 2, ��� 2
 * DataInputStream(FileInputStream)
 * DataOutputStream(FileOutputStream)
 */
package io.file.test_3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataInputStreamTest {
	public static void main(String[] args) throws IOException {
		String fileNmae = "Src/watermelon.png";
		String outfileName = "src/water.png";
		
		DataInputStream dis = null;
		DataOutputStream dos = null;
		
		try {
			dis = new DataInputStream(new FileInputStream(fileNmae));
			dos = new DataOutputStream(new FileOutputStream(outfileName));
			
			int data = 0;
			while((data = dis.readInt())!= -1) { // -1 �� ������ ���� �ǹ� 
				dos.writeInt(data);
			}
			
		}catch(EOFException e){ // ������ ���� ������ ���� ����
			
		}catch(IOException e) {
			
		}
		
	}

}
