package banking;
/*
 * 통장의 정보를 저장하는 클래스..
 */
public class Account {
	private double balance;//10000---> 15000

	public Account(double balance) {
		this.balance = balance;
	}
	
	public void deposit(double amt) { //5000
		//balance = balance + amt;
		balance += amt;
	}
	public void withdraw(double amt) {
		balance -= amt;
	}

	public double getBalance() {
		return balance;
	}	
	
	
}




