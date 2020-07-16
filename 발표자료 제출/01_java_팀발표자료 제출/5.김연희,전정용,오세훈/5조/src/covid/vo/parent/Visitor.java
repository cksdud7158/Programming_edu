package covid.vo.parent;

import covid.util.Fever;

public class Visitor {
	private String name;
	private boolean mask;
	private Fever fever = new Fever();
	private String symptom = null;
	
	public Visitor() {}
	public Visitor(String name, boolean mask, Fever fever) {
		this.name = name;
		this.mask = mask;
		this.fever = fever;
	}
	public Visitor(String name, boolean mask, Fever fever, String symptom) {
		this.name = name;
		this.mask = mask;
		this.fever = fever;
		this.symptom = symptom;
	} 
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isMask() {
		return mask;
	}
	public void setMask(boolean mask) {
		this.mask = mask;
	}
	public Fever getFever() {
		return fever;
	}
	public void setFever(Fever fever) {
		this.fever = fever;
	}
	public String getSymptom() {
		if(symptom != null)
			return symptom;
		else
			return null;
	}
	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}
	@Override
	public String toString() {
		if(symptom != null) {
			if(mask)
				return "�̸� : " + name + "\n����ũ ���� ���� : ����" + "\nü��) " + fever + "\n���� : " + symptom;
			else
				return "�̸� : " + name + "\n����ũ ���� ���� : ������" + "\nü��) " + fever + "\n���� : " + symptom;
		}
		else {
			if(mask)
				return "�̸� : " + name + "\n����ũ ���� ���� : ����" + "\nü��) " + fever + "\n���� : ����";
			else
				return "�̸� : " + name + "\n����ũ ���� ���� : ������" + "\nü��) " + fever + "\n���� : ����";
		}
	}
}
