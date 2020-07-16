package hrd.vo;

public class Benefit {

	private int type;
	private int[] allowance = {5800, 18000};	// type 0: �Ʒü��� type1 : �뼺�� �Ʒ������������� �߰�
	
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
			return "[type= �Ʒü���, allowance= " + allowance[0] + "]";
		else if(type == 1)
			return "[type= ������� ��Ű��, allowance= " + allowance[1] + "]";
		else
			return "Type not defined";
	}
}
