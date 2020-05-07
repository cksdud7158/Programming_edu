package hrd.vo;

public class Benefit {

	private int type;
	private int allowance;
	public Benefit(int type, int allowance) {
		super();
		this.type = type;
		this.allowance = allowance;
	}
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getAllowance() {
		return allowance;
	}
	public void setAllowance(int allowance) {
		this.allowance = allowance;
	}

	@Override
	public String toString() {
		return "Benefit [type=" + type + ", allowance=" + allowance + "]";
	}
	
	
	
	
}
