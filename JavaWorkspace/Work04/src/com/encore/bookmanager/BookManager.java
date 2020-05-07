package com.encore.bookmanager;

import com.encore.book.Book;
import com.encore.magazine.Magazine;

public class BookManager {
	private int numberOfBooks;
	Book[ ] bo;
	int bidx;
/*	
	public int getNumberOfBooks() {
		return books = numberOfBooks;
	}*/
	public void insertBook(Book b){
		bo[bidx++] = b;
	}
}
