package servlet.model;

public class BookVO {
	private String bookNum;
	private String bookName;
	private String bookCategory;
	private String publishingCountry;
	private String publishingDate;
	private String publisher;
	private String author;
	private int bookPrice;
	private String summaryContext;
	
	public BookVO(String bookNum, String bookName, String bookCategory, String publishingCountry, String publishingDate,
			String publisher, String author, int bookPrice, String summaryContext) {
		super();
		this.bookNum = bookNum;
		this.bookName = bookName;
		this.bookCategory = bookCategory;
		this.publishingCountry = publishingCountry;
		this.publishingDate = publishingDate;
		this.publisher = publisher;
		this.author = author;
		this.bookPrice = bookPrice;
		this.summaryContext = summaryContext;
	}
	public String getBookNum() {
		return bookNum;
	}
	public void setBookNum(String bookNum) {
		this.bookNum = bookNum;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookCategory() {
		return bookCategory;
	}
	public void setBookCategory(String bookCategory) {
		this.bookCategory = bookCategory;
	}
	public String getPublishingCountry() {
		return publishingCountry;
	}
	public void setPublishingCountry(String publishingCountry) {
		this.publishingCountry = publishingCountry;
	}
	public String getPublishingDate() {
		return publishingDate;
	}
	public void setPublishingDate(String publishingDate) {
		this.publishingDate = publishingDate;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}
	public String getSummaryContext() {
		return summaryContext;
	}
	public void setSummaryContext(String summaryContext) {
		this.summaryContext = summaryContext;
	}
	
	@Override
	public String toString() {
		return "BookVO [bookNum=" + bookNum + ", bookName=" + bookName + ", bookCategory=" + bookCategory
				+ ", publishingCountry=" + publishingCountry + ", publishingDate=" + publishingDate + ", publisher="
				+ publisher + ", author=" + author + ", bookPrice=" + bookPrice + ", summaryContext=" + summaryContext
				+ "]";
	}
	
	
	

	
	
}
