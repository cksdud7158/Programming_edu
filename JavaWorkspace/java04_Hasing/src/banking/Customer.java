package banking;
/*
 * ������ �����ϰ��� �ϴ� ���� ������ �����ϰ� �ִ� Ŭ����
 * Customer +Account --> Has a Realtion
 * 1. �ʵ忡 Account�� ����
 * 2. Account�� ���� -> ������/ setter
 */

//������ ������ ���ԵǴ� �� setter 
//��ī��Ʈ�� ���ԵǴ°� ������
public class Customer {
	private String name;
	private int ssn;
	
	private Account account;//�ʵ忡 ����
	

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}



	public Customer(String name, int ssn) {
		super();
		this.name = name;
		this.ssn = ssn;
	}


	
	public String getCustinfo() {
		return name+","+ssn;
	}
}
