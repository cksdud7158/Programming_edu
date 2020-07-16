package projectTest.vo;

public class Small extends SalaryMan {
	private int subsidy;
	
	public Small(int ssn, String name) {
		super(ssn, name);
		super.setSalary(250);
		super.setCompany("중소기업 사원");
	}
	
	public int getSubsidy() {
		return subsidy;
	}

	public void setSubsidy(int subsidy) {
		this.subsidy = subsidy;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + ", " + "직전 월의 지원금 액수: " + subsidy + "만원";
	}

}
