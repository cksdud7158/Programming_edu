package thread.step1.test;

import thread.step1.ComeThread;
import thread.step1.GoThread;

public class GoComeThreadTest {

	public static void main(String[] args) {
		//1. Thread ����
		GoThread go = new GoThread("GoThread");
		ComeThread come = new ComeThread("ComeThread");
		
		//2. start ȣ�� 
		go.start(); //Runable --> run(); --> run(){}
		come.start(); //Runable --> run(); --> run(){}

	}

}
