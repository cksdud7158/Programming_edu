package oop.encapsulation.test;

import oop.encapsulation.MyDate;
/*
 * Encapsulation �ۼ� ����
 * 1. �ʵ� �� --> private
 * 2. setter()/ getter() --> public
 * 3. setter()�� ù ����(�ʵ� �ʱ�ȭ ����)���� ���� Ÿ�缺�� �˻��ϴ� ����� ���ؼ� valid�� ���� �ʵ忡 �Ҵ�ǵ��� �Ѵ�. 
 */
public class MyDateTest1 {

	public static void main(String[] args) {
		MyDate md = new MyDate();
		
		/*md.month =13;
		md.day =33;
*/
		md.setMonth(13);
		System.out.println(md.getMonth());
	}

}
