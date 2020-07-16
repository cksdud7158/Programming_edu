package corona.vo;

public class Person {
	private int ssn; 
	private String name;
	private String address1; // 도, 광역 단위 주소
	private String address2; // 시, 구군 단위 주소
	private int age;
	private String gender;
	private int infecter; // 날 감염시킨 사람
	private String test_condition; // 검사받은 날짜
	private String isolation; // 자가격리 시작 날짜
	private String country; // 국적
	
	public Person() {
		
	}
	
	public Person(int ssn, String name, String address1, String address2, int age, String gender, int infecter,
			String test_condition, String isolation, String country) {
		super();
		this.ssn = ssn;
		this.name = name;
		this.address1 = address1;
		this.address2 = address2;
		this.age = age;
		this.gender = gender;
		this.infecter = infecter;
		this.test_condition = test_condition;
		this.isolation = isolation;
		this.country = country;
	}

	public int getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getInfecter() {
		return infecter;
	}

	public void setInfecter(int infecter) {
		this.infecter = infecter;
	}

	public String getTest_condition() {
		return test_condition;
	}

	public void setTest_condition(String test_condition) {
		this.test_condition = test_condition;
	}

	public String getIsolation() {
		return isolation;
	}

	public void setIsolation(String isolation) {
		this.isolation = isolation;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Person [ssn=" + ssn + ", name=" + name + ", address1=" + address1 + ", address2=" + address2 + ", age="
				+ age + ", gender=" + gender + ", infecter=" + infecter + ", test_condition=" + test_condition
				+ ", isolation=" + isolation + ", country=" + country + "]\n";
	}
	
}
