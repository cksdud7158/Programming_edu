package com.encore.test;

import com.encore.book.Book;
import com.encore.bookmanager.BookManager;
import com.encore.magazine.Magazine;

public class Test {

	public static void main(String[] args) {
		Book m1= new Magazine("12345678", "�ٶ�", "��","����" , 50000.0, "�ٶ��� �� ����", 1922, 4);
		Book m2= new Magazine("61615156", "�¾�", "��","���ھ�" , 70000.0, "�¾� �� ���ھ�", 1993, 1);
		Book m3= new Book("49184112", "��", "��","��������" , 80000.0, "�� �� ��������");
		Book m4= new Book("16156151", "��", "�׳�","����" , 55000.0, "�� �׳� ����");

		
		Book[] bo = {m1,m2,m3, m4};
		BookManager manager = new BookManager();
		//System.out.println(manager.getNumberOfBooks(bo));
		
		
	}

}
