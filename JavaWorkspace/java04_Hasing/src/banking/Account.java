package banking;
/*
 * 통장에 정보를 저장하는 클래스
 */
public class Account {
	private double balance;
	
	public Account(double balance) {
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public void deposit(double amt) {
		//balance = balance + amt;
		balance += amt;
	}
	
	public void withdraw(double amt) {
		balance -= amt;
	}
}
