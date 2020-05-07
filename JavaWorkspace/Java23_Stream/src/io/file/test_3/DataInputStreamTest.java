/*
 * Byte 계열 스트림 ..
 * 바이너리 데이타(이미지 파일)을 읽어서
 * 파일로 출력하는 로직을 작성
 * ::
 * 입력 2, 출력 2
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
			while((data = dis.readInt())!= -1) { // -1 이 파일의 끝을 의미 
				dos.writeInt(data);
			}
			
		}catch(EOFException e){ // 파일의 끝을 만나서 나는 에러
			
		}catch(IOException e) {
			
		}
		
	}

}
