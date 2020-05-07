package loop.test;
/*
 * 반복문
 * ::
 * 해당하는 조건이 참인동안 코드블락을 계속 수행하는 로직
 * for/ while/ do~while
 * 돌리는 횟수를 알 때 for
 * 모를 때 while
 */
public class BasicLoopTest1 {

	public static void main(String[] args) {
		System.out.println("============for=============");
		for(int i=0; i<=10; i++) { // 초기화, 조건식, 증감
				System.out.println(i+"Hello");
		}
		System.out.println("============while=============");
		int i=10;
		while(i>0) {
			System.out.println(i+"hello");
			i--;
		}
		System.out.println("============do~while=============");
		int j=0;
		do {
			System.out.println(j+"hello");
			j++;
		}while(j<10);
	}

}
