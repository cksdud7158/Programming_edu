package covid.vo.child;

import covid.util.Fever;
import covid.vo.parent.Visitor;

public class Teacher extends Visitor {
	private int career;
	private String company;
	
	public Teacher() {}
	public Teacher(String name, boolean mask, Fever fever , int career, String company) {
		super(name, mask, fever);
		this.career = career;
		this.company = company;
	}
	public Teacher(String name, boolean mask, Fever fever ,  String symptom, int career, String company) {
		super(name, mask, fever, symptom);
		this.career = career;
		this.company = company;
	}
	public int getCareer() {
		return career;
	}
	public void setCareer(int career) {
		this.career = career;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	@Override
	public String toString() {
		return super.toString() + "\n상태 : 선생님" + "\n경력 : " + career + "\n소속 회사 : " + company;
	}	
}
