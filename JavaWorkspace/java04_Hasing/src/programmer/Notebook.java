package programmer;

public class Notebook {
	private String brandName;
	private int price;
	
	public Notebook(String brandName, int price) {
		this.brandName = brandName;
		this.price = price;
	}
	
	public String getNoteBook() {
		return brandName+","+price;
	}
	
}
