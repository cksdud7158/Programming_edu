package condition.test;
/*
 * Math.random()�� �Բ�
 * switch �������� break Ű���忡 ���ؼ� ���캸��.
 */
public class SwitchNoBreakTest4 {

	public static void main(String[] args) {
		// Math. �ڿ� ������ Ű���忡�� S�� �پ��ִ� �̴� Stactic�� ��Ÿ���µ� �޸𸮿� �ö��־�� ��� ����, ��ü ������ ���� ���ص���
		/*double d=Math.random();
		System.out.println(d);
		
		int x=(int)(Math.random()*4)+1; // 1~4������ ������ ������ ���� 
		System.out.println(x);*/
		
		//8~11������ ������ ����
		int time=(int)(Math.random()*4+8);
		System.out.println("[����ð� : "+time+ " ��]");
		
		
		switch(time) {
			case 8:
				System.out.println("����մϴ�.");
			case 9:
				System.out.println("���� ȸ�� �մϴ�.");
			case 10:
				System.out.println("���� ���� ���ϴ�.");
			case 11:
				System.out.println("�ܱٳ����ϴ�.");
		}
	}

}
