package project1.vo;

public class Small extends SalaryMan {
	private int subsidy;
	private int salary = 250;
	
	public Small(int ssn, String name, int hp, String position) {
		super(ssn, name, hp, position);
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
		return super.toString() + "Áö¿ø±Ý: " + subsidy;
	}
	
	

}
