package com.encore.test;

import com.encore.book.Book;
import com.encore.bookmanager.BookManager;
import com.encore.magazine.Magazine;

public class Test {

	public static void main(String[] args) {
		Book m1= new Magazine("12345678", "바람", "나","움찬" , 50000.0, "바람과 나 움찬", 1922, 4);
		Book m2= new Magazine("61615156", "태양", "넌","엔코아" , 70000.0, "태양 넌 엔코아", 1993, 1);
		Book m3= new Book("49184112", "불", "그","프레이터" , 80000.0, "불 그 프레이터");
		Book m4= new Book("16156151", "물", "그녀","나나" , 55000.0, "물 그녀 나나");

		
		Book[] bo = {m1,m2,m3, m4};
		BookManager manager = new BookManager();
		//System.out.println(manager.getNumberOfBooks(bo));
		
		
	}

}
