package project1.vo;

public class SalaryMan {
	private int ssn; //unique key
	private String name;
	private int salary;
	private int hp = 100;
	private String position;
	private int account;
	
	SalaryMan() {}
	SalaryMan(int ssn, String name, String position) {}
	
	
	public int getSsn() {
		return ssn;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getHP() {
		return hp;
	}
	public void setHP(int hP) {
		hp = hP;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
	public int getAccount() {
		return account;
	}
	
	public void setAccount(int account) {
		this.account = account;
	}
	
	@Override
	public String toString() {
		return "주민번호: " + ssn + ", " + "이름" + name + ", " + "월급: " + salary + ", " + "체력: " + hp + ", " + "직위: " + position + ", " + "계좌 총액: " + account;
	}
}
