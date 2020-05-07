package oop.encapsulation;
/*
 * ���� ���� �Է� : 1~12������ ���� �ް�..�� �̿��� ���� ������ �ʵ忡 �Ҵ���� �ʵ��� ������ �ۼ�
 * ��¥ �Է� : 
 *  1,3,5,7,8,10,12�� : 1~31��
 *  2�� : 1~28��
 *  4,6,9,11�� : 1~30�� ������ ���� ����ϵ��� �� ���� ��¥�� �ԷµǸ� �ʵ忡 �Ҵ���� �ʵ��� ������ �ۼ�
 */
public class MyDate {
	public int month;//0
	public int day;//0
	
	public int getMonth() {
		return month;
	}
	//���ú����� �ʵ��� �̸��� ������ �����ϱ� ���ؼ� �ʵ�տ� this�� �����Ѵ�.
	public void setMonth(int month) {
		if(month>=1 && month<=12) {
			this.month = month;
		}else {
			System.out.println("�߸��� ��!!");
			System.exit(0);
		}		
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		switch(month) {
		case 2:
			if(day>=1 && day<=28) {
				this.day = day;
			}else {
				//�ʵ� �ʱ�ȭ�� ����
				System.out.println("�߸��� ��¥!!");
				System.exit(0);
			}
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			if(day>=1 && day<=30) {
				this.day = day;
			}else {
				System.out.println("�߸��� ��¥!!");
				System.exit(0);
			}
			break;
		default:
			if(day>=1 && day<=31) {
				this.day = day;
			}else {
				System.out.println("�߸��� ��¥!!");
				System.exit(0);
			}
		}		
	}	
}




