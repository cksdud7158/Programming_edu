package project1.vo;

public class Major extends SalaryMan {
	private int tax;
	private int salary = 400;
	
	public Major(int ssn, String name, int hp, String position) {
		super(ssn, name, hp, position);
	}

	public int getTax() {
		return tax;
	}

	public void setTax(int tax) {
		this.tax = tax;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + "¼¼±Ý: " + tax;
	}
	
	

}
