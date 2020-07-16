package hrd.vo;

public class Benefit {

	private int type;
	private int[] allowance = {5800, 18000};	// type 0: 훈련수당 type1 : 취성패 훈련참여지원수당 추가
	
	public Benefit(int type) {
		super();
		this.type = type;
	}
	
	public int getType() {
		return type;
	}
	
	public void setType(int type) {
		this.type = type;
	}
	
	public int getAllowance() {
		return allowance[type];
	}

	@Override
	public String toString() {
		if(type == 0)
			return "[type= 훈련수당, allowance= " + allowance[0] + "]";
		else if(type == 1)
			return "[type= 취업성공 패키지, allowance= " + allowance[1] + "]";
		else
			return "Type not defined";
	}
}
