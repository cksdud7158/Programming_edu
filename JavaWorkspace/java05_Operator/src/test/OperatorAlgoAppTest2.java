package test;

import java.util.Scanner;

public class OperatorAlgoAppTest2 {
	static int halfDistance(int kim, int lim) {
		int cnt=0;
		/*
		 * kim�� lim�� ������ �����ʴٸ�
		 * ���ݾ� �پ��� ������ �ۼ� .
		 * �̶����� cnt�� 1�� �����ؾ���
		 */
		
		while(kim/2 != lim/2) {
			kim = kim-1/2;
			lim = lim-1/2;
			cnt++;
		}
		return cnt;
	}
	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		int kims = sc.nextInt()-1;
		int lims = sc.nextInt()-1;
		
		int result = halfDistance(kims, lims);
		System.out.println(result);
	}

}
