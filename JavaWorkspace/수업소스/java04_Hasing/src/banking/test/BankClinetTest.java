package banking.test;

import banking.Account;
import banking.Customer;

public class BankClinetTest {
	public static void main(String[] args) {
		Customer custom1 = new Customer("James", 1234);
		Account acc1 = new Account(10000);
		Account acc2 = new Account(23000);
		custom1.setAccount(acc1); //James가 통장을 하나 개설...
		custom1.setAccount(acc2);
		
		Account james=custom1.getAccount();
		System.out.println("5000원을 입금합니다...");
		james.deposit(5000.0);
		
		System.out.println("12000원을 입금합니다...");
		james.deposit(12000.0);
		
		System.out.println("7000원을 입출금합니다...");
		james.withdraw(7000.0);
		
		System.out.println("James's GetBalance...");
		System.out.println(james.getBalance());
	}
}
