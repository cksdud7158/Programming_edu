package array.test2;

import java.util.Arrays;
import java.util.Random;

/*
 * ����
 * ::
 * �迭�� ���� �ڷᱸ���� ���ؼ��� ���Ŀ� ���� �䱸������ ����ϰ� �Ͼ��.
 * ������ �����ϱ� ���� �˰��� �� ���� ��ǥ���� �������Ŀ� ���ؼ� ���캸�ڴ�.
 * ������{2, 5, 3, 9} --> ������{ 2, 3, 5, 9}
 * 
 * ��������
 * ::
 * ������ �� ���� ���ؼ� ū���� �ڷ� ������ ���
 * 2, 5 �μ��� �� --> 2, 5�� ����
 * 5, 3 �μ��� �� --> 1)temp ��� �ӽú���(5) 2) 3,3 3) temp���� ������ 5�� ���ڸ��� 3,5
 * ��ó�� �μ��� �ڸ��� �ٲٴ� ����� swap�̶� �Ѵ�.
 * 
 * ����!!!
 */
public class ArrayBubbleSortingTest4 {
	public static void main(String[] args) {
		Random r = new Random();
		//int aa = r.nextInt();//20��(����..���)
		int[ ] arr = new int[10];
		for(int i=0; i<arr.length; i++) {
			arr[i] = r.nextInt(10); //0~9������ �������� ����
		}//�ʱ�ȭ ��
		System.out.println("==== �ʱ�ȭ �Ϸ� ======");
		for(int i : arr) System.out.print(i+" ");
		
		Arrays.sort(arr);
				
		System.out.println("\n======���ĿϷ�========");
		for(int i : arr) {
			System.out.print(i+" ");
		}
	}

}









