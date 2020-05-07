package com.vo;


public class Member {
	private int ssn;
	private String name;

	public Member(int ssn, String name) {
		this.ssn = ssn;
		this.name = name;
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
	
	@Override
	public String toString() {
		return ssn + ", " + name;
	}
}