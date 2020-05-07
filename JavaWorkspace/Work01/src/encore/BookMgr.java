package encore;

import java.util.ArrayList;



public interface BookMgr {

	public void addBook(Book b);
	public ArrayList<Book> getAllBook();
	public Book searchBookByIsbn(String isbn);
	public ArrayList<Book> searchBookByTitle(String title);
	public ArrayList<Book> onlySearchBook();
	public ArrayList<Book> onlySearchMagazin();
	public ArrayList<Book> magazineOfThisYearInfo(int year);
	public ArrayList<Book> searchBookByPublish(String publish);
	public ArrayList<Book> searchBookByPrice(int price);
	public int getTotalPrice();
	public int getAvgPrice();

}
