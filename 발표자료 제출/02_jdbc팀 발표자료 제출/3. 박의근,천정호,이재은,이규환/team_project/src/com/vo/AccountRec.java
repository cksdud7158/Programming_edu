package com.vo;

public class AccountRec {
	private String farmName;
	private int customerId;
	private int price;
	
	public AccountRec() {}
	
	public AccountRec(String farmName, int customerId, int price) {
		this.farmName = farmName;
		this.customerId = customerId;
		this.price = price;
	}

	public String getFarmName() {
		return farmName;
	}

	public void setFarmName(String farmName) {
		this.farmName = farmName;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
}
