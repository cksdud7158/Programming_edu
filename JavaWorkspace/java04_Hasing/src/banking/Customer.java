package banking;
/*
 * 통장을 개설하고자 하는 고객의 정보를 저장하고 있는 클래스
 * Customer +Account --> Has a Realtion
 * 1. 필드에 Account를 선언
 * 2. Account를 주입 -> 생성자/ setter
 */

//고객만의 정보만 주입되는 건 setter 
//어카운트가 주입되는건 생성자
public class Customer {
	private String name;
	private int ssn;
	
	private Account account;//필드에 선언
	

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
