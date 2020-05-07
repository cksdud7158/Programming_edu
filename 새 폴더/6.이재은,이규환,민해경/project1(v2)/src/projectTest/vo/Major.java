package projectTest.vo;

public class Major extends SalaryMan {
	private int tax;
	
	public Major(int ssn, String name) {
		super(ssn, name);
		super.setSalary(400);
		super.setCompany("대기업 사원");
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
		return super.toString() + ", " + "직전 월의 세금 액수: " + tax + "만원";
	}

}
