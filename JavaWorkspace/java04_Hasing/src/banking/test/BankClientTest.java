package banking.test;

import banking.Account;
import banking.Customer;

public class BankClientTest {

	public static void main(String[] args) {
		/*
		 * james ��� �̸��� ���� ����, �ֹι�ȣ�� 1234
		 * james�� �ܾ� 10,000���� ���� ���¸� �ϳ� ����
		 * ���� ���� ���¸� ���ؼ� 5,000�� , 12,000�� �Ա�
		 * 7,000�� ���
		 * ���������� James ������ �ܾ��� ���
		 */
		Customer custom1 = new Customer("James",1234); //james ��� �̸��� ���� ����, �ֹι�ȣ�� 1234
		
		custom1.setAccount(new Account(10000));// james�� �ܾ� 10,000���� ���� ���¸� �ϳ� ����
		
		Account james =custom1.getAccount();
		System.out.println("5,000���� �Ա� �մϴ�.");
		james.deposit(5000.0);
		
		System.out.println("12,000���� �Ա� �մϴ�.");
		james.deposit(120000.0);
		
		System.out.println("7,000���� ��� �մϴ�.");
		james.withdraw(7000);
		
		System.out.println("James's getBalance");
		System.out.println(james.getBalance());
		
		System.out.println();
		
	}

}
