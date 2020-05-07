package self;

public class NoteBook {
	private String brandName;
	private int price;
	
	public NoteBook(String brandName, int price) {
		this.brandName = brandName;
		this.price = price;
	}
	public String getNotgeBook() {
		return brandName+","+price;
	}	
}
