package banking.test;

import banking.Account;
import banking.Customer;

public class BankClientTest {

	public static void main(String[] args) {
		/*
		 * james 라는 이름의 고객을 생성, 주민번호는 1234
		 * james가 잔액 10,000원을 가진 계좌를 하나 개설
		 * 새로 만든 계좌를 통해서 5,000원 , 12,000원 입금
		 * 7,000원 출금
		 * 최종적으로 James 통장의 잔액을 출금
		 */
		Customer custom1 = new Customer("James",1234); //james 라는 이름의 고객을 생성, 주민번호는 1234
		
		custom1.setAccount(new Account(10000));// james가 잔액 10,000원을 가진 계좌를 하나 개설
		
		Account james =custom1.getAccount();
		System.out.println("5,000원을 입금 합니다.");
		james.deposit(5000.0);
		
		System.out.println("12,000원을 입금 합니다.");
		james.deposit(120000.0);
		
		System.out.println("7,000원을 출금 합니다.");
		james.withdraw(7000);
		
		System.out.println("James's getBalance");
		System.out.println(james.getBalance());
		
		System.out.println();
		
	}

}
