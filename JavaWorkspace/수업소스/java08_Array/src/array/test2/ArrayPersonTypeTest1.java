package array.test2;

import java.util.Scanner;

public class ArrayPersonTypeTest1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();//�迭�� ������
		
		//1. �迭 �ʱ�ȭ ��
		int[ ] people = new int[num];//������ 6		
		for(int i=0; i<people.length; i++) {
			people[i] = sc.nextInt();
		}
		
		int[ ] types = new int[5];
		for(int i=0; i<people.length; i++) {
			switch(people[i]) {
			case 1://1Ÿ��
				types[0]++;
				break;
			case 2://2Ÿ��
				types[1]++;
				break;
			case 3://3Ÿ��
				types[2]++;
				break;
			case 4://4Ÿ��
				types[3]++;
				break;
			case 5://5Ÿ��
				types[4]++;
				break;
			}
		}//siwtch
		
		int max = 0; //3
		for(int i=0; i<types.length; i++) {
			if(max<types[i])max = types[i];
		}
		
		int answer = 0;
		for(int i=0; i<types.length; i++) {
			if(max==types[i]) answer=i+1;
		}
		System.out.println("���� :: "+answer);
	}

}
/*

6
1 4 4 4 5 3

*/