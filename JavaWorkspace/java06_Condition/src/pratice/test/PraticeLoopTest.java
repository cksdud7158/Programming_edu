package pratice.test;

public class PraticeLoopTest {

	public static void main(String[] args) {
		/*int num =1;
		int sum =0;
		
		do {
			sum+=num;
			num++;
		}while(num<=10);
		
		System.out.println("1���� 10������ ����"+sum+"�̴�.");*/
		
		/*int i;
		int sum;
		for(i=1,sum=0; i<11; i++) {
			sum+=i;
		}
		System.out.println("1���� 10������ ����"+sum+"�̴�.");*/
		
		/*int total =0;
		int num;
		
		for(num=1; num<=100; num++) {
			if(num%2==0) continue;
			total +=num;
		}
		System.out.println("1���� 100������ Ȧ���� ����"+total+"�̴�.");*/
		
		int sum =0;
		int num =0;
		
		for(num=0; ; num++) {
			sum+=num;
			if(sum>=100) break;
		}
		System.out.println(num);
		System.out.println(sum);
	}

}
