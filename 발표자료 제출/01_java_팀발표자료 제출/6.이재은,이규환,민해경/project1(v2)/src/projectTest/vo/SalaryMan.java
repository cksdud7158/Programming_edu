package projectTest.vo;

public class SalaryMan {
	private int empNo;
	private String name;
	private int salary;
	private String company;
	private int hp;
	private int account;
	private boolean turn;
	
	public SalaryMan() {}
	public SalaryMan(int empNo, String name) {
		this.empNo = empNo;
		this.name = name;
		this.hp = 100;
		this.turn = false;
		this.account = 0;
	}
	
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
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

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getAccount() {
		return account;
	}

	public void setAccount(int account) {
		this.account = account;
	}

	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	public boolean isTurn() {
		return turn;
	}
	public void setTurn(boolean turn) {
		this.turn = turn;
	}
	
	@Override
	public String toString() {
		return "사원번호: " + empNo + ", 성명: " + name + ", 월급여: " +salary + "만원, 체력: " + hp + ", 소속기업: " + company + ", 계좌 총액: " + account + "만원, 남은 턴 수: "+ turn;   
	}
	
}
